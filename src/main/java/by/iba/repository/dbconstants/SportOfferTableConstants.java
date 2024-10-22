package by.iba.repository.dbconstants;

public enum SportOfferTableConstants {
    ID("id"),
    NAMEOFFER("nameOffer"),
    PRICE("price");

    private String fieldName;

    private SportOfferTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
