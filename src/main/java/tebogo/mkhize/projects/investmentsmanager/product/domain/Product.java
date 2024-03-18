package tebogo.mkhize.projects.investmentsmanager.product.domain;

import jakarta.persistence.*;
import tebogo.mkhize.projects.investmentsmanager.investor.domain.Investor;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String balance;

    @ManyToOne(fetch = FetchType.LAZY)
    // Many Products can belong to an Investor, but many Investors don't belong to a single product.
    // FetchType.LAZY is an optimisation hint to JPA to fetch associated Investor object when explicity
    // requested (Improves performance for large datasets).
    @JoinColumn  // Indicates foreign key.
    private Investor investor;

    // @JoinColumn Annotation vs Constructor Linking: annotation is preferable as it separates data mapping
    //  configuration from business logic in constructor. Allows customisation of foreign key and integrates
    // with JPA (E.g. generating foreign key constraints, lazy fetching, etc.).

    public Product() {}

    public Product(String name, String type, String balance) {
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
