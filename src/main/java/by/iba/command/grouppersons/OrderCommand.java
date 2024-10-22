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

import java.util.List;

import static by.iba.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class OrderCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.findAll2();
        if (!orders.isEmpty()) {
            request.setAttribute(LISTGROUP, orders);
        }
        return new CommandResult(Page.ORDER_PAGE.getPage(), false);
    }
}
