package by.iba.repository;

import by.iba.builder.OrderBuilder;
import by.iba.exception.RepositoryException;
import by.iba.model.Order;
import by.iba.repository.dbconstants.OrderTableConstants;
import by.iba.repository.specification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderRepository extends AbstractRepository<Order> {
    private static final String TABLE_NAME = "orders";

    public OrderRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<Order> query(String sqlString, Parameter paramater) throws RepositoryException {
        String query = sqlString;
        List<Order> orders = executeQuery(query, new OrderBuilder(), paramater.getParameters());
        return orders;
    }

    @Override
    public Optional<Order> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<Order> order = query(sqlString, parameter);
        return order.size() == 1 ? Optional.of(order.get(0)) : Optional.empty();
    }

    public Map<String, Object> getFields(Order order) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(OrderTableConstants.PERSONID.getFieldName(), order.getPersonId());
        fields.put(OrderTableConstants.SPORTOFFERID.getFieldName(), order.getSportOfferId());
        fields.put(OrderTableConstants.QUANTITYOFDAY.getFieldName(), order.getQuantityOfDay());
        fields.put(OrderTableConstants.MONTH.getFieldName(), order.getMonth());
        return fields;
    }
}
