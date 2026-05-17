package employee;

import java.util.HashMap;
import java.util.List;

public class EmployeeManager {
    private final HashMap<Long, Employee> employeeMap = new HashMap<>();
    private long sequence = 1L;

    public void add(Employee employee){
        long id = sequence++;
        employee.setId(id);
        employeeMap.put(id, employee);
    }

    public Employee findById(Long id){
        return employeeMap.get(id);
    }

    public List<Employee> findAll(){
        return employeeMap.values().stream().toList();
    }

    public Employee remove(Long id){
        return employeeMap.remove(id);
    }

    public boolean exists(Long id){
        return employeeMap.containsKey(id);
    }

    public boolean isEmpty(){
        return employeeMap.isEmpty();
    }

    public List<Employee> findNotWorking(){
        return employeeMap.values().stream().filter(employee -> !employee.isWorking()).toList();
    }

}
