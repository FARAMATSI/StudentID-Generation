package zw.co.afrosoft.microservices.studentidgeneration.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.microservices.studentidgeneration.domain.LoginDetails;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails,String> {
}
