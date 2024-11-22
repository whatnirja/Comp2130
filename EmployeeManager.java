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
        


        HBox hboxButtons= new HBox();
        hboxButtons.getChildren().addAll(add,delete,update);
        vbox.getChildren().addAll(title, grid, hboxButtons);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();

        
        add.setOnAction(e -> {
            Stage empStage= new Stage();
            GridPane empForm = new GridPane();
            empForm.setHgap(10);
            empForm.setVgap(10);

        
            Label nameLabel = new Label("Name");
            Label jobTitleLabel = new Label("Job Title");
            Label emailLabel = new Label("Email");
            Label departmentLabel = new Label("Department");

            
            TextField nameField = new TextField();
            TextField jobTitleField = new TextField();
            TextField emailField = new TextField();
            TextField departmentField = new TextField();

           
            empForm.add(nameLabel, 0, 1);
            empForm.add(nameField, 1, 1);
            empForm.add(jobTitleLabel, 0, 2);
            empForm.add(jobTitleField, 1, 2);
            empForm.add(emailLabel, 0, 3);
            empForm.add(emailField, 1, 3);
            empForm.add(departmentLabel, 0, 4);
            empForm.add(departmentField, 1, 4);

            Button save = new Button("Save");
            Button clear= new Button("Clear");

            HBox addempHbox= new HBox();
            addempHbox.getChildren().addAll(save,clear);
            

            save.setOnAction(e1 -> {
                
                String name = nameField.getText();
                String jobTitle = jobTitleField.getText();
                String email = emailField.getText();
                String department = departmentField.getText();

                if ( name.isEmpty() || jobTitle.isEmpty() || email.isEmpty() || department.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "All fields must be filled.");
                    alert.show();
                }else{
                    Employee employee = new Employee( name, jobTitle, email, department);
                    employeeList.add(employee);
                    updatedGrid();
                    empStage.close();
                }
                
            });

            clear.setOnAction(e1 -> {
                nameField.clear();
                jobTitleField.clear();
                emailField.clear();
                departmentField.clear();
            });

            VBox empVbox = new VBox();
            empVbox.getChildren().addAll(empForm, addempHbox);
            Scene empScene = new Scene(empVbox, 300, 300);
            empStage.setScene(empScene);
            empStage.show();
        });

        // delete.setOnAction(e -> {
        //     int selectedIndex = getSelectedId();
        //     for (int i = 0; i < employeeList.size(); i++) {
        //         Employee employee = employeeList.get(i);
        //         if (employee.getId().equals(selectedIndex)) {
        //             employeeList.remove(i);
        //             break;
        //         }
        //     }
        //     updatedGrid();
        // });

        /*
        update.setOnAction(e -> {
            int selectedIndex = Integer.parseInt(getSelectedId());
            for (int i = 0; i < employeeList.size(); i++) {
                Employee employee = employeeList.get(i);
                if (employee.getId().equals(selectedIndex)) {
                    Stage empStage= new Stage();
            GridPane empForm = new GridPane();
            empForm.setHgap(10);
            empForm.setVgap(10);

            Label nameLabel = new Label("Name");
            Label jobTitleLabel = new Label("Job Title");
            Label emailLabel = new Label("Email");
            Label departmentLabel = new Label("Department");

            TextField nameField = new TextField();
            TextField jobTitleField = new TextField();
            TextField emailField = new TextField();
            TextField departmentField = new TextField();

            empForm.add(nameLabel, 0, 1);
            empForm.add(nameField, 1, 1);
            empForm.add(jobTitleLabel, 0, 2);
            empForm.add(jobTitleField, 1, 2);
            empForm.add(emailLabel, 0, 3);
            empForm.add(emailField, 1, 3);
            empForm.add(departmentLabel, 0, 4);
            empForm.add(departmentField, 1, 4);

            Button save = new Button("Save");
            Button clear= new Button("Clear");

            HBox addempHbox= new HBox();
            addempHbox.getChildren().addAll(save,clear);
            

            save.setOnAction(e1 -> {
                String name = nameField.getText();
                String jobTitle = jobTitleField.getText();
                String email = emailField.getText();
                String department = departmentField.getText();

                if (name.isEmpty() || jobTitle.isEmpty() || email.isEmpty() || department.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "All fields must be filled.");
                    alert.show();
                }else{
                    Employee employee = new Employee(getSelectedId(), name, jobTitle, email, department);
                    employeeList.add(employee);
                    updatedGrid();
                    empStage.close();
                }
                
            });

            clear.setOnAction(e1 -> {
                idField.clear();
                nameField.clear();
                jobTitleField.clear();
                emailField.clear();
                departmentField.clear();
            });

            VBox empVbox = new VBox();
            empVbox.getChildren().addAll(empForm, addempHbox);
            Scene empScene = new Scene(empVbox, 300, 300);
            empStage.setScene(empScene);
            empStage.show();
        });
                }
            }

           
        
        
            }
        
        });*/


    }
    private int getSelectedId() {
        Stage IDStage= new Stage();
        GridPane IDForm = new GridPane();
        IDForm.setHgap(10);
        IDForm.setVgap(10);
        
        Label idLabel = new Label("ID");
        TextField idField = new TextField();
        
        IDForm.add(idLabel, 0, 0);
        IDForm.add(idField, 1, 0);
        
        Button save = new Button("Save");
        Button clear= new Button("Clear");
        
        HBox IDHbox= new HBox();
        IDHbox.getChildren().addAll(save,clear);

        int[] selectedId = new int[1];
        selectedId[0] = -1;
        
        save.setOnAction(e -> {
            try {
                selectedId[0] = Integer.parseInt(idField.getText());
                IDStage.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid ID. Please enter a numeric value.");
                alert.show();
            }
        });
        
        clear.setOnAction(e -> {
            idField.clear();
        });
        
        VBox IDVbox = new VBox();
        IDVbox.getChildren().addAll(IDForm, IDHbox);
        Scene IDScene = new Scene(IDVbox, 300, 300);
        IDStage.setScene(IDScene);
        IDStage.show();
        
        return selectedId[0];
    }
    
    private void empHeader() {
        grid.add(new Label("ID"), 0, 0);
        grid.add(new Label("Name"), 1, 0);
        grid.add(new Label("Job Title"), 2, 0);
        grid.add(new Label("Email"), 3, 0);
        grid.add(new Label("Department"), 4, 0);
    }

    private void updatedGrid() {
        grid.getChildren().clear();
        empHeader();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            grid.add(new Label (String.valueOf(employee.getId())), 0, i + 1);
            grid.add(new Label(employee.getName()), 1, i + 1);
            grid.add(new Label(employee.getJobTitle()), 2, i + 1);
            grid.add(new Label(employee.getEmail()), 3, i + 1);
            grid.add(new Label(employee.getDepartment()), 4, i + 1);
        }
        
    }

}
