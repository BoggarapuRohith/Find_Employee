package spring.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring.project.configure.Employee;

import java.util.List;

/**
 * @project EmployeeSearch
 * @Author Rohith
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT c FROM Employee c WHERE c.name LIKE '%'||:keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    public List<Employee> search(@Param("keyword") String keyword);
}
