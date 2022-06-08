package pe.edu.upc.prueba.api;

import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.prueba.domain.model.entity.Student;
import pe.edu.upc.prueba.domain.service.StudentService;
import pe.edu.upc.prueba.shared.exception.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        List<Student> students = studentService.getAll();
        students.forEach(System.out::println);
        return students;
    }

    @GetMapping("{id}") //  /students/{id}
    public Student getById(@PathVariable("id") Integer id) {
        if (!studentService.existsById(id)) {
            throw new NotFoundException("Student", id);
        } else {
            Optional<Student> optional = studentService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Student updateById(@PathVariable("id") Integer id,
                              @RequestBody Student student) {
        if (!studentService.existsById(id)) {
            throw new NotFoundException("Student", id);
        } else
        {   // Faltan las demas validaciones
            return studentService.update(student);
        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        // Faltan validaciones
        Student studentResponse = studentService.create(student);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!studentService.existsById(id)) {
            throw new NotFoundException("Student", id);
        } else
        {   // Faltan las demas validaciones
            studentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }
}
