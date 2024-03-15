package tebogo.mkhize.projects.investmentsmanager.investor.domain;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface InvestorRepository extends CrudRepository<Investor, Integer> {
    List<Investor> findByFirstnameAndLastnameAndContact(String firstname, String lastname, String contact);
}
