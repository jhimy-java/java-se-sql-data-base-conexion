import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myCon = null;
        Statement myStmt = null;
        ResultSet myRes = null;

        try{
            myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","jhimy");
            System.out.println("Conexion establecida");

            myStmt=myCon.createStatement();

            int rowsAffected = myStmt.executeUpdate("UPDATE employees "+ "set email='johanador@exmple.com' "+"WHERE first_name='Johana'");
            //int rowsAffected = myStmt.executeUpdate("DELETE FROM employees " + "WHERE first_name='Johana'");

            myRes=myStmt.executeQuery("SELECT * FROM employees order by pa_surname");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Error al conectar con la base de datos");
        }

    }
}