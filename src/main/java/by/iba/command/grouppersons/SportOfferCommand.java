package by.iba.command.grouppersons;

import by.iba.command.Command;
import by.iba.command.CommandResult;
import by.iba.exception.IncorrectDataException;
import by.iba.exception.ServiceException;
import by.iba.model.SportOffer;
import by.iba.service.SportOfferService;
import by.iba.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import static by.iba.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class SportOfferCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        SportOfferService sportOfferService = new SportOfferService();
        List<SportOffer> sportOffers = sportOfferService.findAll();
        if (!sportOffers.isEmpty()) {
            request.setAttribute(LISTGROUP, sportOffers);
        }
        return new CommandResult(Page.SPORTOFFER_PAGE.getPage(), false);
    }
}
