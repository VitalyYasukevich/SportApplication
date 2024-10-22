package by.iba.builder;

import by.iba.exception.RepositoryException;
import by.iba.model.Order;
import by.iba.repository.dbconstants.OrderTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBuilder implements Builder<Order>{
    @Override
    public Order build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(OrderTableConstants.ID.getFieldName());
            int personId =
                    resultSet.getInt(OrderTableConstants.PERSONID.getFieldName());
            int sportOfferId =
                    resultSet.getInt(OrderTableConstants.SPORTOFFERID.getFieldName());
            int quantityOfDay= resultSet.getInt(OrderTableConstants.QUANTITYOFDAY.getFieldName());
            String month =
                    resultSet.getString(OrderTableConstants.MONTH.getFieldName());
            return new Order(id, personId, sportOfferId, quantityOfDay, month);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }
}
