/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto;

import java.util.ArrayList;

/**
 *
 * @author Solaris
 */
// Clase para manejar los productos
class ArregloProductos {
    private ArrayList<Producto> prod;

    public ArregloProductos() {
        prod = new ArrayList<>();
    }

    public void adicionar(Producto p) { prod.add(p); }
    public void eliminar(Producto p) { prod.remove(p); }
    public Producto buscar(int codigo) {
        for (Producto p : prod) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }
    public int tamaño() { return prod.size(); }
    public ArrayList<Producto> listar() { return prod; }
    //public double mayorPrecio() { return prod.stream().mapToDouble(Producto::getPu).max().orElse(0); }
    //public double menorPrecio() { return prod.stream().mapToDouble(Producto::getPu).min().orElse(0); }
}

