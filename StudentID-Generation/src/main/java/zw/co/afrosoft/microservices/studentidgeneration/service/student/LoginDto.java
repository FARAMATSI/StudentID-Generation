package zw.co.afrosoft.microservices.studentidgeneration.service.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String firstName;
    private String surname;
    private String studentId;
    private String username;
    private String password;
    private String email;
}
