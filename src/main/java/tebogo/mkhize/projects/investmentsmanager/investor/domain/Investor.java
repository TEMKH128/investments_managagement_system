package tebogo.mkhize.projects.investmentsmanager.investor.domain;

import java.util.List;
import jakarta.persistence.*;
import tebogo.mkhize.projects.investmentsmanager.product.domain.Product;


@Entity
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String contact;

    @OneToMany(mappedBy = "investor")
    // product can have only one Investor, But Investor can have many products.
    // mapped by sepcifies field (variableName) in Product class that holds reference to Investor.
    private List<Product> products;


    public Investor() {}

    public Investor(String firstname, String lastname, String contact) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
