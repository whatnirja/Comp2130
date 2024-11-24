import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeeManager {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private GridPane grid;

    public void show(Stage stage) {
        VBox vbox = new VBox();

        Label title = new Label("Employee Management");

        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        updatedGrid();

        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button update = new Button("Update");

        HBox hboxButtons = new HBox();
        hboxButtons.getChildren().addAll(add, delete, update);
        vbox.getChildren().addAll(title, grid, hboxButtons);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();

        add.setOnAction(e -> {
            Stage empStage = new Stage();
            GridPane empForm = new GridPane();
            empForm.setHgap(10);
            empForm.setVgap(10);

            // Labels
            Label nameLabel = new Label("Name");
            Label departmentLabel = new Label("Department");
            Label hourlyRateLabel = new Label("Hourly Rate");
            Label hoursWorkedLabel = new Label("Hours Worked");
            Label overtimeHoursLabel = new Label("Overtime Hours");
            Label bonusLabel = new Label("Bonus");
            Label deductionsLabel = new Label("Deductions");

            // Input fields
            TextField nameField = new TextField();
            TextField departmentField = new TextField();
            TextField hourlyRateField = new TextField();
            TextField hoursWorkedField = new TextField();
            TextField overtimeHoursField = new TextField();
            TextField bonusField = new TextField();
            TextField deductionsField = new TextField();

            // Add components to the form
            empForm.add(nameLabel, 0, 1);
            empForm.add(nameField, 1, 1);
            empForm.add(departmentLabel, 0, 2);
            empForm.add(departmentField, 1, 2);
            empForm.add(hourlyRateLabel, 0, 3);
            empForm.add(hourlyRateField, 1, 3);
            empForm.add(hoursWorkedLabel, 0, 4);
            empForm.add(hoursWorkedField, 1, 4);
            empForm.add(overtimeHoursLabel, 0, 5);
            empForm.add(overtimeHoursField, 1, 5);
            empForm.add(bonusLabel, 0, 6);
            empForm.add(bonusField, 1, 6);
            empForm.add(deductionsLabel, 0, 7);
            empForm.add(deductionsField, 1, 7);

            Button save = new Button("Save");
            Button clear = new Button("Clear");

            HBox addEmpHbox = new HBox();
            addEmpHbox.getChildren().addAll(save, clear);

            save.setOnAction(e1 -> {
                try {
                    // Get values from input fields
                    String name = nameField.getText();
                    String department = departmentField.getText();
                    double hourlyRate = Double.parseDouble(hourlyRateField.getText());
                    double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
                    double overtimeHours = Double.parseDouble(overtimeHoursField.getText());
                    double bonus = Double.parseDouble(bonusField.getText());
                    double deductions = Double.parseDouble(deductionsField.getText());

                    // Validation
                    if (name.isEmpty() || department.isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Name and Department cannot be empty.");
                        alert.show();
                    } else {
                        // Create and add the new Employee
                        Employee employee = new Employee(name, department, hourlyRate, hoursWorked, overtimeHours, bonus, deductions);
                        employeeList.add(employee);
                        updatedGrid();
                        empStage.close();
                    }
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter valid numeric values for salary fields.");
                    alert.show();
                }
            });

            clear.setOnAction(e1 -> {
                nameField.clear();
                departmentField.clear();
                hourlyRateField.clear();
                hoursWorkedField.clear();
                overtimeHoursField.clear();
                bonusField.clear();
                deductionsField.clear();
            });

            VBox empVbox = new VBox();
            empVbox.getChildren().addAll(empForm, addEmpHbox);
            Scene empScene = new Scene(empVbox, 400, 400);
            empStage.setScene(empScene);
            empStage.show();
        });
    }

    private void empHeader() {
        grid.add(new Label("ID"), 0, 0);
        grid.add(new Label("Name"), 1, 0);
        grid.add(new Label("Department"), 2, 0);
        grid.add(new Label("Hourly Rate"), 3, 0);
        grid.add(new Label("Hours Worked"), 4, 0);
        grid.add(new Label("Overtime Hours"), 5, 0);
        grid.add(new Label("Bonus"), 6, 0);
        grid.add(new Label("Deductions"), 7, 0);
        grid.add(new Label("Net Salary"), 8, 0);
    }

    private void updatedGrid() {
        grid.getChildren().clear();
        empHeader();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            grid.add(new Label(String.valueOf(employee.getId())), 0, i + 1);
            grid.add(new Label(employee.getName()), 1, i + 1);
            grid.add(new Label(employee.getDepartment()), 2, i + 1);
            grid.add(new Label(String.format("%.2f", employee.getHourlyRate())), 3, i + 1);
            grid.add(new Label(String.format("%.2f", employee.getHoursWorked())), 4, i + 1);
            grid.add(new Label(String.format("%.2f", employee.getOvertimeHours())), 5, i + 1);
            grid.add(new Label(String.format("%.2f", employee.getBonus())), 6, i + 1);
            grid.add(new Label(String.format("%.2f", employee.getDeductions())), 7, i + 1);
            grid.add(new Label(String.format("%.2f", employee.calculateNetSalary())), 8, i + 1);
        }
    }

    private void addEmployee() {
        Stage empStage = new Stage();
        GridPane empForm = new GridPane();
        empForm.setHgap(10); 
        empForm.setVgap(10);   

        TextField nameField = new TextField();
        TextField departmentField = new TextField();
        TextField hourlyRateField = new TextField();
        TextField hoursWorkedField = new TextField();
        TextField overtimeHoursField = new TextField();
        TextField bonusField = new TextField();
        TextField deductionsField = new TextField();
    
        empForm.add(new Label("Name"), 0, 0);
        empForm.add(nameField, 1, 0);
        empForm.add(new Label("Department"), 0, 1);
        empForm.add(departmentField, 1, 1);
        empForm.add(new Label("Hourly Rate"), 0, 2);
        empForm.add(hourlyRateField, 1, 2);
        empForm.add(new Label("Hours Worked"), 0, 3);
        empForm.add(hoursWorkedField, 1, 3);
        empForm.add(new Label("Overtime Hours"), 0, 4);
        empForm.add(overtimeHoursField, 1, 4);
        empForm.add(new Label("Bonus"), 0, 5);
        empForm.add(bonusField, 1, 5);
        empForm.add(new Label("Deductions"), 0, 6);
        empForm.add(deductionsField, 1, 6);
    
        Button save = new Button("Save");
        Button clear = new Button("Clear");
    
        save.setOnAction(e -> {
            String name = nameField.getText();
            String department = departmentField.getText();
            try {
                double hourlyRate = Double.parseDouble(hourlyRateField.getText());
                double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
                double overtimeHours = Double.parseDouble(overtimeHoursField.getText());
                double bonus = Double.parseDouble(bonusField.getText());
                double deductions = Double.parseDouble(deductionsField.getText());
    
                if (name.isEmpty() || department.isEmpty()) {
                    showAlert(Alert.AlertType.WARNING, "Missing Data", "Name and Department are required!");
                } else {
                    Employee newEmployee = new Employee(name, department, department, department, hourlyRate, hoursWorked, overtimeHours, bonus, deductions);
                    employeeList.add(newEmployee);
                    empStage.close(); 
                    updatedGrid();    
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numbers for rates and hours!");
            }
        });
    
        clear.setOnAction(e -> {
            nameField.clear();
            departmentField.clear();
            hourlyRateField.clear();
            hoursWorkedField.clear();
            overtimeHoursField.clear();
            bonusField.clear();
            deductionsField.clear();
        });

        VBox vbox = new VBox(10, empForm, new HBox(10, save, clear));
        Scene scene = new Scene(vbox, 400, 400);
        empStage.setScene(scene);
        empStage.show();
    }
    
    private void deleteEmployee() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Delete Employee");
        dialog.setContentText("Enter Employee ID:");
        dialog.showAndWait().ifPresent(idStr -> {
            try {
                int id = Integer.parseInt(idStr);
                boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
                if (removed) {
                    updatedGrid();
                } else {
                    showAlert(Alert.AlertType.WARNING, "Not Found", "Employee not found!");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "ID must be a number!");
            }
        });
    }
    
    private void showAlert(Alert.AlertType type, String title, String message) {
        
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
