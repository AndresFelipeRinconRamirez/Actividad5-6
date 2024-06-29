/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.uniminuto.conexionbd;

import co.edu.uniminuto.dao.libroDao.Conexion;
//import co.edu.uniminuto.dao.libroDao.libroDao;
//import co.edu.uniminuto.entity.Libro;

/**
 *
 * @author JAIR - PC
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = new Conexion();  //Instanciar objeto de tipo conexion en este caso

        conexion.getConectar();
//        int cantidad = 4;
        
//        Libro libro = new Libro("futbol","CR7","Deporte", cantidad);
//        libroDao dao = new libroDao();
//        dao.registrarLibro(libro);
////        

    }

}
