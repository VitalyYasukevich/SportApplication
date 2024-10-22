package by.iba.command.grouppersons;

import by.iba.command.Command;
import by.iba.command.CommandResult;
import by.iba.dto.CommonInfoDto;
import by.iba.exception.IncorrectDataException;
import by.iba.exception.ServiceException;
import by.iba.model.SportOffer;
//import by.iba.service.CommonInfoService;
import by.iba.service.CommonInfoService;
import by.iba.service.SportOfferService;
import by.iba.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import static by.iba.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class CommonInfoCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        CommonInfoService commonInfoService = new CommonInfoService();
        List<CommonInfoDto> commonInfos = commonInfoService.findAll();
        if (!commonInfos.isEmpty()) {
            request.setAttribute(LISTGROUP, commonInfos);
        }
        return new CommandResult(Page.COMMONINFO_PAGE.getPage(), false);
    }
}
