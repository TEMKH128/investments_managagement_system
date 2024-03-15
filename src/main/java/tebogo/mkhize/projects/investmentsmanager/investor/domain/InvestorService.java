package tebogo.mkhize.projects.investmentsmanager.investor.domain;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tebogo.mkhize.projects.investmentsmanager.investor.dto.InvestorResponseDTO;


@Service
public class InvestorService {
    InvestorRepository investorRepository;

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }


    /**
     * Retrieves all investors contained within the database provided that
     * investors are present.
     * @return InvestorResponseDTO which reflects outcome of request.
     */
    public InvestorResponseDTO getInvestors() {
        List<Investor> investors = (List<Investor>) investorRepository.findAll();

        String outcome = (! investors.isEmpty()) ? "OK": "ERROR";
        String message = (! investors.isEmpty()) ? "investors retrieved": "investors not found";

        return new InvestorResponseDTO(outcome, message, investors);
    }

    /**
     * Retrieves investor with specified id provided that the investor exists.
     * @param id unique id identifying investor.
     * @return InvestorResponseDTO which reflects outcome of request.
     */
    public InvestorResponseDTO getInvestor(Integer id) {
        Optional<Investor> investorOpt = investorRepository.findById(id);
        Investor investor = investorOpt.orElse(null);

        List<Investor> investors = new ArrayList<>();
        investors.add(investor);

        String outcome = (investor != null) ? "OK": "ERROR";

        String errMsg = "investor with given id " + id + " not found";
        String message = (investor != null) ? "investor retrieved": errMsg;

        return new InvestorResponseDTO(outcome, message, investors);
    }

    /**
     * Adds new investor to database provided that the investor details
     * aren't already contained within the database.
     * @param investor Investor instance to be added to the database.
     * @return InvestorResponseDTO which reflects outcome of request.
     */
    public InvestorResponseDTO addInvestor(Investor investor) {
        List<Investor> investors = investorRepository.findByFirstnameAndLastnameAndContact(
            investor.getFirstname(), investor.getLastname(),
            investor.getContact());

        InvestorResponseDTO response;
        if (investors.isEmpty()) {
            investorRepository.save(investor);
            response = getInvestor(investor.getId());
            response.setMessage("Keep track of generated investor id.");

        } else {
            response = new InvestorResponseDTO("ERROR", "Investor with " +
                "provided details already exists", new ArrayList<>());
        }

        return response;
    }

    /**
     * Updates existing Investor provided that investor exists and can be
     * identified with their unique id.
     * @param id unique id identifying investor.
     * @param investor Investor instance reflecting update to be made.
     * @return InvestorResponseDTO which reflects outcome of request.
     */
    public InvestorResponseDTO updateInvestor(Integer id, Investor investor) {
        InvestorResponseDTO checkInvestor = getInvestor(id);

        boolean investorNotExist = checkInvestor.getOutcome().equalsIgnoreCase("error");
        if (investorNotExist) {return checkInvestor;}

        investorRepository.save(investor);

        return getInvestor(id);
    }

    /**
     * Removes existing Investor with provided id from the database.
     * @param id unique id identifying investor.
     * @return InvestorResponseDTO which reflects outcome of request.
     */
    public InvestorResponseDTO removeInvestor(Integer id) {
        // Check to make sure investor doesn't have products before removing.
        investorRepository.deleteById(id);

        return new InvestorResponseDTO("OK",
            "Investor with provided id removed", new ArrayList<>());
    }
}
