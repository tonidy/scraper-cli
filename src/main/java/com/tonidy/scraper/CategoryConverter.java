package com.tonidy.scraper;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

public class CategoryConverter implements IStringConverter<Category> {

    @Override
    public Category convert(String value) {
        var convertedValue = Category.fromString(value);

        if (convertedValue == null) {
            throw new ParameterException("Value " + value + "can not be converted to OutputFile.");
        }
        return convertedValue;
    }
}