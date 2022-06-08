package pe.edu.upc.prueba.domain.service;

import pe.edu.upc.prueba.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    // CRUD
    Student create(Student student);
    Student update(Student student);
    List<Student> getAll();
    Optional<Student> getById(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
