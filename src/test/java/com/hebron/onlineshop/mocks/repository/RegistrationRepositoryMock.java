package com.hebron.onlineshop.mocks.repository;

import com.hebron.onlineshop.data.repository.RegistrationRepository;
import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.util.Messages;
import com.hebron.onlineshop.util.VoidOperationResult;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepositoryMock extends AbstractUserRepoMock implements RegistrationRepository {

    @Override
    public VoidOperationResult register(RegistrationDTO registration) {
        VoidOperationResult result = new VoidOperationResult();

        if (!logins.contains(registration.getAuthorization().getLogin())) {
            result.setSuccess(false);
            result.setErrorMessage(Messages.WRONG_CREDENTIALS);
        } else {
            result.setSuccess(true);
        }

        return result;
    }
}
