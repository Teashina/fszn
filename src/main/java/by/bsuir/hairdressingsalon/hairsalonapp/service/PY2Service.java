package by.bsuir.hairdressingsalon.hairsalonapp.service;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.Py1Repository;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.Py2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PY2Service {

    private final Py2Repository py2Repository;



    @Autowired
    public PY2Service(Py2Repository py2Repository) {
        this.py2Repository = py2Repository;


    }

    public List<PY2> getAllPy2() {
        return py2Repository.findAll();
    }

    public Optional<PY2> getPY2ById(Long id) {
        return py2Repository.findById(id);
    }

     // public Optional<PY1> getDatesByCustomerId(Long id) {return py1Repository.findByCustomerId(id);}


    public List<PY2> getPY2ByCustomer(Customer customer) {
        return py2Repository.findPY2ByCustomer(customer);
    }

    public void save(PY2 py2) {
        py2Repository.save(py2);
    }

    public void delete(PY2 py2) {
        py2Repository.delete(py2);
    }

    public void deleteById(Long id) {
        py2Repository.deleteById(id);
    }
}
