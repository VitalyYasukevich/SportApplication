package by.iba.repository;

import by.iba.connection.ConnectionPool;
import java.sql.Connection;

public class RepositoryCreator implements AutoCloseable {
    private ConnectionPool connectionPool;
    private Connection connection;

    public RepositoryCreator() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }
    public PersonRepository getPersonRepository() { return new PersonRepository(connection); }
    public OrderRepository getOrderRepository() { return new OrderRepository(connection); }
    public SportOfferRepository getSportOfferRepository() { return new SportOfferRepository(connection); }

    @Override
    public void close() {
        connectionPool.releaseConnection(connection); }
}


