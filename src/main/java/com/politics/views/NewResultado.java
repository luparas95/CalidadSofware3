package com.politics.views;

import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

import com.politics.controllers.CentroController;
import com.politics.controllers.PartidoController;
import com.politics.controllers.ResultadoController;
import com.politics.views.validations.Validations;

public class NewResultado {
    
    public static void mostrar() {
        
        LoadingView.mostrar();
        
        final Vector<String> centros = CentroController.getCentrosForDrowpdowns();
        final Vector<String> partidos = PartidoController.getPartidosForDrowpdowns();
        
        LoadingView.ocultar();

        final JFrame f = new JFrame("NUEVO RESULTADO");

        JLabel centroLbl = new JLabel("Centro");
        centroLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(centroLbl);
        
        final JComboBox centroList = new JComboBox(centros);
        centroList.setSelectedIndex(0);
        centroList.setBounds(50, 70, 280, 25);
        f.getContentPane().add(centroList);

        JLabel partidoLbl = new JLabel("Partido");
        partidoLbl.setBounds(50, 130, 280, 14);
        f.getContentPane().add(partidoLbl);
        
        final JComboBox partidoList = new JComboBox(partidos);
        partidoList.setSelectedIndex(0);
        partidoList.setBounds(50, 150, 280, 25);
        f.getContentPane().add(partidoList);
        
        JLabel votosLbl = new JLabel("Votos");
        votosLbl.setBounds(50, 210, 280, 14);
        f.getContentPane().add(votosLbl);

        final JTextField votosField = new JTextField();
        votosField.setBounds(50, 230, 280, 25);
        f.getContentPane().add(votosField);
        votosField.setColumns(10);
        
        JButton bCrearResultado = new JButton("Crear Resultado");
        JButton bVolver = new JButton("Volver");
        
        bCrearResultado.setBounds(50, 310, 130, 30);
        bVolver.setBounds(200, 310, 130, 30);
        
        bCrearResultado.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                String centroSelected = centroList.getSelectedItem().toString();
                int idCentroSelected = Integer.parseInt(centroSelected.substring(0, centroSelected.indexOf(" - ")));

                String partidoSelected = partidoList.getSelectedItem().toString();
                int idPartidoSelected = Integer.parseInt(partidoSelected.substring(0, partidoSelected.indexOf(" - ")));
                
                if (!Validations.numeroValido(votosField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca una cifra de votos");
                
                } else {
                    
                    f.setVisible(false);
                    LoadingView.mostrar();
                    
                    try {

                        ResultadoController.creaResultado(idCentroSelected, idPartidoSelected, Integer.parseInt(votosField.getText()));
                        MenuPrincipalView.mostrar();
                        
                    } catch (Exception except) {
                    
                        JOptionPane.showMessageDialog(f, except.getMessage());
                        f.setVisible(true);
                    
                    } finally {
                    
                        LoadingView.ocultar();
                    
                    }
                
                }

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPrincipalView.mostrar();

            }

        });
        
        f.add(bCrearResultado);
        f.add(bVolver);
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}