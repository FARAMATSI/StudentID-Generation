package zw.co.afrosoft.springjpacourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.springjpacourse.domain.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
