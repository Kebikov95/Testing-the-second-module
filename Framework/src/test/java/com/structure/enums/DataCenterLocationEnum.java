package com.structure.enums;

public enum DataCenterLocationEnum {
    IOWA("Iowa (us-central1)"),
    SOUTH_CAROLINA("South Carolina (us-east1)"),
    NORTHERN_VIRGINIA("Northern Virginia (us-east4)"),
    OREGON("Oregon (us-west1)"),
    LOS_ANGELES("Los Angeles (us-west2)"),
    SALT_LAKE_CITY("Salt Lake City (us-west3)"),
    LAS_VEGAS("Las Vegas (us-west4)"),
    BELGIUM("Belgium (europe-west1)"),
    LONDON("London (europe-west2)"),
    FRANKFURT("Frankfurt (europe-west3)"),
    TAIWAN("Taiwan (asia-east1)"),
    HONG_KONG("Hong Kong (asia-east2)"),
    TOKYO("Tokyo (asia-northeast1)"),
    OSAKA("Osaka (asia-northeast2)"),
    SEOUL("Seoul (asia-northeast3)"),
    SINGAPORE("Singapore (asia-southeast1)"),
    JAKARTA("Jakarta (asia-southeast2)"),
    MUMBAI("Mumbai (asia-south1)"),
    SYDNEY("Sydney (australia-southeast1)"),
    SAO_PAULO("Sao Paulo (southamerica-east1)"),
    NETHERLANDS("Netherlands (europe-west4)"),
    ZURICH("Zurich (europe-west6)"),
    FINLAND("Finland (europe-north1)"),
    MONTREAL("Montréal, Canada (northamerica-northeast1)");

    private String timeName;

    DataCenterLocationEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}
