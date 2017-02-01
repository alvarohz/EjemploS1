/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.bean;

import com.aerolinea.entidad.Avion;
import com.aerolinea.sesion.controlAvion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Alvaro
 */
@Named(value = "AvionBean")
@SessionScoped
public class AvionBean implements Serializable {

    @EJB
    private controlAvion controlAvion;
    private List<Avion> aviones;
    private Avion avion;
    
    public AvionBean() {
    }

    public List<Avion> getAviones() {
        aviones = controlAvion.getAllAviones();
        return aviones;
    }
    
}
