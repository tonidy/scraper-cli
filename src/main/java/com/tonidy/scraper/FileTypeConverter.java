package com.tonidy.scraper;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

public class FileTypeConverter implements IStringConverter<FileType> {

    @Override
    public FileType convert(String value) {
        var convertedValue = FileType.fromString(value);

        if (convertedValue == null) {
            throw new ParameterException("Value " + value + "can not be converted to OutputFile. " +
                    "Available values are: csv, json.");
        }
        return convertedValue;
    }
}