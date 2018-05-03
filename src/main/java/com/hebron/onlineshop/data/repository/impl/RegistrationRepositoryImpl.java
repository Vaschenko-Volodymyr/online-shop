package com.hebron.onlineshop.data.repository.impl;

import com.hebron.onlineshop.data.database.tables.UserDetailsTable;
import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.data.repository.RegistrationRepository;
import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.dto.utils.DataDTO;
import com.hebron.onlineshop.util.VoidOperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepositoryImpl extends AbstractRepository implements RegistrationRepository {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public VoidOperationResult register(RegistrationDTO registration) {
        VoidOperationResult result = new VoidOperationResult();

        VoidOperationResult saveCredentialsResult = credentialsRepository.saveCredentials(registration.getAuthorization());

        if (!saveCredentialsResult.isSuccess()) {
            result.setSuccess(false);
            result.setErrorMessage(saveCredentialsResult.getErrorMessage());
            return result;
        }

        DataDTO data = registration.getBirth();
        String query = "INSERT INTO " + UserDetailsTable.NAME + " VALUES (" +
                registration.getFirstName() + "," +
                registration.getSecondName() + "," +
                data.getYear() + "," +
                data.getMonth().getValue() + "," +
                data.getDay().getValue() + "," +
                registration.getPhone() + "," +
                registration.getEmail() + "," +
                registration.getCity() + "," +
                registration.getGender().getValue() + ")";

        DatabaseResponse databaseResponse = executeQuery(query);

        if (databaseResponse.isSuccess()) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
            result.setErrorMessage(databaseResponse.getErrorMessage());
        }
        return result;
    }
}
