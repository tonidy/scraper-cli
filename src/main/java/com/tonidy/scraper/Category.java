package com.tonidy.scraper;

public enum Category {
    BUKU,
    DAPUR,
    ELEKTRONIK,
    GAMING,
    HANDPHONE_TABLET,
    KAMERA,
    OTOMOTIF;
 
    // converter that will be used later
    public static Category fromString(String code) {
 
        for(Category output : Category.values()) {
            if(output.toString().equalsIgnoreCase(code)) {
                return output;
            }
        }
 
        return null;
    }
}
