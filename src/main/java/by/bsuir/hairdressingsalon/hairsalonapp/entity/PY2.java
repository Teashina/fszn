package by.bsuir.hairdressingsalon.hairsalonapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "py2")
public class PY2 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_start")
    private LocalDate date_start;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_end")
    private LocalDate date_end;


    //@DateTimeFormat(pattern = "HH:mm")
   // @Column(name = "appointment_time")
    //private LocalTime startTime;

    @Size(min = 2, message = "Длина должна быть минимум 2 символа")
    @Column(name = "reason")
    private String reason;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "pr_number")
    private String pr_number;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pr_data")
    private LocalDate pr_data;

    @Size(min = 2, message = "Длина должна быть минимум 3 символа")
    @Column(name = "codd")
    private String codd;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;


   /*  @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "procedure_id")
    private SalonProcedure salonProcedure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer signedUpCustomer;

    // @OneToOne(cascade = {CascadeType.DETACH, CascadeType.REMOVE}, orphanRemoval = true)
    // @LazyToOne(LazyToOneOption.PROXY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "performing_employee_id", referencedColumnName = "id", nullable = false)
    private Employee performingEmployee;

    
    */

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PY2{" +
                "id=" + id +
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                ", reason='" + reason + '\'' +
                ", pr_number='" + pr_number + '\'' +
                ", pr_data='" + pr_data + '\'' +
                ", codd='" + codd + '\'' +
                ", customer=" + customer +
                '}';
    }
}
