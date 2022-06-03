package pe.edu.upc.prueba.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.prueba.domain.model.entity.Student;
import pe.edu.upc.prueba.domain.service.StudentService;

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
        Optional<Student> optional = studentService.getById(id);
        if (optional.isPresent())
            return optional.get();
        else
            return optional.get();
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {

        return null;
    }
}
