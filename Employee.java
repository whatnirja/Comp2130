public class Employee {

    private String id;
    private String name;
    private String jobTitle;
    private String email;
    private String department;

    public Employee(String id, String name, String jobTitle, String email,  String department) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.department = department;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getJobTitle() { return jobTitle; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }

}