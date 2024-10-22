package by.iba.service;

import by.iba.dto.CommonInfoDto;
import by.iba.model.Order;
import by.iba.model.Person;
import by.iba.model.SportOffer;

public interface CommonInfoMapper {
    void map(Person a, Order b, SportOffer c, CommonInfoDto d);//TODO:rename
}
