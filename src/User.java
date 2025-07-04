import java.util.List;
import java.util.Scanner;

public abstract class User {
    private String name;
    private String password;
    private String role;

    public User(String username,String Password,String role){
        this.name=username;
        this.password=Password;
        this.role=role;
    }

    public String getName(){return this.name;}
    public String getPassword(){return this.password;}
    public String getRole(){return this.role;}

    public abstract void showMenu(Scanner scanner,List<Product> products);
}
