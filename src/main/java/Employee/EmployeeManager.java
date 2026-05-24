package Employee;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class EmployeeManager {
    private final HashMap<Long, Employee> employeeMap = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Object monitor = new Object();
    private long sequence = 1L;
    private int outsideWorker = 0;


    synchronized  public int getOutsideWorker() {
        return outsideWorker;
    }

    public Object getMonitor() {
        return monitor;
    }

    public void addEmployee(Employee employee){
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

    public Employee removeEmployee(Long id){
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

    public List<Employee> findWorking(){
        return employeeMap.values().stream().filter(Employee::isWorking).toList();
    }


    public boolean valOutsideWorker(){
        int totalEmployees = employeeMap.size();
        int maxOutsideWorker = totalEmployees/3;

        lock.lock();
        try{
            if(outsideWorker < maxOutsideWorker){
                outsideWorker++;
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }

    public void workOutside(Employee employee) throws InterruptedException {
        int random = ThreadLocalRandom.current().nextInt(10000, 30001); //외근이 10초 ~ 30초 중 랜덤으로 진행됨
        try {
            employee.startWork();
            System.out.printf("|직원 " + employee.getName()+ "이(가) %d초동안 외근을 시작합니다!|\n", random/1000);
            synchronized (monitor){ // 메인스레드에서 반납한 락 획득
                monitor.notify(); // 메인스레드에서 wait 중인 락 꺠움
            }
            Thread.sleep(random);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            lock.lock();
            try{
                employee.endWork();
                outsideWorker--;
            }finally {
                lock.unlock();
            }
        }
    }
}
