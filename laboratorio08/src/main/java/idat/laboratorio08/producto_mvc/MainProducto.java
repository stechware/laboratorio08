/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto_mvc;

import idat.laboratorio08.producto_mvc.controlador.ControladorProducto;
import idat.laboratorio08.producto_mvc.modelo.ArregloProductosMVC;
import idat.laboratorio08.producto_mvc.vista.VistaProducto;

/**
 *
 * @author Solaris
 */
public class MainProducto {
        public static void main(String[] args) {
            VistaProducto vista = new VistaProducto();
            ArregloProductosMVC productos = new ArregloProductosMVC();
            new ControladorProducto(vista, productos);
            vista.setVisible(true);
    }
}
