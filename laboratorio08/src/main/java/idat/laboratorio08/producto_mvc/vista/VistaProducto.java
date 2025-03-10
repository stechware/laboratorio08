/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idat.laboratorio08.producto_mvc.vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Solaris
 */
public class VistaProducto extends JFrame {
    public JTextField txtCodigo, txtDescripcion, txtPrecio, txtStock;
    public JTextArea txtS;
    public JButton btnProcesar, btnBorrar;
    public JComboBox<String> cboOpcion;

    public VistaProducto() {
        setTitle("Mantenimiento de Productos");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(214, 211, 206));

        // Labels
        JLabel lblOpcion = new JLabel("Opción");
        lblOpcion.setBounds(15, 15, 100, 23);
        add(lblOpcion);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(15, 39, 100, 23);
        add(lblCodigo);

        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setBounds(15, 63, 100, 23);
        add(lblDescripcion);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(15, 87, 100, 23);
        add(lblPrecio);

        JLabel lblStock = new JLabel("Stock");
        lblStock.setBounds(15, 111, 100, 23);
        add(lblStock);

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
        add(btnProcesar);
        add(btnBorrar);

        // Área de texto
        txtS = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtS);
        scroll.setBounds(15, 140, 450, 200);
        add(scroll);
    }

    public void agregarEventoProcesar(ActionListener actionListener) {
        btnProcesar.addActionListener(actionListener);
    }

    public void agregarEventoBorrar(ActionListener actionListener) {
        btnBorrar.addActionListener(actionListener);
    }
}
