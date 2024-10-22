package by.iba.repository.specification;

import java.util.Arrays;
import java.util.List;

public class SportOfferInsert implements Parameter{
    private String name;
    private float price;

    public SportOfferInsert(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public List<Object> getParameters() {

        return Arrays.asList(name, price);
    }
}
