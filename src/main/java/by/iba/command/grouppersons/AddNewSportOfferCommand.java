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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

import static by.iba.command.grouppersons.constant.GroupConstant.*;
import static java.util.Optional.of;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class AddNewSportOfferCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddNewSportOfferCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        SportOfferService sportOfferService = new SportOfferService();
        Optional<String> newName = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWNAMESO));
        Optional<String> newPrice = of(request).map(httpServletRequest -> httpServletRequest.getParameter(NEWPRICE));
        if (isEmpty(newName.get()) || isEmpty(newPrice.get())) {
            logger.info("missing parameter for new sportOffer in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {
            SportOffer newsportOffer = new SportOffer(newName.get(), Float.parseFloat(newPrice.get()));
            sportOfferService.save(newsportOffer);
        }
        List<SportOffer> clients = sportOfferService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.SPORTOFFER_PAGE.getPage(), false);
    }
}
