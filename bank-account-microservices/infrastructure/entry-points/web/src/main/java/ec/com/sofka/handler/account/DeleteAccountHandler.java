package ec.com.sofka.handler.account;

import ec.com.sofka.data.DeleteRequestDTO;
import ec.com.sofka.usecase.account.DeleteAccountUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteAccountHandler {
    private final DeleteAccountUseCase deleteAccountUseCase;

    public DeleteAccountHandler(DeleteAccountUseCase deleteAccountUseCase) {
        this.deleteAccountUseCase = deleteAccountUseCase;
    }

    public void delete(DeleteRequestDTO accountId) {
        deleteAccountUseCase.execute(accountId.getId());
    }

}