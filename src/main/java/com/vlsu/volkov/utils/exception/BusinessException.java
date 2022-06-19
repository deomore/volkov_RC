package com.vlsu.volkov.utils.exception;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BusinessException extends RuntimeException {
    private ErrorCode code;
}

