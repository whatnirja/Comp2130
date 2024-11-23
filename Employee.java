import java.io.Serializable;

public class Employee implements Serializable {
    private String id; // Employee ID
    private String name; // Employee Name
    private String department; // Department Name
    private double hourlyRate; // Hourly Rate for the Employee
    private double hoursWorked; // Total Hours Worked
    private double overtimeHours; // Total Overtime Hours
    private double bonus; // Additional Bonuses
    private double deductions; // Deductions like taxes or penalties
    static int idGenerator = 0;

    // Default constructor
    public Employee() {
        this.id = ++idGenerator;
        this.name = "";
        this.department = "";
        this.hourlyRate = 0.0;
        this.hoursWorked = 0.0;
        this.overtimeHours = 0.0;
        this.bonus = 0.0;
        this.deductions = 0.0;
    }

    // Full constructor
    public Employee( String name, String jobTitle, String email,  String department, double hourlyRate, double hoursWorked, double overtimeHours, double bonus, double deductions) {
        this.id = ++idGenerator;
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
        this.bonus = bonus;
        this.deductions = deductions;
    }

    // Parameterized constructor
    public Employee(String name, String jobTitle, String email, String department,double hourlyRate) {
        this.id = ++idGenerator;
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.department = department;
        this.hourlyRate = hourlyRate;       
        this.hoursWorked = 0.0;     // Default value
        this.overtimeHours = 0.0;   // Default value
        this.bonus = 0.0;           // Default value
        this.deductions = 0.0;      // Default value
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getJobTitle() { return jobTitle; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public double getOvertimeHours() { return overtimeHours; }
    public double getBonus() { return bonus; }
    public double getDeductions() { return deductions; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public void setOvertimeHours(double overtimeHours) { this.overtimeHours = overtimeHours; }
    public void setBonus(double bonus) { this.bonus = bonus; }
    public void setDeductions(double deductions) { this.deductions = deductions; }


    //Methods
    public double calculateGrossSalary() {
        return (hourlyRate * hoursWorked) + (hourlyRate * overtimeHours * 1.5);
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() + bonus - deductions;
    }

    public String getDetaild(){
        String s="---Employee Details---\n";
        s+="ID: "+id+"\n";
        s+="Name: "+name+"\n";
        s+="Job Title: "+jobTitle+"\n";
        s+="Email: "+email+"\n";
        s+="Department: "+department+"\n";
        s+="Hourly Rate: "+hourlyRate+"\n";
        s+="Hours Worked: "+hoursWorked+"\n";
        s+="Overtime Hours: "+overtimeHours+"\n";
        s+="Bonus: "+bonus+"\n";
        s+="Deductions: "+deductions+"\n";
        s+="Gross Salary: "+calculateGrossSalary()+"\n";
        s+="Net Salary: "+calculateNetSalary()+"\n";
        return s;
    }

}
