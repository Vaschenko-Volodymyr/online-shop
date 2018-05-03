package com.hebron.onlineshop.mocks.repository;

import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.util.Messages;
import com.hebron.onlineshop.util.VoidOperationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CredentialsRepositoryMock extends AbstractUserRepoMock implements CredentialsRepository {

    @Override
    public VoidOperationResult checkCredentials(AuthorizationDTO authorization) {
        VoidOperationResult result = new VoidOperationResult();

        if (logins.contains(authorization.getLogin()) && passwords.contains(authorization.getPassword())) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
            result.setErrorMessage(Messages.WRONG_CREDENTIALS);
        }
        return result;
    }

    @Override
    public VoidOperationResult saveCredentials(AuthorizationDTO authorization) {
        VoidOperationResult result = new VoidOperationResult();

        log.info("MOCK: saved {} and {}", authorization.getLogin(), authorization.getPassword());
        result.setSuccess(true);
        return result;
    }
}
