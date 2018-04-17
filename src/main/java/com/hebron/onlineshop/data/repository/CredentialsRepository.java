package com.hebron.onlineshop.data.repository;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.util.VoidOperationResult;

public interface CredentialsRepository {

    VoidOperationResult checkCredentials(AuthorizationDTO authorization);
    VoidOperationResult saveCredentials(AuthorizationDTO authorization);
}
