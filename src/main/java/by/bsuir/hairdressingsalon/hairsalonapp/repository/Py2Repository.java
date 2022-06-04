package by.bsuir.hairdressingsalon.hairsalonapp.repository;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Py2Repository extends JpaRepository<PY2, Long> {

    List<PY2> findAll();
    List<PY2> findPY1ByCustomer(Customer customer);

}
