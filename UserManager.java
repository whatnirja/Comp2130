import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserManager {
  private ArrayList<User> users;
  private final String filepath;

  public UserManager(String filepath) {
    this.users = loadUsers();
    this.filepath = filepath;
  }

  public void addUser(User user) {
    users.add(user);
    saveUsers();
  }

  public User authenticateUser(String username, String password) {
    for(User user : users) {
      if(user.authenticateUser(username, password)) {
        return user;
      }
    }
    return null;
  }

  public void saveUsers() {
    try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filepath))) {
      o.writeObject(users);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<User> loadUsers() {
    try(ObjectInputStream i = new ObjectInputStream(new FileInputStream(filepath))){
      return (ArrayList<User>) i.readObject();
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }
  
}
