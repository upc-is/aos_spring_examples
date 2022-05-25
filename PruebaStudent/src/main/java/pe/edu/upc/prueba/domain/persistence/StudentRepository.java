package pe.edu.upc.prueba.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.prueba.domain.model.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByAverageAndAge(Float average, Integer age);

    @Query(value = "SELECT * from students where last_name like '%:lastName%' and age < :age", nativeQuery = true)
    List<Student> fetchByLastNameAndAge(@Param("lastName") String lastName,
                                        @Param("age") Integer age);

    @Query(value = "SELECT st from Student st where st.lastName like '%:lastName%' and st.age < :age")
    List<Student> fetchByLastNameAndAge2(@Param("lastName") String lastName,
                                        @Param("age") Integer age);
}
