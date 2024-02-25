package zw.co.afrosoft.microservices.studentidgeneration.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.microservices.studentidgeneration.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Integer > {

}
