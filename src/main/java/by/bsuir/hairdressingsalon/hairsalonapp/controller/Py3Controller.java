package by.bsuir.hairdressingsalon.hairsalonapp.controller;


import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY3;
import by.bsuir.hairdressingsalon.hairsalonapp.service.CustomerService;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY2Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY3Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@PreAuthorize(value = "hasAuthority('USER')")
public class Py3Controller {

    private final CustomerService customerService;
    private final PY3Service py3Service;



    public Py3Controller(CustomerService customerService,
                         PY3Service py3Service) {
        this.customerService = customerService;
        this.py3Service = py3Service;

    }

    @GetMapping("/createPY3")
    public String createPY3(@AuthenticationPrincipal Customer customer, Model model) {
        System.out.println("перед созданием класса");

        PY3 py3 = new PY3();
        System.out.println("после созданием класса");
        model.addAttribute("customer", customer);
        model.addAttribute("py3", py3);



        return "customer/py3";
    }



    @PostMapping("/createPY3")
    public String createPy3(@AuthenticationPrincipal Customer customer,
          //                  @Validated PY3 py3,
                            @Validated @ModelAttribute("py3") PY3 py3,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            System.out.println("тут всратыш");
            // return "customer/";
            return "customer/py3";
        }



        System.out.println("сработало после всратыша");
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        System.out.println(dateFormat.format( new Date() ) );
        py3.setName("PU3_"+customer.getIdfszn()+"_"+customer.getIdnum()+"_1_2022_"+dateFormat.format( new Date() ));
        System.out.println(py3.getName() );
        py3.setCustomer(customer);
        py3Service.save(py3);
        System.out.println(py3.toString());
        return "customer/py3";
    }










}
