package by.iba.builder;

import by.iba.exception.RepositoryException;
import by.iba.model.SportOffer;
import by.iba.repository.dbconstants.SportOfferTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SportOfferBuilder implements Builder<SportOffer>{
    @Override
    public SportOffer build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(SportOfferTableConstants.ID.getFieldName());
            String name =
                    resultSet.getString(SportOfferTableConstants.NAMEOFFER.getFieldName());
            float price =
                    resultSet.getFloat(SportOfferTableConstants.PRICE.getFieldName());
            return new SportOffer(id, name, price);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }
}
