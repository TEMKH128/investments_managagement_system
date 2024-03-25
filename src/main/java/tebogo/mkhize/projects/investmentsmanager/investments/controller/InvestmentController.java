package tebogo.mkhize.projects.investmentsmanager.investments.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tebogo.mkhize.projects.investmentsmanager.investments.domain.InvestmentService;

/**
 * Parent controller for other packages related to investments.
 * Handles requests that require cross-package interactions.
 */
@RestController
public class InvestmentController {
    InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }
}
