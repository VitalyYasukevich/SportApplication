package by.iba.service;

import by.iba.dto.CommonInfoDto;
import by.iba.dto.MonthPriceDto;
import by.iba.model.Order;
import by.iba.model.Person;
import by.iba.model.SportOffer;

public interface MonthPriceMapper {
    //void map(Order b, SportOffer c, MonthPriceDto d);
    void map(String month, float price, MonthPriceDto d);
}
