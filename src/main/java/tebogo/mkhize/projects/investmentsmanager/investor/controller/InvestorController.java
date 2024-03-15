package tebogo.mkhize.projects.investmentsmanager.investor.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import tebogo.mkhize.projects.investmentsmanager.investor.domain.Investor;
import tebogo.mkhize.projects.investmentsmanager.investor.domain.InvestorService;
import tebogo.mkhize.projects.investmentsmanager.investor.dto.InvestorResponseDTO;


@RestController
@RequestMapping(path = "investments")
public class InvestorController {

    InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping("/investors")
    public InvestorResponseDTO getInvestors() {
        return investorService.getInvestors();
    }

    @GetMapping("/investors/{id}")
    public InvestorResponseDTO getInvestor(@PathVariable Integer id) {
        return investorService.getInvestor(id);
    }

    @PostMapping("/investors")
    public InvestorResponseDTO addInvestor(@RequestBody Investor investor) {
        return investorService.addInvestor(investor);
    }

    @PutMapping("/investors/{id}")
    public InvestorResponseDTO updateInvestor(
        @RequestBody Investor investor, @PathVariable Integer id) {

        return investorService.updateInvestor(id, investor);
    }

}
