/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto_mvc.modelo;

import java.util.ArrayList;

/**
 *
 * @author Solaris
 */
public class ArregloProductosMVC {
    private ArrayList<ProductoMVC> productos;

    public ArregloProductosMVC() {
        productos = new ArrayList<>();
    }

    public void adicionar(ProductoMVC p) { productos.add(p); }
    
    public void eliminar(int codigo) { 
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                productos.remove(i);
                break;
            }
        }
    }
    public ProductoMVC obtener(int pos) { return productos.get(pos); }
    public ProductoMVC buscar(int codigo) {
        
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                return productos.get(i);
            }
        }
        return null;

        //return productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }
    public int tamaño() { return productos.size(); }
    //public Producto mayorPrecio() { return productos.stream().max((p1, p2) -> Double.compare(p1.getPu(), p2.getPu())).orElse(null); }
    //public Producto menorPrecio() { return productos.stream().min((p1, p2) -> Double.compare(p1.getPu(), p2.getPu())).orElse(null); }

    public ProductoMVC mayorPrecio() {
        if (productos.isEmpty()) {
            return null;
        }
        ProductoMVC maxProducto = productos.get(0);
        for (int i = 1; i < productos.size(); i++) {
            if (productos.get(i).getPu() > maxProducto.getPu()) {
                maxProducto = productos.get(i);
            }
        }
        return maxProducto;

    }
    //public Producto menorPrecio() { return productos.stream().min((p1, p2) -> Double.compare(p1.getPu(), p2.getPu())).orElse(null); }
    
    public ProductoMVC menorPrecio() {
        if (productos.isEmpty()) {
            return null; // Retorna null si no hay productos en la lista
        }

        ProductoMVC menor = productos.get(0); // Se asume que el primer producto tiene el menor precio

        for (int i = 1; i < productos.size(); i++) {
            if (productos.get(i).getPu() < menor.getPu()) {
                menor = productos.get(i);
            }
        }
        return menor;
    }
    
    public ArrayList<ProductoMVC> listar() { return productos; }

}
