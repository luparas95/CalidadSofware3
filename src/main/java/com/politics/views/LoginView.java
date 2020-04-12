package com.politics.views;

import java.awt.event.*;
import javax.swing.*;

import com.politics.controllers.LoginController;
import com.politics.views.validations.Validations;

public class LoginView {
    
    public static void mostrar() {
        
        final JFrame f = new JFrame("Login");

        JLabel nombreLbl = new JLabel("Nombre");
        nombreLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(nombreLbl);

        final JTextField nombreField = new JTextField();
        nombreField.setBounds(50, 70, 280, 25);
        f.getContentPane().add(nombreField);
        nombreField.setColumns(10);
         
        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(50, 150, 280, 14);
        f.getContentPane().add(passwordLbl);

        final JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 170, 280, 25);
        f.getContentPane().add(passwordField);
        passwordField.setColumns(10);
        
        JButton bLogin = new JButton("Aceptar");
        
        bLogin.setBounds(130, 310, 130, 30);
        
        bLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (!Validations.cadenaValida(nombreField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un nombre");
                
                } else if (!Validations.cadenaValida(passwordField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un password");
                
                } else {
                
                    f.setVisible(false);
                    LoadingView.mostrar();
                    if (LoginController.checkLogin(nombreField.getText(), String.valueOf(passwordField.getPassword()))) {
                    
                        LoadingView.ocultar();
                        MenuPrincipalView.mostrar();
                    
                    } else {
                    
                        LoadingView.ocultar();
                        f.setVisible(true);
                        JOptionPane.showMessageDialog(f, "Usuario o password incorrecto");
                    
                    }
                
                }

            }

        });
        
        f.add(bLogin);
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}