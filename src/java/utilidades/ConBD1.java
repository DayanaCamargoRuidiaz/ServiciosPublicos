

package utilidades;

import java.sql.Connection; //conexion java con Myql
import java.sql.Statement;
import java.sql.DriverManager; //Para reconocer la libreria Myql
import java.sql.ResultSet; // permite devolver un resultado
import java.sql.PreparedStatement;
import java.sql.SQLException;// permite mostrar los posibles errores que puedan ocurrir con la conexion, tablas, bd en Mysql.



public class ConBD1 {

   public ConBD1(){}
   
    public static Connection getConexionMysql(){
        
        Connection conectar= null;
       
        try{
            
          String url= "jdbc:mysql://localhost/serviciospublicos";
          String usuario="root";
          String contraseña ="";
          Class.forName("com.mysql.jdbc.Driver"); //conector que debe buscar para la conexion
          conectar=DriverManager.getConnection(url,usuario,contraseña);
          
            
        }
   catch(Exception e){
       e.printStackTrace(); // sino del try
       
   }     
    
finally{
            return conectar;
        }
    }    
           public static void main(String[] args) {
        ConBD1.getConexionMysql(); // instanciar la clase
           
           }    

}