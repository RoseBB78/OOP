package com.ucreativa.vacunación.ui;
import com.ucreativa.vacunación.repositories.FileRepository;
import com.ucreativa.vacunación.services.BitacoraService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

    public FrontEnd(String titulo){
        super(titulo);
    }

    public void build(){
        this.construccionPantalla();
        this.crearComponentes();
        super.setVisible(true);
    }

    private void construccionPantalla(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 200);
        super.setLayout(new GridLayout(5, 2));
    }

    private void agregarComponente(Component componente){
        super.getContentPane().add(componente);
    }

    private void crearComponentes(){

        // Crear Labels
        JLabel lblNombre = new JLabel("Nombre");
        JLabel lblCedula = new JLabel("Cedula");
        JLabel lblEdad = new JLabel("Edad");
        JLabel lblRiesgo = new JLabel("Riesgo");
        JLabel lblEsAmigo = new JLabel("Es Amigo?");
        JLabel lblRelacion = new JLabel("Relación");
        JLabel lblFacebook = new JLabel("Facebook");
        JLabel lblParentesco = new JLabel("Parentesco");
        JLabel lblMarca = new JLabel("Marca");

        // Crear Textos
        JTextField txtNombre = new JTextField();
        JTextField txtCedula = new JTextField();
        JTextField txtEdad = new JTextField();
        JTextField txtRelacion = new JTextField();
        JTextField txtFacebook = new JTextField();
        JTextField txtParentesco = new JTextField();
        JTextField txtMarca = new JTextField();

        JCheckBox txtRiesgo = new JCheckBox();
        JCheckBox txtEsAmigo = new JCheckBox();
        txtEsAmigo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblParentesco.setVisible(!txtEsAmigo.isSelected());
                txtParentesco.setVisible(!txtEsAmigo.isSelected());
                lblRelacion.setVisible(txtEsAmigo.isSelected());
                txtRelacion.setVisible(txtEsAmigo.isSelected());
                lblFacebook.setVisible(txtEsAmigo.isSelected());
                txtFacebook.setVisible(txtEsAmigo.isSelected());

            }
        });

        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BitacoraService service = new BitacoraService(new FileRepository());
                service.save(txtNombre.getText(),
                        txtCedula.getText(),
                        txtEdad.getText(),
                        txtRiesgo.isSelected(),
                        txtEsAmigo.isSelected(),
                        txtRelacion.getText(),
                        txtFacebook.getText(),
                        txtParentesco.getText(),
                        txtMarca.getText());

                txtNombre.setText("");
                txtCedula.setText("");
                txtEdad.setText("");
                txtRiesgo.setText("");
                txtEsAmigo.setText("");
                txtRelacion.setText("");
                txtFacebook.setText("");
                txtParentesco.setText("");
                txtMarca.setText("");

                String reporte = String.join("\n", service.get());
                JOptionPane.showMessageDialog(((JButton)e.getSource()).getParent(), reporte);

            }
        });

        // Agregamos al UI
        this.agregarComponente(lblNombre);
        this.agregarComponente(txtNombre);
        this.agregarComponente(lblCedula);
        this.agregarComponente(txtCedula);
        this.agregarComponente(lblEdad);
        this.agregarComponente(txtEdad);
        this.agregarComponente(lblRiesgo);
        this.agregarComponente(txtRiesgo);
        this.agregarComponente(lblEsAmigo);
        this.agregarComponente(txtEsAmigo);
        this.agregarComponente(lblRelacion);
        this.agregarComponente(txtRelacion);
        this.agregarComponente(lblFacebook);
        this.agregarComponente(txtFacebook);
        this.agregarComponente(lblParentesco);
        this.agregarComponente(txtParentesco);
        this.agregarComponente(lblMarca);
        this.agregarComponente(txtMarca);
        this.agregarComponente(salvar);
        }
    }
