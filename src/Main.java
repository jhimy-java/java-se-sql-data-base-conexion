import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myCon = null;
        PreparedStatement myStmt = null;
        //ResultSet rs = null;

        try{
            myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","jhimy");
            System.out.println("Conexion establecida");

            String sql=("INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)");
            myStmt = myCon.prepareStatement(sql);

            myStmt.setString(1,"Johana");
            myStmt.setString(2,"Smith");

            int rowsAffected = myStmt.executeUpdate();

            if(rowsAffected>0){
                System.out.println("Se ha creado un nuevo cliente");
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Error al conectar con la base de datos");
        }

    }
}