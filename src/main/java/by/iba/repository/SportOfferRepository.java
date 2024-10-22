package by.iba.repository;

import by.iba.builder.SportOfferBuilder;
import by.iba.exception.RepositoryException;
import by.iba.model.SportOffer;
import by.iba.repository.dbconstants.SportOfferTableConstants;
import by.iba.repository.specification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SportOfferRepository extends AbstractRepository<SportOffer> {
    private static final String TABLE_NAME = "sportOffers";

    public SportOfferRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<SportOffer> query(String sqlString, Parameter paramater) throws RepositoryException {
        String query = sqlString;
        List<SportOffer> sportOffers = executeQuery(query, new SportOfferBuilder(), paramater.getParameters());
        return sportOffers;
    }

    @Override
    public Optional<SportOffer> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<SportOffer> sportOffer = query(sqlString, parameter);
        return sportOffer.size() == 1 ? Optional.of(sportOffer.get(0)) : Optional.empty();
    }

    public Map<String, Object> getFields(SportOffer sportOffer) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(SportOfferTableConstants.NAMEOFFER.getFieldName(), sportOffer.getNameOffer());
        fields.put(SportOfferTableConstants.PRICE.getFieldName(), sportOffer.getPrice());
        return fields;
    }
}
