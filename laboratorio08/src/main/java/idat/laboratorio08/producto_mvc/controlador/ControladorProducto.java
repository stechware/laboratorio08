/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto_mvc.controlador;

import idat.laboratorio08.producto_mvc.vista.VistaProducto;
import idat.laboratorio08.producto_mvc.modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Solaris
 */
public class ControladorProducto {
    
    private VistaProducto vista;
    private ArregloProductosMVC productos;

    public ControladorProducto(VistaProducto vista, ArregloProductosMVC productos) {
        this.vista = vista;
        this.productos = productos;

        vista.agregarEventoProcesar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesar();
            }
        });

        vista.agregarEventoBorrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
    }

    private void procesar() {
        int opcion = vista.cboOpcion.getSelectedIndex();
        switch (opcion) {
            case 0 -> ingresar();
            case 1 -> consultar();
            case 2 -> modificar();
            case 3 -> eliminar();
        }
    }

    private void ingresar() {
        int codigo = Integer.parseInt(vista.txtCodigo.getText());
        System.out.println("Ingreso"+vista.txtCodigo.getText());
        if (productos.buscar(codigo) == null) {
            ProductoMVC prod = new ProductoMVC(codigo, vista.txtDescripcion.getText(), Double.parseDouble(vista.txtPrecio.getText()), Integer.parseInt(vista.txtStock.getText()));
            productos.adicionar(prod);
            mostrar();
        }
    }

    private void consultar() {
        ProductoMVC prod = productos.buscar(Integer.parseInt(vista.txtCodigo.getText()));
        vista.txtS.setText(prod != null ? prod.toString() : "Producto no encontrado");
    }

    private void modificar() {
        int codigo = Integer.parseInt(vista.txtCodigo.getText());
        ProductoMVC prod = productos.buscar(codigo);
        if (prod != null) {
            prod.setDescripcion(vista.txtDescripcion.getText());
            prod.setPu(Double.parseDouble(vista.txtPrecio.getText()));
            prod.setStock(Integer.parseInt(vista.txtStock.getText()));
            vista.txtS.setText("Producto modificado:\n" + prod);
        } else {
            vista.txtS.setText("Producto no encontrado");
        }
        mostrar();
    }

    private void eliminar() {
        int codigo = Integer.parseInt(vista.txtCodigo.getText());
        productos.eliminar(codigo);
        vista.txtS.setText("Producto eliminado si existía");
        mostrar();
    }
    private void borrar() { vista.txtCodigo.setText(""); }
    
    
     private void mostrar() {
        vista.txtS.setText("Código\tDescripción\tPrecio\tStock\n");
        for (ProductoMVC p : productos.listar()) {
            vista.txtS.append(p.toString() + "\n");
        }
    }
}
