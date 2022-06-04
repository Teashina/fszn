package by.bsuir.hairdressingsalon.hairsalonapp.repository;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.Dates;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Long> {

    List<Dates> findAll();
    List<Dates> findDatesByPy3(PY3 py3);

}
