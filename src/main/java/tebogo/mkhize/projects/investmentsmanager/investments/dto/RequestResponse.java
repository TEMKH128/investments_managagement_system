package tebogo.mkhize.projects.investmentsmanager.investments.dto;

import java.util.List;


public class RequestResponse {
    private String outcome;
    private String message;
    private List<Object> data;

    public RequestResponse(String outcome, String message, List<Object> data) {
        this.outcome = outcome;
        this.message = message;
        this.data = data;
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

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
