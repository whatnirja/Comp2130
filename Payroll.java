import java.util.ArrayList;

public class Payroll {
  Employee employee;
  private double salary;
  private double taxes;
  private double totalPay;

  public Payroll(Employee employee, double salary, double taxes) {
    this.employee = employee;
    this.salary = salary;
    this.taxes = taxes;
    this.totalPay = salary - taxes; 
  }

  public Payroll() {}

  public double calculateGrossSalary(Employee employee) {
    if (employee == null) {
      throw new IllegalArgumentException("Employee cannot be null");
    }  
    return employee.calculateGrossSalary();
  }

  public double calculateDeductions(Employee employee) {
    if (employee == null) {
      throw new IllegalArgumentException("Employee cannot be null");
    }
    double taxes = employee.getHourlyRate() * 0.15;
    double retirement = employee.getHourlyRate() * 0.05;
    return taxes + retirement;
  }

  public double calculateNetPay(Employee employee) {
    if (employee == null) {
      throw new IllegalArgumentException("Employee cannot be null");
    }
    double grossSalary = calculateGrossSalary(employee);
    double deductions = calculateDeductions(employee);
    return grossSalary - deductions;
  }

  public Boolean recordPayment(Employee employee, double pay) {
    
    System.out.printf("Payment of %.2f recorded for %s%n", pay, employee.getName());
        return true;
  }
  public String generatePaySlip(Employee employee) {
    double grossSalary = calculateGrossSalary(employee);
    double deductions = calculateDeductions(employee);
    double netPay = grossSalary - deductions;
    return "Pay Slip for " + employee.getName() + "\n" +
           "Gross Salary: $" + grossSalary + "\n" +
           "Deductions: $" + deductions + "\n" +
           "Net Pay: $" + netPay;
  }

  //one employee
  public String payroll(Employee employee) {
    double grossSalary = calculateGrossSalary(employee);
    double deductions = calculateDeductions(employee);
    double netPay = grossSalary - deductions;
    
    recordPayment(employee, netPay);

    return String.format("Payroll for %s\nGross Salary: %.2f\nDeductions: %.2f\nNet Pay: %.2f", employee.getName(), grossSalary, deductions, netPay);
  }

  //multiple employees
  public ArrayList<String> payrollManager(ArrayList<Employee> employees) {
    ArrayList<String> payrollReports = new ArrayList<>();

    for (Employee employee : employees) {
      double grossSalary = calculateGrossSalary(employee);
      double deductions = calculateDeductions(employee);
      double netPay = calculateNetPay(employee);

      recordPayment(employee, netPay);

      String report = String.format("Payroll for %s\nGross Salary: %.2f\nDeductions: %.2f\nNet Pay: %.2f", employee.getName(), grossSalary, deductions, netPay);
      payrollReports.add(report);
    }

    return payrollReports;

  }

  //summary
  public String payrollSummary(ArrayList<Employee> employees) {
    double totalGrossSalary = 0.0;
    double totalDeductions = 0.0;
    double totalNetPay = 0.0;

    for (Employee employee : employees) {
      double grossSalary = calculateGrossSalary(employee);
      double deductions = calculateDeductions(employee);
      double netPay = calculateNetPay(employee);

      totalGrossSalary += grossSalary;
      totalDeductions += deductions;
      totalNetPay += netPay;
    }

    return String.format("Payroll Summary\nTotal Gross Salary: %.2f\nTotal Deductions: %.2f\nTotal Net Pay: %.2f", totalGrossSalary, totalDeductions, totalNetPay); 
  }

  public String createPayrollReport(Employee employee, double grossSalary, double deductions, double netPay) {
    return String.format("Payroll for %s\nGross Salary: %.2f\nDeductions: %.2f\nNet Pay: %.2f", employee.getName(), grossSalary, deductions, netPay);
    
  }

}
