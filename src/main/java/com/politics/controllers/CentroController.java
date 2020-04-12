package com.politics.controllers;

import java.util.List;
import java.util.Vector;

import com.politics.models.dao.CentroDao;
import com.politics.models.vo.CentroVo;

/**
 * Esta clase contiene el menu de la clase Centro y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class CentroController {
    
    /**
    * Método que imprime por pantalla los atributos de todos los objetos Centro guardados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static Vector<Vector> getCentros() {
        
        List centros = CentroDao.getCentros();
        Vector<Vector> vCentros = new Vector<Vector>();

        for (Object centro:centros) {
            
            Vector<String> data = new Vector<String>();
            data.add("" + ((CentroVo) centro).getId());
            data.add(((CentroVo) centro).getNombre());
            data.add("" + ((CentroVo) centro).getElectores());
            vCentros.add(data);

        }
        
        return vCentros;
    
    }
    
    /**
    * Método que devuelve una lista de centros sólo su id y su nombre
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static Vector<String> getCentrosForDrowpdowns() {
        
        List centros = CentroDao.getCentros();
        Vector<String> vCentros = new Vector<String>();

        for (Object centro:centros) {
            
            String data = "" + ((CentroVo) centro).getId() + " - " + ((CentroVo) centro).getNombre();
            vCentros.add(data);

        }
        
        return vCentros;
    
    }
    
    /**
    * Método que imprime por pantalla los atributos de el objeto Centro guardado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idCentro El id del centro a extraer
    */
    public static CentroVo getCentroById(int idCentro) {
        
        return CentroDao.getCentroById(idCentro);
    
    }
    
    /**
    * Método que crea un nuevo objeto Centro y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre El nombre del centro a crear
    * @param electores El número de electores del centro a crear
    */
    public static void creaCentro(String nombre, int electores) {
    
        CentroVo centro = new CentroVo(0, nombre, electores);
        CentroDao.createCentro(centro);
    
    }

    /**
    * Método que actualiza un objeto Centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centro El objeto centro a actualizar
    */
    public static void updateCentro(CentroVo centro) {
    
        CentroDao.updateCentro(centro);
    
    }

}