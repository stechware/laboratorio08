/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto;

/**
 *
 * @author Solaris
 */
// Clase Producto
class Producto {
    private int codigo, stock;
    private String descripcion;
    private double pu;

    public Producto(int codigo, String descripcion, double pu, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pu = pu;
        this.stock = stock;
    }

    public int getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPu() { return pu; }
    public int getStock() { return stock; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPu(double pu) { this.pu = pu; }
    public void setStock(int stock) { this.stock = stock; }
}
