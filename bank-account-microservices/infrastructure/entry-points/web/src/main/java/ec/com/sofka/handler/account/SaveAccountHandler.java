package ec.com.sofka.handler.account;

import ec.com.sofka.data.AccountRequestDTO;
import ec.com.sofka.data.AccountResponseDTO;
import ec.com.sofka.mapper.AccountMapper;
import ec.com.sofka.usecase.account.SaveAccountUseCase;
import org.springframework.stereotype.Component;

@Component
public class SaveAccountHandler {
    private final SaveAccountUseCase saveAccountUseCase;

    public SaveAccountHandler(SaveAccountUseCase saveAccountUseCase) {
        this.saveAccountUseCase = saveAccountUseCase;
    }

    public AccountResponseDTO saveAccount(AccountRequestDTO account) {
        return AccountMapper.toResponseDTO(
                saveAccountUseCase.execute(AccountMapper.toModel(account)));
    }

}