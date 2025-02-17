package ec.com.sofka.usecase.movement;

import ec.com.sofka.Account;
import ec.com.sofka.data.Customer;
import ec.com.sofka.data.CustomerResponse;
import ec.com.sofka.data.MovementsData;
import ec.com.sofka.exceptions.EmptyCollectionException;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.CustomerDataBussMessage;
import ec.com.sofka.gateway.MovementRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FindMovementsByConsumerUseCase {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;
    private final CustomerDataBussMessage customerDataBussMessage;

    public FindMovementsByConsumerUseCase(MovementRepository movementRepository, AccountRepository accountRepository, CustomerDataBussMessage customerDataBussMessage) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
        this.customerDataBussMessage = customerDataBussMessage;
    }

    public List<MovementsData> execute(String identificationCustomer, LocalDateTime startDate, LocalDateTime endDate) {
        CustomerResponse customer = (CustomerResponse) customerDataBussMessage.sendMessage(identificationCustomer);

        if (customer == null) {
            throw new EmptyCollectionException("Customer not found");
        }
        List<Account> accounts = accountRepository.findByCustomerId(customer.getCustomerId());

        if (accounts.isEmpty()) {
            throw new EmptyCollectionException("Customer haven't accounts");
        }


        List<String> accountsNumber = new ArrayList<>();
        accounts.forEach(account -> accountsNumber.add(account.getNumberAccount()));

        List<MovementsData> movementsData = new ArrayList<>();

        movementRepository.findMovementsByDateRangeAndAccounts(startDate, endDate, accountsNumber).forEach(movement -> {
            Account nowAccount = accounts.stream()
                    .filter(account -> account.getNumberAccount().equals(movement.getAccountNumber())).findFirst().orElse(null);

            if (nowAccount == null) {
                return;
            }
            movementsData.add(
                    new MovementsData(movement.getDate(),
                            customer.getName(),
                            movement.getAccountNumber(),
                            movement.getMovementType(),
                            nowAccount.getOpeningBalance(),
                            nowAccount.getStatus(),
                            movement.getValue(),
                            nowAccount.getBalance()
                            ));
        });

        return movementsData;

    }
}