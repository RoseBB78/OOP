package com.ucreativa.Proyecto.ui;
import com.ucreativa.Proyecto.repositories.FileRepositoryAcademia;
import com.ucreativa.Proyecto.services.AcademiaTaekwondoOrienteService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {
        public FrontEnd(String titulo) {
            super(titulo);
        }

        public void build() {
            this.construccionPantalla();
            this.crearComponentes();
            super.setVisible(true);
        }

        private void construccionPantalla() {
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setSize(500, 200);
            super.setLayout(new GridLayout(5, 2));
        }

        private void agregarComponente(Component componente) {
            super.getContentPane().add(componente);
        }

        private void crearComponentes() {

            // Crear Labels
            JLabel lblNombre = new JLabel("Nombre");
            JLabel lblCedula = new JLabel("Cedula");
            JLabel lblEdad = new JLabel("Edad");
            JLabel lblpadecimineto = new JLabel("Tiene algún Padecimineto");
            JLabel lblEsAlumno = new JLabel("Es Alumno?");
            JLabel lblencargado = new JLabel("Encargado del menor");
            JLabel lblParentesco = new JLabel("Parentesco");
            JLabel lblcinturon = new JLabel("Cinturón Actual");

            // Crear Textos
            JTextField txtNombre = new JTextField();
            JTextField txtCedula = new JTextField();
            JTextField txtEdad = new JTextField();
            JTextField txtencargado = new JTextField();
            JTextField txtParentesco = new JTextField();
            JTextField txtCinturon = new JTextField();
            JCheckBox txtPadecimineto = new JCheckBox();
            JCheckBox txtEsAlumno = new JCheckBox();
            txtEsAlumno.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lblParentesco.setVisible(!txtEsAlumno.isSelected());
                    txtParentesco.setVisible(!txtEsAlumno.isSelected());
                    lblencargado.setVisible(txtEsAlumno.isSelected());
                    txtencargado.setVisible(txtEsAlumno.isSelected());
                }
            });

            JButton salvar = new JButton("Salvar");
            salvar.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AcademiaTaekwondoOrienteService service = new AcademiaTaekwondoOrienteService(new FileRepositoryAcademia());
                    try {
                        service.save(txtNombre.getText(),
                                txtCedula.getText(),
                                txtEdad.getText(),
                                txtPadecimineto.isSelected(),
                                txtEsAlumno.isSelected(),
                                txtencargado.getText(),
                                txtParentesco.getText(),
                                txtCinturon.getText());
                    } catch (ErrorEnAlumnoException errorEnAlumnoException) {
                        System.out.println (errorEnAlumnoException);
                    }

                    txtNombre.setText("");
                    txtCedula.setText("");
                    txtEdad.setText("");
                    txtPadecimineto.setText("");
                    txtEsAlumno.setText("");
                    txtencargado.setText("");
                    txtParentesco.setText("");
                    txtCinturon.setText("");

                    try {
                        service.save(txtNombre.getText(),
                                txtCedula.getText(),
                                txtEdad.getText(),
                                txtPadecimineto.isSelected(),
                                txtEsAlumno.isSelected(),
                                txtencargado.getText(),
                                txtParentesco.getText(),
                                txtCinturon.getText());

                        txtNombre.setText("");
                        txtCedula.setText("");
                        txtEdad.setText("");
                        txtPadecimineto.setText("");
                        txtEsAlumno.setText("");
                        txtencargado.setText("");
                        txtParentesco.setText("");
                        txtCinturon.setText("");

                        String reporte = String.join("\n", service.get());
                        JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), reporte);
                    } catch (ErrorEnAlumnoException error) {
                        JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), error.getMessage());
                    }
                }
            });
            // Agregamos al UI
            this.agregarComponente(lblNombre);
            this.agregarComponente(txtNombre);
            this.agregarComponente(lblCedula);
            this.agregarComponente(txtCedula);
            this.agregarComponente(lblEdad);
            this.agregarComponente(txtEdad);
            this.agregarComponente(lblpadecimineto);
            this.agregarComponente(txtPadecimineto);
            this.agregarComponente(lblEsAlumno);
            this.agregarComponente(txtEsAlumno);
            this.agregarComponente(lblencargado);
            this.agregarComponente(txtencargado);
            this.agregarComponente(lblParentesco);
            this.agregarComponente(txtParentesco);
            this.agregarComponente(lblcinturon);
            this.agregarComponente(txtCinturon);
            this.agregarComponente(salvar);
        }
}
