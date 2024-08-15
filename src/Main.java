import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myCon = null;
        Statement myStmt = null;
        ResultSet rs = null;

        try{
            myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","jhimy");
            System.out.println("Conexion establecida");

            myStmt = myCon.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM employees");
            while(rs.next()){
                System.out.println(rs.getString("first_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Error al conectar con la base de datos");
        }

    }
}