package by.bsuir.hairdressingsalon.hairsalonapp.service;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.Dates;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY3;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.DatesRepository;
import by.bsuir.hairdressingsalon.hairsalonapp.repository.Py3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatesService {

    private final DatesRepository datesRepository;



    @Autowired
    public DatesService(DatesRepository datesRepository) {
        this.datesRepository = datesRepository;


    }

    public List<Dates> getAllDates() {
        return datesRepository.findAll();
    }

    public Optional<Dates> getDatesById(Long id) {
        return datesRepository.findById(id);
    }

     // public Optional<PY3> getDatesByCustomerId(Long id) {return py3Repository.findByCustomerId(id);}


    public List<Dates> getDatesPY3(PY3 py3) {
        return datesRepository.findDatesByPy3(py3);
    }

    public void save(Dates dates) {
        datesRepository.save(dates);
    }

    public void delete(Dates dates) {
        datesRepository.delete(dates);
    }

    public void deleteById(Long id) {
        datesRepository.deleteById(id);
    }
}
