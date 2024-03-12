package tebogo.mkhize.projects.investmentsmanager.investor.domain;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface InvestorRepository extends CrudRepository<Investor, Integer> {}
