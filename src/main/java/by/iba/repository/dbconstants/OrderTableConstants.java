package by.iba.repository.dbconstants;

public enum OrderTableConstants {
    ID("id"),
    PERSONID("personid"),
    SPORTOFFERID("sportofferid"),
    QUANTITYOFDAY("quantityofday"),
    MONTH("month");

    private String fieldName;

    private OrderTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
