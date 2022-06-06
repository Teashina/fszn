package by.bsuir.hairdressingsalon.hairsalonapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString

@NoArgsConstructor
@Entity
@Table(name = "py3")
public class PY3 {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Size(min = 2, message = "Длина должна быть минимум 2 символа")
    @Column(name = "reason_code")
    private String reason_code;


    @Column(name = "dayy")
    private Long dayy;

    @Column(name = "dayf")
    private Long dayf;

    @Column(name = "daym")
    private Long daym;

    @Column(name = "daya")
    private Long daya;

    @Column(name = "daymay")
    private Long daymay;

    @Column(name = "dayjn")
    private Long dayjn;

    @Column(name = "dayjl")
    private Long dayjl;

    @Column(name = "dayag")
    private Long dayag;


    @Column(name = "days")
    private Long days;

    @Column(name = "dayo")
    private Long dayo;





    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "py3", orphanRemoval = true )
    private List<Dates> dates = new ArrayList<>();

    public void setDates(List<Dates> dates) {
        this.dates = dates;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PY3 py3 = (PY3) o;
        return id != null && Objects.equals(id, py3.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
