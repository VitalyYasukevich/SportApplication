package by.iba.command.grouppersons;

import by.iba.command.Command;
import by.iba.command.CommandResult;
import by.iba.exception.IncorrectDataException;
import by.iba.exception.ServiceException;
import by.iba.model.Order;
import by.iba.service.OrderService;
import by.iba.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static by.iba.command.grouppersons.constant.GroupConstant.*;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.of;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class AddNewOrderCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddNewOrderCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        OrderService orderService = new OrderService();
        Optional<String> newPersonId = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWPERSONID));
        Optional<String> newSportOfferId = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWSPORTOFFERID));
        Optional<String> newQuantityOfDay = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWQUANTITYOFDAY));
        Optional<String> newMonth = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWMONTH));
        if (isEmpty(newPersonId.get()) || isEmpty(newSportOfferId.get()) || isEmpty(newQuantityOfDay.get()) || isEmpty(newMonth.get())) {
            logger.info("missing parameter for new order in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {
            Order neworder = new Order(Integer.parseInt(newPersonId.get()), Integer.parseInt(newSportOfferId.get()), Integer.parseInt(newQuantityOfDay.get()), newMonth.get());
            orderService.save(neworder);
        }
        List<Order> clients = orderService.findAll2();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.ORDER_PAGE.getPage(), false);
    }
}
