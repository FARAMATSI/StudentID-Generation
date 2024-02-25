package zw.co.afrosoft.microservices.studentidgeneration.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.microservices.studentidgeneration.domain.Student;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer repID;
    private String name;

    @OneToMany(mappedBy = "representative")
    private List<Student> studentList;

    // Constructors, getters, and setters
}
