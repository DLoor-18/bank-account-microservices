package ec.com.sofka.usecase.movement;

import ec.com.sofka.Account;
import ec.com.sofka.Movement;
import ec.com.sofka.exceptions.ConflictException;
import ec.com.sofka.exceptions.TransactionRejectedException;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.MovementRepository;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

public class SaveMovementUseCase {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;

    public SaveMovementUseCase(MovementRepository movementRepository, AccountRepository accountRepository) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Movement execute(Movement movement) {
        Account account = accountRepository.findByNumberAccount(movement.getAccountNumber());
        if ( account != null) {
            BigDecimal calculatedBalance = account.getBalance().add(movement.getValue());
            if (calculatedBalance.compareTo(BigDecimal.ZERO) >= 0) {
                account.setBalance(calculatedBalance);
                movement.setBalance(calculatedBalance);

                accountRepository.update(account);
                return movementRepository.save(movement);
            }

            throw new TransactionRejectedException("Account dont have enough balance");
        }

        throw new ConflictException("Number account of account not exists");
    }
}