package zw.co.afrosoft.microservices.studentidgeneration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String studentId;
    private String studentName;
    private String studentSurname;
    private String studentEmail;
    @ManyToOne
    @JoinColumn(name = "repID") // Name of the foreign key column
    private Representative representative;

    // Constructors, getters, and setters
}
