package com.tonidy.scraper;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

public class OutputFileConverter implements IStringConverter<OutputFile> {

    @Override
    public OutputFile convert(String value) {
        var convertedValue = OutputFile.fromString(value);

        if (convertedValue == null) {
            throw new ParameterException("Value " + value + "can not be converted to OutputFile. " +
                    "Available values are: csv, json.");
        }
        return convertedValue;
    }
}