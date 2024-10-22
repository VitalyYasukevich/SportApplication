package by.iba.builder;

public class BuildFactory {

    private static final String USER = "user";
    private static final String PERSON = "persons";
    private static final String ORDER = "orders";
    private static final String SPORTOFFER = "sportOffers";
    private static final String COMMONINFO = "commonInfos";
    private static final String MESSAGE = "Unknown Builder name!";

    public static Builder create(String builderName) {
        switch (builderName) {
            case USER: {
                return new UserBuilder();
            }
            case PERSON: {
                return new PersonBuilder();
            }
            case ORDER: {
                return new OrderBuilder();
            }
            case SPORTOFFER: {
                return new SportOfferBuilder();
            }
            default:
                throw new IllegalArgumentException(MESSAGE);
        }
    }
}
