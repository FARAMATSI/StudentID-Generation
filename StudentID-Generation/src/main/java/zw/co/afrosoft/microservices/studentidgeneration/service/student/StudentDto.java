package zw.co.afrosoft.microservices.studentidgeneration.service.student;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String studentName;
    private String studentSurname;
    private String studentEmail;
}
