package by.iba.command.grouppersons;

import by.iba.command.Command;
import by.iba.command.CommandResult;
import by.iba.dto.CommonInfoDto;
import by.iba.dto.MonthPriceDto;
import by.iba.exception.IncorrectDataException;
import by.iba.exception.ServiceException;
import by.iba.model.SportOffer;
//import by.iba.service.CommonInfoService;
import by.iba.service.CommonInfoService;
import by.iba.service.MonthPriceService;
import by.iba.service.SportOfferService;
import by.iba.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import static by.iba.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class MonthPriceCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        MonthPriceService monthPriceService = new MonthPriceService();
        List<MonthPriceDto> monthPrices = monthPriceService.findAll();
        if (!monthPrices.isEmpty()) {
            request.setAttribute(LISTGROUP, monthPrices);
        }
        return new CommandResult(Page.MONTHPRICE_PAGE.getPage(), false);
    }
}
