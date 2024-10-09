package advance_java.mvc_crud.dao;

import advance_java.mvc_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// No need to define DAO interface and its implementation
//	Employee findByfirstName(String name);

}
