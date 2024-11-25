import java.util.ArrayList;

public class PayrollManager {
    private Payroll payroll;
    private ArrayList<Employee> employees;

    // Constructor
    public PayrollManager() {
        this.payroll = new Payroll();
        this.employees = new ArrayList<>();
    }

    // Add an employee to the system
    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Employee cannot be null.");
        } else {
            employees.add(employee);
            System.out.println("Employee " + employee.getName() + " added successfully.");
        }
    }

    // Generate payroll for a single employee
    public void processSingleEmployeePayroll(Employee employee) {
        if (employee == null) {
            System.out.println("Employee cannot be null.");
        } else {
            String report = payroll.payroll(employee);
            System.out.println(report);
        }
    }

    // Generate payroll for all employees
    public void processAllEmployeesPayroll() {
        if (employees.isEmpty()) {
            System.out.println("No employees to process payroll for.");
        } else {
            ArrayList<String> reports = payroll.payrollManager(employees);
            for (String report : reports) {
                System.out.println(report);
            }
        }
    }

    // Show payroll summary
    public void showPayrollSummary() {
        if (employees.isEmpty()) {
            System.out.println("No employees to summarize payroll for.");
        } else {
            String summary = payroll.payrollSummary(employees);
            System.out.println(summary);
        }
    }

    // List all employees
    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println("- " + employee.getName());
            }
        }
    }
}
