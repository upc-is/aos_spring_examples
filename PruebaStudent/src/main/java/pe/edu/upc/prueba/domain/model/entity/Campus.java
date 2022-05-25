package pe.edu.upc.prueba.domain.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "campuses")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "campus")
    private List<Career> careers;
}
