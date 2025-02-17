package ec.com.sofka.handler.account;

import ec.com.sofka.data.AccountResponseDTO;
import ec.com.sofka.mapper.AccountMapper;
import ec.com.sofka.usecase.account.FindAllAccountsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllAccountsHandler {
    private final FindAllAccountsUseCase findAllAccountsUseCase;

    public FindAllAccountsHandler(FindAllAccountsUseCase findAllAccountsUseCase) {
        this.findAllAccountsUseCase = findAllAccountsUseCase;
    }

    public List<AccountResponseDTO> findAllAccounts() {
        return findAllAccountsUseCase.execute().stream()
                .map(AccountMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}