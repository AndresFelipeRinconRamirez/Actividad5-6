
package co.edu.uniminuto.dao.libroDao;

import co.edu.uniminuto.entity.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class libroDao {
    
    Conexion conexion;
    PreparedStatement statement;
    
    public libroDao() {
    conexion = new Conexion();
    this.statement = null;
}
    public Libro registrarLibro (Libro libro){
        Connection con = conexion.getConectar();
        //int cantidad = 1;
        String query ="INSERT INTO libro VALUES(null,?,?,?,?)";
        try {
            if(this.statement == null){
                this.statement = con.prepareStatement(query); 
            }
                this.statement.setString(1, libro.getTitulo());
                this.statement.setString(2, libro.getAutor());
                this.statement.setString(3, libro.getGenero());
                this.statement.setInt(4, libro.getCantidad());
                int respuesta = this.statement.executeUpdate();
                if (respuesta>0){ 
                JOptionPane.showMessageDialog(null, "Ha sido registrado con exito"+respuesta);
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        } finally {
            if(con != null){
                try {
                    if(statement != null){
                       statement.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(libroDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return libro;
    }
    // metodo para consultar libros
   public List<Libro> obtenerLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection connection = conexion.getConectar();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Libro libro = new Libro(
                        resultSet.getString("nom_libro"),
                        resultSet.getString("aut_libro"),
                        resultSet.getString("genero"),
                        resultSet.getInt("cantidad"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
   }
        
  public Libro actualizarLibro(Libro libro){
    List<Libro> libros = new ArrayList<>();
    String sql = "UPDATE libro SET nom_libro = , aut_libro = ?, genero = ?, cantidad = ? WHERE id = ?";
    try (Connection connection = conexion.getConectar();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, libro.getTitulo());
        statement.setString(2, libro.getAutor());
        statement.setString(3, libro.getGenero());
        statement.setInt(4, libro.getCantidad());
        libros.add(libro);
        
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return (Libro) libros;
}      
}
 