import javafx.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Application {
  private UserManager userManager;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Login");
    
    userManager = new UserManager("users.bin");
    userManager.addUser(new User("admin", "admin", "admin")); // example 

    Label username = new Label("Username:");
    Label password = new Label("Password:");

    TextField usernameField = new TextField();
    TextField passwordField = new TextField();

    Button loginBtn = new Button("Login");
    Label errorMessage = new Label();

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);

    grid.add(username, 0, 0);
    grid.add(usernameField, 1, 0);
    grid.add(password, 0, 1);
    grid.add(passwordField, 1, 1);
    grid.add(loginBtn, 1, 2);
    grid.add(errorMessage, 1, 3);

    loginBtn.setOnAction(e -> {
      String userName = usernameField.getText();
      String pwd = passwordField.getText();

      User user = userManager.authenticateUser(userName, pwd);
      if(user != null) {
        if(user.getRole().equals("admin")) {
          AdminUI adminUI = new AdminUI();
          adminUI.show(stage);
        } else if(user.getRole().equals("employee")) {
          EmployeeUI employeeUI = new EmployeeUI();
          employeeUI.show(stage);
        } else if(user.getRole().equals("HR")) {
          HRUI hrUI = new HRUI();
          hrUI.show(stage);
        }
      } else {
        errorMessage.setText("Invalid username or password");
      }
    });

    Scene scene = new Scene(grid, 300, 150);
    stage.setScene(scene);
    stage.show();

  }



}
