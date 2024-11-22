import javafx.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        
        Label title = new Label("Welcome to Employee Management System");
        Button empManageBtn= new Button("Employee System");
        Button payrollManageBtn= new Button("Payroll");
        Button deptManageBtn= new Button("Departments");
        Button reportBtn= new Button("Reports");

        VBox vbox = new VBox(10,title,empManageBtn,payrollManageBtn,deptManageBtn,reportBtn);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox,300,300);
        stage.setScene(scene);
        stage.show();

        empManageBtn.setOnAction(e -> new EmployeeManager().show(stage));
    }
}
