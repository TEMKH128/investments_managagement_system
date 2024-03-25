package tebogo.mkhize.projects.investmentsmanager.investments.domain;


import org.springframework.stereotype.Service;
import tebogo.mkhize.projects.investmentsmanager.investor.domain.InvestorService;
import tebogo.mkhize.projects.investmentsmanager.product.domain.ProductService;

/**
 * Parent service class for other packages related to investments.
 * Handles cross-package interactions.
 */
@Service
public class InvestmentService {
    InvestorService investorService;
    ProductService productService;

    public InvestmentService(
        InvestorService investorService, ProductService productService) {

        this.investorService = investorService;
        this.productService = productService;
    }
}
