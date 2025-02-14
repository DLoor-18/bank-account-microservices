package ec.com.sofka.handler.account;

import ec.com.sofka.data.AccountResponseDTO;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.mapper.AccountMapper;
import ec.com.sofka.usecase.account.FindAllAccountsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllAcountsHandler {
    private final FindAllAccountsUseCase findAllAccountsUseCase;

    public FindAllAcountsHandler(FindAllAccountsUseCase findAllAccountsUseCase) {
        this.findAllAccountsUseCase = findAllAccountsUseCase;
    }

    public List<AccountResponseDTO> findAllAcounts() {
        return findAllAccountsUseCase.execute().stream()
                .map(AccountMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}