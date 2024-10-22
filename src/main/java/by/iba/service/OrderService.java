package by.iba.service;


import by.iba.exception.RepositoryException;
import by.iba.exception.ServiceException;
import by.iba.model.Order;
import by.iba.repository.OrderRepository;
import by.iba.repository.RepositoryCreator;
import by.iba.repository.specification.Parameter;

import java.util.List;

public class OrderService {
    public List<Order> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Order> findAll2() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.findAll2();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void save(Order order) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            orderRepository.save(order);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }


}
