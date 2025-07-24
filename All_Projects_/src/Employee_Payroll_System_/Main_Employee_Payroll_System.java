package Employee_Payroll_System_;
public class Main_Employee_Payroll_System {
    public static void main(String[] args) {
        System.out.println("===================.........*** EMPLOYEE PAYROLL SYSTEM ***.........===================");
        Payroll_System payrollSystem = new Payroll_System();
        FullTimeEmployee F_emp1 = new FullTimeEmployee("john",1,7000);
        PartTimeEmployee P_emp1 = new PartTimeEmployee("Smith",2,40,100);

        payrollSystem.addEmployee(F_emp1);
        payrollSystem.addEmployee(P_emp1);
        System.out.println("Initial Employee details: ");
        payrollSystem.displayEmployee();

        System.out.println("Removing Employee id : ");
        payrollSystem.removeEmployee(2);

        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployee();
    }
}
