
package co.edu.uniminuto.dao.libroDao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {

    private final String usuario;
    private final String contra;
    private final String puerto;
    private final String servidor;
    private final String nombreDB;
    private final String cadena;
    Connection conex;
    public Conexion() {
        this.usuario="root";
        this.contra="";
        this.puerto="3306";
        this.servidor="localhost";
        this.nombreDB="biblioteca";
        this.cadena="jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+this.nombreDB;
        this.conex =null;
}
    private Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conex = DriverManager.getConnection(this.cadena,this.usuario,this.contra);
            JOptionPane.showMessageDialog(null, "Hay conexion");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No hay conexion");
        }finally {
        }
        return this.conex;
    }  
    
    public Connection getConectar(){
        return this.conectar();
    }
    
}
 
