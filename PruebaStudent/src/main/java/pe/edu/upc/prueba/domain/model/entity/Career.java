package pe.edu.upc.prueba.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "careers")
@Getter
@Setter
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    @JsonIgnoreProperties(value = "careers")
    private Campus campus;
    /*private List<Course> courses;
    private List<Matricula> matriculas;*/

    @OneToMany(mappedBy = "career")
    private List<Student> students;

}
