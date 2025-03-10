/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Solaris
 */
public class MainProducto extends JFrame implements ActionListener{
    
    private JTextField txtCodigo, txtDescripcion, txtPrecio, txtStock;
    private JTextArea txtS;
    private JButton btnProcesar, btnBorrar;
    private JComboBox<String> cboOpcion;
    private ArregloProductos productos = new ArregloProductos();

    public MainProducto() {
        setTitle("Mantenimiento de Productos");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(214, 211, 206));

        // Etiquetas
        String[] labels = {"Opción", "Código", "Descripción", "Precio", "Stock"};
        int y = 15;
        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            lbl.setBounds(15, y, 100, 23);
            add(lbl);
            y += 24;
        }

        // Campos de texto
        txtCodigo = new JTextField();
        txtDescripcion = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        txtCodigo.setBounds(105, 39, 150, 23);
        txtDescripcion.setBounds(105, 63, 150, 23);
        txtPrecio.setBounds(105, 87, 150, 23);
        txtStock.setBounds(105, 111, 150, 23);
        add(txtCodigo);
        add(txtDescripcion);
        add(txtPrecio);
        add(txtStock);

        // ComboBox
        cboOpcion = new JComboBox<>(new String[]{"Ingresar", "Consultar", "Modificar", "Eliminar"});
        cboOpcion.setBounds(105, 15, 150, 23);
        add(cboOpcion);

        // Botones
        btnProcesar = new JButton("Procesar");
        btnBorrar = new JButton("Borrar");
        btnProcesar.setBounds(365, 15, 100, 23);
        btnBorrar.setBounds(365, 39, 100, 23);
        btnProcesar.addActionListener(this);
        btnBorrar.addActionListener(e -> borrar());
        add(btnProcesar);
        add(btnBorrar);

        // Área de texto
        txtS = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtS);
        scroll.setBounds(15, 140, 450, 200);
        add(scroll);
    }

    public void actionPerformed(ActionEvent e) {
        procesar();
    }

    private void procesar() {
        switch (cboOpcion.getSelectedIndex()) {
            case 0 -> ingresar();
            case 1 -> consultar();
            case 2 -> modificar();
            case 3 -> eliminar();
        }
    }

    private void ingresar() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        if (productos.buscar(codigo) == null) {
            Producto prod = new Producto(codigo, txtDescripcion.getText(), Double.parseDouble(txtPrecio.getText()), Integer.parseInt(txtStock.getText()));
            productos.adicionar(prod);
            listar();
            mensaje("Producto ingresado", "Confirmación");
        } else {
            mensaje("Código ya existe", "Error");
        }
    }

    private void consultar() {
        Producto prod = productos.buscar(Integer.parseInt(txtCodigo.getText()));
        txtS.setText(prod != null ? "Código: " + prod.getCodigo() + "\nDescripción: " + prod.getDescripcion() + "\nPrecio: " + prod.getPu() + "\nStock: " + prod.getStock() : "Producto no encontrado");
    }

    private void modificar() {
        Producto prod = productos.buscar(Integer.parseInt(txtCodigo.getText()));
        if (prod != null) {
            prod.setDescripcion(txtDescripcion.getText());
            prod.setPu(Double.parseDouble(txtPrecio.getText()));
            prod.setStock(Integer.parseInt(txtStock.getText()));
            listar();
            mensaje("Producto modificado", "Confirmación");
        } else {
            mensaje("Producto no existe", "Error");
        }
    }

    private void eliminar() {
        Producto prod = productos.buscar(Integer.parseInt(txtCodigo.getText()));
        if (prod != null) {
            productos.eliminar(prod);
            listar();
            mensaje("Producto eliminado", "Confirmación");
        } else {
            mensaje("Producto no existe", "Error");
        }
    }

    private void listar() {
        txtS.setText("Código\tDescripción\tPrecio\tStock\n");
        for (Producto p : productos.listar()) {
            txtS.append(p.getCodigo() + "\t" + p.getDescripcion() + "\t" + p.getPu() + "\t" + p.getStock() + "\n");
        }
    }

    private void borrar() {
        txtCodigo.setText(""); txtDescripcion.setText(""); txtPrecio.setText(""); txtStock.setText("");
    }

    private void mensaje(String msg, String tipo) {
        JOptionPane.showMessageDialog(this, msg, tipo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new MainProducto().setVisible(true);
    }
    
}
