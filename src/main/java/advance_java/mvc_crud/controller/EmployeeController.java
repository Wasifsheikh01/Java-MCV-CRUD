package advance_java.mvc_crud.controller;

import advance_java.mvc_crud.entity.Employee;
import advance_java.mvc_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model model) {

		// Get the employees from database
		List<Employee> employees = employeeService.findAll();

		// Add to the spring model
		model.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {

		// Create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") int id, Model model) {

		// Get the employee from the service
		Optional<Employee> employee = this.employeeService.findById(id);

		// Set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);

		// Send over to our form
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		// Save the employee
		this.employeeService.save(employee);

		// Use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// Delete the employee
		employeeService.deleteById(theId);

		// Redirect to /employees/list
		return "redirect:/employees/list";

	}
}









