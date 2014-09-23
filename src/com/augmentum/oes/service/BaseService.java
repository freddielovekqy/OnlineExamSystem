package com.augmentum.oes.service;


import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import com.augmentum.oes.exception.VerificationException;

public abstract class BaseService {

    protected Validator validator = null;

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    protected boolean validateObject(Object object) throws VerificationException {

        List<ConstraintViolation> violations = validator.validate(object);

        if (violations != null && !violations.isEmpty()) {
            VerificationException verificationExacption = new VerificationException();

            for (ConstraintViolation violation : violations) {
                String ovalField = violation.getContext().toString();
                String fieldName = ovalField.substring(ovalField.lastIndexOf(".") + 1, ovalField.length());
                String message = violation.getMessage();

                verificationExacption.add(fieldName, message);
            }

            if (verificationExacption.getExceptionMap() != null) {
                throw verificationExacption;
            }
        }

        return true;
    }
}
