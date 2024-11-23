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

    // Default constructor
    public Employee() {
        this.id = "";
        this.name = "";
        this.department = "";
        this.hourlyRate = 0.0;
        this.hoursWorked = 0.0;
        this.overtimeHours = 0.0;
        this.bonus = 0.0;
        this.deductions = 0.0;
    }

    // Parameterized constructor
    public Employee(String id, String name, String department, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0.0; // Initialized to 0
        this.overtimeHours = 0.0;
        this.bonus = 0.0;
        this.deductions = 0.0;
    }

    public Employee(String name2, String department2, double hourlyRate2, double hoursWorked2, double overtimeHours2,
        double bonus2, double deductions2) {
      //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    // Method to calculate gross salary
    public double calculateGrossSalary() {
        return (hourlyRate * hoursWorked) + (overtimeHours * hourlyRate * 1.5) + bonus;
    }

    // Method to calculate net salary
    public double calculateNetSalary() {
        return calculateGrossSalary() - deductions;
    }

    // Method to get employee details
    public String getDetails() {
      return "ID: " + id + ", Name: " + name + ", Department: " + department +
              ", Hourly Rate: $" + hourlyRate + ", Hours Worked: " + hoursWorked +
              ", Overtime Hours: " + overtimeHours + ", Bonus: $" + bonus +
              ", Deductions: $" + deductions + ", Net Salary: $" + calculateNetSalary();
    }
}
