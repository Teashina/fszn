package by.bsuir.hairdressingsalon.hairsalonapp.service;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY3;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.Py2Repository;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.Py3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PY3Service {

    private final Py3Repository py3Repository;



    @Autowired
    public PY3Service(Py3Repository py3Repository) {
        this.py3Repository = py3Repository;


    }

    public List<PY3> getAllP3() {
        return py3Repository.findAll();
    }

    public Optional<PY3> getPY3ById(Long id) {
        return py3Repository.findById(id);
    }

     // public Optional<PY3> getDatesByCustomerId(Long id) {return py3Repository.findByCustomerId(id);}


    public List<PY3> getPY3ByCustomer(Customer customer) {
        return py3Repository.findPY3ByCustomer(customer);
    }

    public void save(PY3 py3) {
        py3Repository.save(py3);
    }

    public void delete(PY3 py3) {
        py3Repository.delete(py3);
    }

    public void deleteById(Long id) {
        py3Repository.deleteById(id);
    }
}
