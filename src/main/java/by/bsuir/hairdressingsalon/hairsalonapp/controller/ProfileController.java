package by.bsuir.hairdressingsalon.hairsalonapp.controller;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.*;
import by.bsuir.hairdressingsalon.hairsalonapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/profile")
@PreAuthorize(value = "hasAuthority('USER')")
public class ProfileController {

    private final CustomerService customerService;
    private final AppointmentService appointmentService;
    private final SalonProcedureService procedureService;
    private final EmployeeService employeeService;

    private final PY1Service py1Service;

    @Autowired
    public ProfileController(CustomerService customerService,
                             AppointmentService appointmentService,
                             SalonProcedureService procedureService,
                             EmployeeService employeeService,
                             PY1Service py1Service) {
        this.customerService = customerService;
        this.appointmentService = appointmentService;
        this.procedureService = procedureService;
        this.employeeService = employeeService;
        this.py1Service = py1Service;

    }

    @GetMapping
    public String displayCustomerProfilePage(@AuthenticationPrincipal Customer customer, Model model) {
        List<ProcedureAppointment> appointmentsForCustomer = appointmentService.getAppointmentsForCustomer(customer);

        Customer customerData = customerService.findByLoginOrEmail(customer.getLogin(), null).orElseThrow();
        model.addAttribute("customer", customerData);
        model.addAttribute("appointmentsForCustomer", appointmentsForCustomer);

        return "customer/profile";
    }


    @GetMapping("/mainpage")
    public String displayCustomerInfo(@AuthenticationPrincipal Customer customer, Model model) {

        Customer customerData = customerService.findByLoginOrEmail(customer.getLogin(), null).orElseThrow();
        model.addAttribute("customer", customerData);
        System.out.print("get");
        return "customer/mainpage";
    }

    @PostMapping("/mainpage")
    public String displayCustomerInf(@AuthenticationPrincipal Customer customer, Model model) {
        model.addAttribute("customer", customer);
        System.out.print("post");
        return "customer/mainpage";
    }


    @GetMapping("/edit")
    public String showEmployeeEditForm(@AuthenticationPrincipal Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "customer/profile-edit";
    }

   /* @GetMapping("/mainpage")
    public String showEmployeeEditForm1(@AuthenticationPrincipal Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "customer/mainpage";
    } */

    @PostMapping
    public String updateProfile(@RequestParam(name = "passwordConfirmation") String passwordConfirmation,
                                @AuthenticationPrincipal Customer customer,
                                @Validated Customer updated,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasFieldErrors("name") ||
                bindingResult.hasFieldErrors("surname") ||
                bindingResult.hasFieldErrors("email") ||
                bindingResult.hasFieldErrors("login")) {
            return "customer/profile-edit";
        }

        if (!passwordConfirmation.isBlank()
                && customer.getPassword() != null
                && !customer.getPassword().equals(passwordConfirmation)) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "customer/profile-edit";
        }

        customerService.updateProfile(customer, updated);

        model.addAttribute("customer", updated);
        return "redirect:/profile";
    }

    @GetMapping("/appointments/edit/{id}")
    public String showAppointmentEditForm(@PathVariable Long id, Model model) {
        ProcedureAppointment appointment = appointmentService
                .getAppointmentById(id)
                .orElseThrow();
        List<SalonProcedure> procedures = procedureService.getAllProcedures();
        List<Employee> employees = employeeService.getAllEmployees();

        model.addAttribute("appointment", appointment);
        model.addAttribute("procedures", procedures);
        model.addAttribute("employees", employees);

        return "customer/appointment-edit";
    }

    @PostMapping("/appointments/update/{id}")
    public String updateAppointment(@AuthenticationPrincipal Customer customer,
                                    @PathVariable Long id,
                                    @Validated ProcedureAppointment updatedAppointment,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            return "customer/appointment-edit";
        }

        updatedAppointment.setId(id);
        updatedAppointment.setSignedUpCustomer(customer);

        appointmentService.save(updatedAppointment);

        return "redirect:/profile";
    }

    @GetMapping("/appointments/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);

        return "redirect:/profile";
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

    @PostMapping("/createPY11")
    public String createPy11(@AuthenticationPrincipal Customer customer,
                            @Validated PY1 py1,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            return "customer/py1";
        }
        System.out.println("сработало");

        py1.setCustomer(customer);
        py1Service.save(py1);
        System.out.println(py1.toString());
        return "customer/py1";
    }

    @PostMapping("/createPY1")
    public String createPy1(@AuthenticationPrincipal Customer customer,
                            @Validated PY1 py1,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
            System.out.println("тут всратыш");
           // return "customer/";
            return "customer/py1";
        }

        System.out.println("сработало после всратыша");
        py1.setCustomer(customer);
        py1Service.save(py1);
        System.out.println(py1.toString());
        return "customer/py1";
    }

}





