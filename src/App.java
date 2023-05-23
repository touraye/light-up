import db.ConnectDB;
import model.UserModel;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ConnectDB db = new ConnectDB();
        //Connect to DB
        db.DB();
        Scanner input = new Scanner(System.in);
        System.out.println("============Welcome to Cash Power App Registration System===============");
        System.out.println("Enter user full name");
        String name = input.next();
        System.out.println("Enter user phone");
        String phone = input.next();
        System.out.println("Enter user email");
        String email = input.next();

        UserModel userModel = new UserModel(name,phone, email);
        try {
            //try creating user
            db.createUser(name, phone, email);
        } catch (InputMismatchException ex){
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
}
