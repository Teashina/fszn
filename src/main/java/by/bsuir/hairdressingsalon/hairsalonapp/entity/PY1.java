package by.bsuir.hairdressingsalon.hairsalonapp.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "py1")
public class PY1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Past(message = "Дата рождения должна быть пораньше")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate date_of_birth;

    //@DateTimeFormat(pattern = "HH:mm")
   // @Column(name = "appointment_time")
    //private LocalTime startTime;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "sity_of_birth", nullable = false)
    private String sity_of_birth;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "area_of_birth")
    private String area_of_birth;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "country", nullable = false)
    private String country;

    @Size(min = 7, max = 7, message = " f ")
    @Column(name = "sex", nullable = false)
    private String sex;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "address")
    private String address;


    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "indeks")
    private String indeks;


    @Size(min = 9, message = "Длина должна быть 9 символа")
    @Column(name = "telephone")
    private String telephone;

    @Size(min = 7, message = "Длина должна быть  7 символа")
    @Column(name = "telephone_home")
    private String telephone_home;

    @Size(min = 2, max = 2, message = "Длина должна быть 2 символа")
    @Column(name = "series")
    private String series;

    @Size(min = 3, message = "Длина должна быть минимум 3 символа")
    @Column(name = "num")
    private String num;


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

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getSity_of_birth() {
        return sity_of_birth;
    }

    public String getArea_of_birth() {
        return area_of_birth;
    }

    public String getCountry() {
        return country;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getIndeks() {
        return indeks;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTelephone_home() {
        return telephone_home;
    }

    public String getSeries() {
        return series;
    }

    public String getNum() {
        return num;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setSity_of_birth(String sity_of_birth) {
        this.sity_of_birth = sity_of_birth;
    }

    public void setArea_of_birth(String area_of_birth) {
        this.area_of_birth = area_of_birth;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTelephone_home(String telephone_home) {
        this.telephone_home = telephone_home;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }





    @Override
    public String toString() {
        return "ProcedureAppointment{" +
                "id=" + id +
                ", date="  +
                ", startTime="  +
                ", signedUpCustomer=" +  +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PY1 py1 = (PY1) o;
        return id != null && Objects.equals(id, py1.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
