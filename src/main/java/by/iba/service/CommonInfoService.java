package by.iba.service;


import by.iba.dto.CommonInfoDto;
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

import java.util.ArrayList;
import java.util.List;

public class CommonInfoService {

    public List<CommonInfoDto> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            PersonRepository personRepository = repositoryCreator.getPersonRepository();//replace with service
            List<Person> personList =  personRepository.findAll();

            OrderRepository orderRepository = repositoryCreator.getOrderRepository();//replace with service
            List<Order> orderList =  orderRepository.findAll();

            SportOfferRepository sportOfferRepository = repositoryCreator.getSportOfferRepository();//replace with service
            List<SportOffer> sportOfferList =  sportOfferRepository.findAll();



            CommonInfoMapper mapper = new CommonInfoMapperImpl();
            List<CommonInfoDto> commonInfoDtos = new ArrayList<>();
            for(Order order : orderList)  {
                Person person1 = new Person();
                //Order order1 = new Order();
                SportOffer sportOffer1 = new SportOffer();
                CommonInfoDto commonInfoDto = new CommonInfoDto();

                for (Person person : personList) {
                    if (person.getId() == order.getPersonId()) {
                        person1 = person;
                    }
                }

                for (SportOffer sportOffer : sportOfferList) {
                    if (sportOffer.getId() == order.getSportOfferId()) {
                        sportOffer1 = sportOffer;
                    }
                }

                mapper.map(person1, order, sportOffer1, commonInfoDto);
                commonInfoDtos.add(commonInfoDto);
            }

            return commonInfoDtos;
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /*public void save(CommonInfoDto commonInfoDto) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CommonInfoRepository commonInfoRepository = repositoryCreator.getCommonInfoRepository();
            commonInfoRepository.save(commonInfoDto);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }*/


}
