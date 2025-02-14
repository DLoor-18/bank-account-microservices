package ec.com.sofka.handler.account;

import ec.com.sofka.data.AccountResponseDTO;
import ec.com.sofka.data.AccountUpdateRequestDTO;
import ec.com.sofka.mapper.AccountMapper;
import ec.com.sofka.usecase.account.UpdateAccountUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountHandler {
    private final UpdateAccountUseCase updateAccountUseCase;

    public UpdateAccountHandler(UpdateAccountUseCase updateAccountUseCase) {
        this.updateAccountUseCase = updateAccountUseCase;
    }

    public AccountResponseDTO updateAccount(AccountUpdateRequestDTO account) {
        return AccountMapper.toResponseDTO(
                updateAccountUseCase.execute(AccountMapper.updateToModel(account)));
    }

}