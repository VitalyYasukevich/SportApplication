package by.iba.command.factory;

/* Хранилище команд */
public enum CommandType {
    LOGIN("login"),
    SIGN_OUT("sign_out"),
    WELCOME("welcome"),
    ORDER("order"),
    SPORTOFFER("sportOffer"),
    COMMONINFO("commonInfo"),
    MONTHPRICE("monthPrice"),
    REGISTER_NEW_USER("register_new_user"),
    ADD_NEW_PERSON("add_new_person"),
    ADD_NEW_ORDER("add_new_order"),
    ADD_NEW_SPORTOFFER("add_new_sportOffer"),
    ADD_NEW_COMMONINFO("add_new_commonInfo"),
    LOGIN_PAGE("login_page"),
    REGISTRATION_PAGE("registration_page");

    private String command;

    private CommandType(String command) {
        this.command = command;
    }
}

