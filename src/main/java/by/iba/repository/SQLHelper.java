package by.iba.repository;

import by.iba.repository.dbconstants.OrderTableConstants;
//import by.iba.repository.dbconstants.CommonInfoTableConstants;
import by.iba.repository.dbconstants.PersonTableConstants;
import by.iba.repository.dbconstants.SportOfferTableConstants;
import by.iba.repository.dbconstants.UserTableConstants;

import java.util.Map;

public class SQLHelper {
    public static final String ID = "id";
    private static final String INSERT_QUERY = "INSERT INTO ";
    private static final String VALUES = "VALUES";
    private static final String WHERE = "WHERE ";
    private static final String SELECT = "SELECT";
    private static final String USER_TABLE = "users";
    private static final String PERSON_TABLE = "persons";
    private static final String ORDER_TABLE = "orders";
    private static final String SPORTOFFER_TABLE = "sportOffers";
    private static final String COMMONINFO_TABLE = "commonInfos";

    public final static String SQL_GET_PERSONS = "select * from " + USER_TABLE;
    public final static String SQL_INSERT_PERSON = "INSERT INTO " + PERSON_TABLE + "(" + PersonTableConstants.NAME + "," + PersonTableConstants.PHONE + "," + PersonTableConstants.EMAIL + ") VALUES (? , ?, ?)";

    public final static String SQL_GET_ORDERS = "select * from " + ORDER_TABLE;
    public final static String SQL_INSERT_ORDER = "INSERT INTO " + ORDER_TABLE + "(" + OrderTableConstants.PERSONID + "," + OrderTableConstants.SPORTOFFERID + "," + OrderTableConstants.QUANTITYOFDAY + "," + OrderTableConstants.MONTH + ") VALUES (?, ? , ?, ?)";

    public final static String SQL_GET_SPORTOFFERS = "select * from " + SPORTOFFER_TABLE;
    public final static String SQL_INSERT_SPORTOFFER = "INSERT INTO " + SPORTOFFER_TABLE + "(" + SportOfferTableConstants.NAMEOFFER + "," + SportOfferTableConstants.PRICE + ") VALUES (? , ?)";

    public final static String SQL_GET_USER = "SELECT " + UserTableConstants.ID.getFieldName() + ", " + UserTableConstants.LOGIN.getFieldName() + ", " + UserTableConstants.PASSWORD.getFieldName() + " from " + USER_TABLE + " WHERE " + UserTableConstants.LOGIN.getFieldName() + " =? and " + UserTableConstants.PASSWORD.getFieldName() + " =?";
    public final static String SQL_CHECK_LOGIN = "SELECT " + UserTableConstants.LOGIN.getFieldName() + " FROM " + USER_TABLE + " WHERE " + UserTableConstants.LOGIN.getFieldName() + " = ?";
    public final static String SQL_INSERT_USER = "INSERT INTO " + USER_TABLE + "(" + UserTableConstants.LOGIN.getFieldName() + " ," + UserTableConstants.PASSWORD.getFieldName() + ") VALUES (? , ?)";

    public static String makeInsertQuery(Map<String, Object> fields, String table) {
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String column = entry.getKey();
            if (column.equals(ID)) {
                continue;
            }
            columns.append(column).append(", ");
            values.append("?, ");
        }
        values.deleteCharAt(values.lastIndexOf(","));
        columns.deleteCharAt(columns.lastIndexOf(","));
        values.append(")");
        columns.append(")");
        return INSERT_QUERY + table + columns + VALUES + values + ";";
    }
}

