package by.bsuir.hairdressingsalon.hairsalonapp.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor

@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
@Entity
@Table(name = "dates")
public class Dates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Size(min = 2)
    @Column(name = "act")
    private String act;

    @Past(message = "Дата начала периода")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_start", nullable = false)
    private LocalDate date_start;

    @Past(message = "Дата конца периода")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_end", nullable = false)
    private LocalDate date_end;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pu3_id")
    private PY3 py3;




    public void setPy3(PY3 py3) {
        this.py3 = py3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dates dates = (Dates) o;
        return id != null && Objects.equals(id, dates.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
