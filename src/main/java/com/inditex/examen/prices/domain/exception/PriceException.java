package com.inditex.examen.prices.domain.exception;

import java.io.Serial;

public class PriceException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public PriceException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public PriceException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
