package by.bsuir.hairdressingsalon.hairsalonapp.controller;


import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import by.bsuir.hairdressingsalon.hairsalonapp.service.CustomerService;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY1Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY2Service;
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
public class Py2Controller {

    private final CustomerService customerService;
    private final PY2Service py2Service;

    public Py2Controller(CustomerService customerService,
                         PY2Service py2Service) {
        this.customerService = customerService;
        this.py2Service = py2Service;

    }

    @GetMapping("/createPY2")
    public String createPY2(@AuthenticationPrincipal Customer customer, Model model) {
        System.out.println("перед созданием класса");

        PY2 py2 = new PY2();
        System.out.println("после созданием класса");
        model.addAttribute("customer", customer);
        model.addAttribute("py2", py2);

        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        System.out.println(dateFormat.format( new Date() ) );

        return "customer/py2";
    }



    @PostMapping("/createPY2")
    public String createPy2(@AuthenticationPrincipal Customer customer,
          //                  @Validated PY2 py2,
                            @Validated @ModelAttribute("py2") PY2 py2,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            System.out.println("тут всратыш");
            // return "customer/";
            return "customer/py2";
        }



        System.out.println("сработало после всратыша");
        py2.setCustomer(customer);
        py2Service.save(py2);
        System.out.println(py2.toString());
        return "customer/py2";
    }
}
