package by.bsuir.hairdressingsalon.hairsalonapp.service;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.CustomerRepository;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.Py1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PY1Service {

    private final Py1Repository py1Repository;



    @Autowired
    public PY1Service(Py1Repository py1Repository) {
        this.py1Repository = py1Repository;


    }

    public List<PY1> getAllPy1() {
        return py1Repository.findAll();
    }

    public Optional<PY1> getPY1ById(Long id) {
        return py1Repository.findById(id);
    }

     // public Optional<PY1> getDatesByCustomerId(Long id) {return py1Repository.findByCustomerId(id);}


    public List<PY1> getPY1ByCustomer(Customer customer) {
        return py1Repository.findPY1ByCustomer(customer);
    }

    public void save(PY1 py1) {
        py1Repository.save(py1);
    }

    public void delete(PY1 py1) {
        py1Repository.delete(py1);
    }

    public void deleteById(Long id) {
        py1Repository.deleteById(id);
    }
}
