package zw.co.afrosoft.microservices.studentidgeneration.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.microservices.studentidgeneration.service.student.LoginDto;
import zw.co.afrosoft.microservices.studentidgeneration.service.student.StudentDto;
import zw.co.afrosoft.microservices.studentidgeneration.service.student.StudentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/save-student")
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/add-student")
    @Operation(summary = "Add Student")
    public ResponseEntity<LoginDto> saveStudent(@RequestBody StudentDto studentDto) {
       return ResponseEntity.ok(studentService.saveStudent(studentDto));
    }
}
