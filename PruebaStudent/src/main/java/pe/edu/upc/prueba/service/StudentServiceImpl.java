package pe.edu.upc.prueba.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.prueba.domain.model.entity.Student;
import pe.edu.upc.prueba.domain.persistence.StudentRepository;
import pe.edu.upc.prueba.domain.service.StudentService;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    //@Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return studentRepository.existsById(id);
    }

}
