package com.tonidy.scraper.CLI;

public enum FileType {
    CSV,
    JSON;

    // converter that will be used later
    public static FileType fromString(String code) {

        for (FileType output : FileType.values()) {
            if (output.toString().equalsIgnoreCase(code)) {
                return output;
            }
        }

        return null;
    }
}