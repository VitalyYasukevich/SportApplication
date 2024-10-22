package by.iba.service;

import by.iba.dto.CommonInfoDto;
import by.iba.dto.MonthPriceDto;
import by.iba.exception.RepositoryException;
import by.iba.exception.ServiceException;
import by.iba.model.Order;
import by.iba.model.Person;
import by.iba.model.SportOffer;
import by.iba.repository.OrderRepository;
import by.iba.repository.PersonRepository;
import by.iba.repository.RepositoryCreator;
import by.iba.repository.SportOfferRepository;
import by.iba.service.impl.CommonInfoMapperImpl;
import by.iba.service.impl.MonthPriceMapperImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthPriceService {
    public List<MonthPriceDto> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            OrderRepository orderRepository = repositoryCreator.getOrderRepository();//replace with service
            List<Order> orderList = orderRepository.findAll();

            SportOfferRepository sportOfferRepository = repositoryCreator.getSportOfferRepository();//replace with service
            List<SportOffer> sportOfferList = sportOfferRepository.findAll();


            MonthPriceMapperImpl mapper = new MonthPriceMapperImpl();
            List<MonthPriceDto> monthPriceDtos = new ArrayList<>();
            HashMap<String, Float> hashMap = new HashMap<String, Float>();
            for (Order order : orderList) {
                if(!hashMap.containsKey(order.getMonth())){
                    hashMap.put(order.getMonth(), 0.0f);
                }


                for (SportOffer sportOffer : sportOfferList) {
                    if (sportOffer.getId() == order.getSportOfferId()) {
                       // price += (sportOffer.getPrice() * order.getQuantityOfDay());

                            hashMap.put(order.getMonth(), hashMap.get(order.getMonth()) + (sportOffer.getPrice() * order.getQuantityOfDay()));
                        }

                }

               /* mapper.map(order, price, monthPriceDto);
                monthPriceDtos.add(monthPriceDto);*/
            }
            for (String key : hashMap.keySet()) {
               // System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
                MonthPriceDto monthPriceDto = new MonthPriceDto();
                mapper.map(key, hashMap.get(key), monthPriceDto);
                monthPriceDtos.add(monthPriceDto);
            }

            return monthPriceDtos;
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
