package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    private Statement statement;
    private Connection connection;

    public void DB(){
        try{
            connection = DriverManager.getConnection("jdbc:myslq://localhost:3306/cashpower", "root", "touraye7");
            this.statement = this.connection.createStatement();
            System.out.println("DB connected....");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void createUser(String name, String phone, String email){
        try {
            String query = "INSERT INTO user(user_name, user_phone, user_email) VALUES('"+name+"', '"+phone+"', '"+email+"')";
            this.statement.execute(query);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
