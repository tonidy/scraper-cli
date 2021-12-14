package com.tonidy.scraper.CLI.Validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class TotalProductsValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        int totalProducts = Integer.parseInt(value);
 
        if(totalProducts < 0) {
            throw new ParameterException("Parameter " + name + " should be positive number");
        }
    }
    
}
