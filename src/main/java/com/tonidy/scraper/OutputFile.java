package com.tonidy.scraper;

public enum OutputFile {
    CSV,
    JSON;

    // converter that will be used later
    public static OutputFile fromString(String code) {
 
        for(OutputFile output : OutputFile.values()) {
            if(output.toString().equalsIgnoreCase(code)) {
                return output;
            }
        }
 
        return null;
    }
}