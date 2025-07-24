package Employee_Payroll_System_;
import java.util.ArrayList;

public class Payroll_System {
    private ArrayList<Employee> employeeList;
    public Payroll_System(){
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
              employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}
