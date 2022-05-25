package pe.edu.upc.prueba.domain.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "average", nullable = false)
    private Float average;

    @Column(name = "level", nullable = false, columnDefinition = "MONEY")
    private Integer level;

    @Column(name = "age", nullable = false, columnDefinition = "TINYINT")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;
    /*private Campus campus;
    private List<Matricula> matriculas;*/
}
