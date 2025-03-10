/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto_mvc.modelo;

/**
 *
 * @author Solaris
 */
// Modelo
public class ProductoMVC {
    private int codigo, stock;
    private String descripcion;
    private double pu;

    public ProductoMVC(int codigo, String descripcion, double pu, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pu = pu;
        this.stock = stock;
    }

    public int getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPu() { return pu; }
    public int getStock() { return stock; }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPu(double pu) { this.pu = pu; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "ProductoMVC{" + "codigo=" + codigo + ", stock=" + stock + ", descripcion=" + descripcion + ", pu=" + pu + '}';
    }
    
    
}
