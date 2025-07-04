import java.util.Scanner;

public class Admin extends User {
    public Admin(String username,String password){
        super(username,password,"Admin");
    }
    @Override
    public void showMenu(Scanner scanner){
        System.out.println("Admin menu");
    };

}
