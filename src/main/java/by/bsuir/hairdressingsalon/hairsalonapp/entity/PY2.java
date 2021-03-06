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



    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "pr_number")
    private String pr_number;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pr_data")
    private LocalDate pr_data;


    @Column(name = "codd")
    private String codd;

    @Column(name = "codegone")
    private String codegone;

    @Column(name = "numprik2")
    private String numprik2;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "datrprk2")
    private LocalDate datrprk2;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dategote")
    private LocalDate dategote;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataprik")
    private LocalDate dataprik;


    @Column(name = "codework")
    private String CodeWork;

    @Column(name = "dolgname")
    private String dolgName;

    @Column(name = "strackname")
    private String strackName;

    @Column(name = "numprikk")
    private String numprikk;

    @Column(name = "codetrud")
    private String codetrud;

    @Column(name = "nummprik")
    private String nummprik;

    @Column(name = "priiknam")
    private String priiknam;

    @Column(name = "mrazrad")
    private String mrazrad;

    @Column(name = "kvalkat")
    private String KvalKat;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataper")
    private LocalDate dataper;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataprikz")
    private LocalDate dataprikz;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dategett")
    private LocalDate dateGett;

    @PastOrPresent(message = "Дата должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "datepriik")
    private LocalDate datepriik;











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
                ", pr_number='" + pr_number + '\'' +
                ", pr_data='" + pr_data + '\'' +
                ", codd='" + codd + '\'' +
                ", customer=" + customer +
                '}';
    }
}
