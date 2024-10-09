package advance_java.mvc_crud.service;

import java.util.List;
import java.util.Optional;

import advance_java.mvc_crud.dao.EmployeeRepository;
import advance_java.mvc_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		return this.employeeRepository.findById(id);
	}

	@Override
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		this.employeeRepository.deleteById(id);
	}
}






