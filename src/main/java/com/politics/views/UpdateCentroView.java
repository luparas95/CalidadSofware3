package com.politics.views;

import java.awt.event.*;
import javax.swing.*;

import com.politics.controllers.CentroController;
import com.politics.models.vo.CentroVo;
import com.politics.views.validations.Validations;

public class UpdateCentroView {
    
    public static void mostrar(int idCentro) {
        
        final CentroVo centro = CentroController.getCentroById(idCentro);
        LoadingView.ocultar();
        
        final JFrame f = new JFrame("Modificar Centro");

        JLabel nombreLbl = new JLabel("Nombre");
        nombreLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(nombreLbl);

        final JTextField nombreField = new JTextField();
        nombreField.setBounds(50, 70, 280, 25);
        f.getContentPane().add(nombreField);
        nombreField.setColumns(10);
        nombreField.setText(centro.getNombre());
         
        JLabel electoresLbl = new JLabel("Electores");
        electoresLbl.setBounds(50, 150, 280, 14);
        f.getContentPane().add(electoresLbl);

        final JTextField electoresField = new JTextField();
        electoresField.setBounds(50, 170, 280, 25);
        f.getContentPane().add(electoresField);
        electoresField.setColumns(10);
        electoresField.setText("" + centro.getElectores());
        
        JButton bCrearCentros = new JButton("Actualizar");
        JButton bVolver = new JButton("Volver");
        
        bCrearCentros.setBounds(50, 310, 130, 30);
        bVolver.setBounds(200, 310, 130, 30);
        
        bCrearCentros.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (!Validations.cadenaValida(nombreField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un nombre");
                
                } else if (!Validations.numeroValido(electoresField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca una cifra en los electores");
                
                } else {
                
                    f.setVisible(false);
                    LoadingView.mostrar();
                    centro.setNombre(nombreField.getText());
                    centro.setElectores(Integer.parseInt(electoresField.getText()));
                    CentroController.updateCentro(centro);
                    LoadingView.ocultar();
                    MenuCentroView.mostrar();
                
                }

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuCentroView.mostrar();

            }

        });
        
        f.add(bCrearCentros);
        f.add(bVolver);
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}