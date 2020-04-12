package com.politics.views;

import java.awt.event.*;
import javax.swing.*;

import com.politics.constants.Constant;
import com.politics.models.vo.SessionVo;

public class MenuPrincipalView {
    
    public static void mostrar() {
        
        final JFrame f = new JFrame("MENU PRINCIPAL");
        JButton bCentros = new JButton("Centros");
        JButton bPartidos = new JButton("Partidos");
        JButton bResultados = new JButton("Introducir Resultados");
        JButton bTotalizacion = new JButton("Totalizar");
        JButton bSalir = new JButton("Salir");
        
        if (SessionVo.getInstance().getUser().getRole() != Constant.ROLE_ADMINISTRADOR && SessionVo.getInstance().getUser().getRole() != Constant.ROLE_PRESIDENTE_MESA_ELECTORAL) {
        
            bResultados.setEnabled(false);
        
        }
        
        bCentros.setBounds(50, 50, 275, 30);
        bPartidos.setBounds(50, 100, 275, 30);
        bResultados.setBounds(50, 150, 275, 30);
        bTotalizacion.setBounds(50, 200, 275, 30);
        bSalir.setBounds(50, 250, 275, 30);
        
        bCentros.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuCentroView.mostrar();

            }

        });
        
        bPartidos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPartidoView.mostrar();

            }

        });
        
        bResultados.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                NewResultado.mostrar();

            }

        });
        
        bTotalizacion.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                ResultadoListView.mostrar();

            }

        });
        
        bSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });
        
        f.add(bCentros);
        f.add(bPartidos);
        f.add(bResultados);
        f.add(bTotalizacion);
        f.add(bSalir);

        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}