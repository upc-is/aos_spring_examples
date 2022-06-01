package pe.edu.upc.prueba.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.prueba.domain.model.entity.Student;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return null;
    }
}
