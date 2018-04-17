package com.hebron.onlineshop.data.repository.impl;

import com.hebron.onlineshop.data.database.tables.CredentialsTable;
import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.util.VoidOperationResult;
import org.springframework.stereotype.Repository;

@Repository
public class CredentialsRepositoryImpl extends AbstractRepository implements CredentialsRepository {

    @Override
    public VoidOperationResult checkCredentials(AuthorizationDTO authorization) {
        VoidOperationResult result = new VoidOperationResult();

        String query = "SELECT " + CredentialsTable.LOGIN + ", " + CredentialsTable.PASSWORD + " " +
                "FROM credentials " +
                "WHERE " +
                CredentialsTable.LOGIN + " = " + authorization.getLogin() + " " +
                "AND " +
                CredentialsTable.PASSWORD + " = " + authorization.getPassword();
        DatabaseResponse databaseResponse = executeQuery(query);

        if (databaseResponse.isSuccess()) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
            result.setErrorMessage(databaseResponse.getErrorMessage());
        }
        return result;
    }

    @Override
    public VoidOperationResult saveCredentials(AuthorizationDTO authorization) {
        VoidOperationResult result = new VoidOperationResult();

        String query = "INSERT INTO credentials VALUES(" +
                authorization.getLogin() + "," +
                authorization.getPassword() + ")";

        DatabaseResponse databaseResponse = executeQuery(query);

        if  (databaseResponse.isSuccess()) {
            result.setSuccess(true);
        } else {
            // TODO: set correct error message depend on exception
            result.setSuccess(false);
            result.setErrorMessage(databaseResponse.getErrorMessage());
        }
        return result;
    }
}
