package ec.com.sofka.controller;

import ec.com.sofka.data.AccountRequestDTO;
import ec.com.sofka.data.AccountResponseDTO;
import ec.com.sofka.data.AccountUpdateRequestDTO;
import ec.com.sofka.data.DeleteRequestDTO;
import ec.com.sofka.handler.account.DeleteAccountHandler;
import ec.com.sofka.handler.account.FindAllAcountsHandler;
import ec.com.sofka.handler.account.SaveAccountHandler;
import ec.com.sofka.handler.account.UpdateAccountHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final DeleteAccountHandler deleteAccountHandler;
    private final FindAllAcountsHandler findAllAcountsHandler;
    private final SaveAccountHandler saveAccountHandler;
    private final UpdateAccountHandler updateAccountHandler;

    public AccountController(DeleteAccountHandler deleteAccountHandler, FindAllAcountsHandler findAllAcountsHandler, SaveAccountHandler saveAccountHandler, UpdateAccountHandler updateAccountHandler) {
        this.deleteAccountHandler = deleteAccountHandler;
        this.findAllAcountsHandler = findAllAcountsHandler;
        this.saveAccountHandler = saveAccountHandler;
        this.updateAccountHandler = updateAccountHandler;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> saveAccount(@Valid @RequestBody AccountRequestDTO account) {
        AccountResponseDTO accountResponseDTO = saveAccountHandler.saveAccount(account);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(findAllAcountsHandler.findAllAcounts());
    }

    @PutMapping
    public ResponseEntity<AccountResponseDTO> updateAccount(@Valid @RequestBody AccountUpdateRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(updateAccountHandler.updateAccount(customerRequestDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@Valid @RequestBody DeleteRequestDTO accountRequestDTO) {
        deleteAccountHandler.delete(accountRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}