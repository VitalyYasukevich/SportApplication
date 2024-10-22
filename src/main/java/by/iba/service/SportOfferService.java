package by.iba.service;

import by.iba.exception.RepositoryException;
import by.iba.exception.ServiceException;
import by.iba.model.SportOffer;
import by.iba.repository.RepositoryCreator;
import by.iba.repository.SportOfferRepository;

import java.util.List;


public class SportOfferService {
    public List<SportOffer> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            SportOfferRepository sportOfferRepository = repositoryCreator.getSportOfferRepository();
            return sportOfferRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void save(SportOffer sportOffer) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            SportOfferRepository sportOfferRepository = repositoryCreator.getSportOfferRepository();
            sportOfferRepository.save(sportOffer);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
