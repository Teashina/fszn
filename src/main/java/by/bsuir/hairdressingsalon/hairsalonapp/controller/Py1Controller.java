package by.bsuir.hairdressingsalon.hairsalonapp.controller;


import by.bsuir.hairdressingsalon.hairsalonapp.Mailer.CreatingTXT;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.ProcedureAppointment;
import by.bsuir.hairdressingsalon.hairsalonapp.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@PreAuthorize(value = "hasAuthority('USER')")
public class Py1Controller {

    private final CustomerService customerService;
    private final PY1Service py1Service;

    public Py1Controller(CustomerService customerService,
                             PY1Service py1Service) {
        this.customerService = customerService;
        this.py1Service = py1Service;

    }

    @GetMapping("/createPY1")
    public String createPY111(@AuthenticationPrincipal Customer customer, Model model) {
        System.out.println("перед созданием класса");

        PY1 py1 = new PY1();
        System.out.println("после созданием класса");
        model.addAttribute("customer", customer);
        model.addAttribute("py1", py1);

        return "customer/py1";
    }



    @PostMapping("/createPY1")
    public String createPy1(@AuthenticationPrincipal Customer customer,
                            @Validated @ModelAttribute("py1") PY1 py1,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            System.out.println("тут всратыш");
            // return "customer/";
            return "customer/py1";
        }

        System.out.println("сработало после всратыша");
        System.out.println("сработало после всратыша");
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        System.out.println(dateFormat.format( new Date() ) );
        py1.setName("PU1_"+customer.getIdfszn()+"_"+customer.getIdnum()+"_1_2022_"+dateFormat.format( new Date() ));
        py1.setCustomer(customer);
        py1Service.save(py1);
        System.out.println(py1.toString());
        return "customer/py1";
    }






}
