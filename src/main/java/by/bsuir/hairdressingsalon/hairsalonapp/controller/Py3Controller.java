package by.bsuir.hairdressingsalon.hairsalonapp.controller;


import by.bsuir.hairdressingsalon.hairsalonapp.entity.*;
import by.bsuir.hairdressingsalon.hairsalonapp.service.CustomerService;
import by.bsuir.hairdressingsalon.hairsalonapp.service.DatesService;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY2Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY3Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@PreAuthorize(value = "hasAuthority('USER')")
public class Py3Controller {

    private final CustomerService customerService;
    private final PY3Service py3Service;
    private  final DatesService datesService;



    public Py3Controller(CustomerService customerService,
                         PY3Service py3Service,
                         DatesService datesService) {
        this.customerService = customerService;
        this.py3Service = py3Service;
        this.datesService = datesService;

    }

    @GetMapping("/createPY3")
    public String createPY3(@AuthenticationPrincipal Customer customer, Model model) {
        System.out.println("перед созданием класса");

        PY3 py3 = new PY3();
        Dates dates=new Dates();
       // List<Dates> datesForPy3 = datesService.getDatesPY3(py3);
        System.out.println("после созданием класса");
        model.addAttribute("customer", customer);
        model.addAttribute("py3", py3);
        model.addAttribute("dates", dates);
        //model.addAttribute("datesForPy3", datesForPy3);




        return "customer/py3";
    }



    @PostMapping("/createPY3")
    public String createPy3(@AuthenticationPrincipal Customer customer,
          //                  @Validated PY3 py3,
                            @Validated @ModelAttribute("py3") PY3 py3,
                            @Validated @ModelAttribute("dates") Dates dates,
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

        py3.setCustomer(customer);
        py3Service.save(py3);

        System.out.println(py3.toString());
        return "customer/py3";
    }



    @GetMapping("/py3/delete/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        py3Service.deleteById(id);

        return "redirect:/profile";
    }

    @PostMapping("/createDate")
    public String downloadWord3(@AuthenticationPrincipal Customer customer,
                                @Validated @ModelAttribute("dates") Dates dates,
                                @Validated @ModelAttribute("py3") PY3 py3,
                                BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            System.out.println("тут всратыш");
            // return "customer/";
            return "customer/py3";
        }


        datesService.save(dates);



        return "customer/py3";
    }






    }
