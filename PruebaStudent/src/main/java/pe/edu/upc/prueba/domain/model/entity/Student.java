package pe.edu.upc.prueba.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 40, min = 2)
    @NotNull
    @NotBlank
    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "average", nullable = false)
    private Float average;

    @Column(name = "level", nullable = false)//, columnDefinition = "MONEY")
    private Integer level;

    @Min(value = 0)
    @Max(value = 120)
    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "career_id")
    @JsonIgnoreProperties(value = "students")
    private Career career;
    /*private Campus campus;
    private List<Matricula> matriculas;*/
}
