package zw.co.afrosoft.microservices.studentidgeneration.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.microservices.studentidgeneration.domain.LoginDetails;
import zw.co.afrosoft.microservices.studentidgeneration.persistance.LoginDetailsRepository;
import zw.co.afrosoft.microservices.studentidgeneration.service.idPasswordGeneration.StudentIdGenerator;
import zw.co.afrosoft.microservices.studentidgeneration.service.idPasswordGeneration.StudentPasswordGenerator;
import zw.co.afrosoft.microservices.studentidgeneration.domain.Student;
import zw.co.afrosoft.microservices.studentidgeneration.persistance.StudentRepository;
import zw.co.afrosoft.microservices.studentidgeneration.service.student.LoginDto;
import zw.co.afrosoft.microservices.studentidgeneration.service.student.StudentDto;
import zw.co.afrosoft.microservices.studentidgeneration.service.student.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final LoginDetailsRepository loginDetailsRepository;
    private final JavaMailSender mailSender; // Inject JavaMailSender directly into the service

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              LoginDetailsRepository loginDetailsRepository,
                              JavaMailSender mailSender) {
        this.studentRepository = studentRepository;
        this.loginDetailsRepository = loginDetailsRepository;
        this.mailSender = mailSender; // Inject JavaMailSender
    }
@Override
    public LoginDto saveStudent(StudentDto studentDto) {
        var student = Student.builder()
                .studentName(studentDto.getStudentName())
                .studentSurname(studentDto.getStudentSurname())
                .studentEmail(studentDto.getStudentEmail())
                .studentId(StudentIdGenerator.generateID(studentDto.getStudentName(), studentDto.getStudentSurname()))
                .build();
        String studentId = student.getStudentId();
        LoginDetails loginDetails = LoginDetails.builder()
                .username(studentId)
                .password(StudentPasswordGenerator.generatePassword())
                .build();
        studentRepository.save(student);
        loginDetailsRepository.save(loginDetails);

    LoginDto loginDto = LoginDto.builder()
            .firstName(student.getStudentName())
            .surname(student.getStudentSurname())
            .studentId(student.getStudentId())
            .username(loginDetails.getUsername())
            .password(loginDetails.getPassword())
            .email(student.getStudentEmail())
            .build();
        // Sending email directly from the service class
       // sendEmail(studentDto.getStudentEmail(), "Afrocodemy Login Info", loginDetails.toString());

        return loginDto;
    }

    private void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fasoft90@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Sent...");
    }
}
