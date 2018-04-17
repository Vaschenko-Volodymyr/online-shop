package com.hebron.onlineshop.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDataOperationResult<DATA> extends VoidOperationResult {

    private DATA data;
}
