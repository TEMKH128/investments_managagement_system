package tebogo.mkhize.projects.investmentsmanager.investor.dto;

import java.util.List;
import tebogo.mkhize.projects.investmentsmanager.investor.domain.Investor;


public class InvestorResponseDTO {
    private String outcome;
    private String message;
    private List<Investor> investors;

    public InvestorResponseDTO(String outcome, String message, List<Investor> investors) {
        this.outcome = outcome;
        this.message = message;
        this.investors = investors;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Investor> getInvestors() {
        return investors;
    }

    public void setInvestors(List<Investor> investors) {
        this.investors = investors;
    }
}
