package by.iba.service.impl;

import by.iba.dto.CommonInfoDto;
import by.iba.model.Order;
import by.iba.model.Person;
import by.iba.model.SportOffer;
import by.iba.service.CommonInfoMapper;


public class CommonInfoMapperImpl implements CommonInfoMapper {
    @Override
    public void map(Person a, Order b, SportOffer c, CommonInfoDto d){
        d.setName(a.getName());
        d.setPhone(a.getPhone());
        d.setEmail(a.getEmail());
        d.setNameOffer(c.getNameOffer());
        d.setPrice(c.getPrice());
        d.setQuantityOfDay(b.getQuantityOfDay());
        d.setMonth(b.getMonth());
    }
}
