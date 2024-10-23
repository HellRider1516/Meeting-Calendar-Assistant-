package in.mahesh.Dao;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import in.mahesh.Model.Employee;

@Repository
public class CalendarDao {
 private final Map<String, Employee> employeeDatabase = new HashMap<>();

 public void addEmployee(Employee employee) {
     employeeDatabase.put(employee.getId(), employee);
 }

 public Employee getEmployee(String id) {
     return employeeDatabase.get(id);
 }
}


