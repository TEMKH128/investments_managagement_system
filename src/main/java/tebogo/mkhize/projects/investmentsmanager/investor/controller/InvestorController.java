package tebogo.mkhize.projects.investmentsmanager.investor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tebogo.mkhize.projects.investmentsmanager.investor.domain.InvestorService;


@RestController
public class InvestorController {

    InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }
}
