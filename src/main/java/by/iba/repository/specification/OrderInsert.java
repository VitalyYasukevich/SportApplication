package by.iba.repository.specification;


import java.util.Arrays;
import java.util.List;

public class OrderInsert implements Parameter{
    private int personId;
    private int sportOfferId;
    private int quantityOfDay;
    private String month;

    public OrderInsert(int personId, int sportOfferId, int quantityOfDay, String month) {

        this.personId = personId;
        this.sportOfferId = sportOfferId;
        this.quantityOfDay = quantityOfDay;
        this.month = month;
    }

    @Override
    public List<Object> getParameters() {

        return Arrays.asList(personId, sportOfferId, quantityOfDay, month);
    }
}
