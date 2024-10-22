package by.iba.service.impl;

import by.iba.dto.MonthPriceDto;
import by.iba.model.Order;
import by.iba.service.MonthPriceMapper;

public class MonthPriceMapperImpl implements MonthPriceMapper {
    @Override
    public void map(String month, float price, MonthPriceDto d){
        d.setPrice(price);
        d.setMonth(month);
    }
}
