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
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "py3")
public class PY3 {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Size(min = 2, message = "Длина должна быть минимум 2 символа")
    @Column(name = "reason_code", nullable = false)
    private String reason_code;


    @Column(name = "sum_money", nullable = false)
    private Long sum_money;

    @Column(name = "sum_chil", nullable = false)
    private Long sum_chil;

    @Column(name = "fear_money_worker", nullable = false)
    private Long fear_money_worker;

    @Column(name = "fear_money_pens", nullable = false)
    private Long fear_money_pens;

    @Column(name = "fear_money_social", nullable = false)
    private Long fear_money_social;

    @Column(name = "sum_paid_worker", nullable = false)
    private Long sum_paid_worker;

    @Column(name = "sum_paid_сustom", nullable = false)
    private Long sum_paid_сustom;

    @Column(name = "fear_money_worke_per", nullable = false)
    private Long fear_money_worke_per;


    @Column(name = "fear_money_pens_per", nullable = false)
    private Long fear_money_pens_per;

    @Column(name = "fear_money_socia_per", nullable = false)
    private Long fear_money_socia_per;





    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "py3", orphanRemoval = true )
    private List<Dates> dates = new ArrayList<>();

    public void addDatesToPy3(Dates dates1) {
        if (dates == null)
        {dates = new ArrayList();}

        dates.add(dates1);
        dates1.set(this);
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
