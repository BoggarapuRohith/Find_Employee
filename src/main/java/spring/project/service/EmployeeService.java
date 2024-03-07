package spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.configure.Employee;
import spring.project.repository.EmployeeRepository;

import java.util.List;

/**
 * @project EmployeeSearch
 * @Author Rohith
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> listAll(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee get(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> search(String keyword) {
        return employeeRepository.search(keyword);
    }
}
