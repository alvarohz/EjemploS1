/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.bean;

import com.aerolinea.entidad.Aeropuerto;
import com.aerolinea.entidad.Avion;
import com.aerolinea.entidad.Pais;
import com.aerolinea.sesion.controlAvion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
    private String busqueda;
    
    @PostConstruct
    public void init(){
        avion=new Avion();
    }
    
    public AvionBean() {
        busqueda="";
    }

    public List<Avion> getAviones() {
        aviones = controlAvion.consultarAviones(busqueda);
        return aviones;
    }
    
    public void consultar(){
        this.getAviones();
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    } 

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }
    
    public String preparaNuevo(){
        avion=new Avion();
        return "AvionForm.xhtml?faces-redirect=true";
    }
            
    public String guardar(){
        if (avion.getIdavion()==null)
            controlAvion.guardarAvion(avion);
        else
            controlAvion.modificarAvion(avion);
        return "AvionLista.xhtml?faces-redirect=true";
    }
    
    public String seleccionaEdit(Avion a){
        avion=a;
        return "AvionForm.xhtml?faces-redirect=true";
    }
    
    public void eliminar(Avion a){
        avion=a;
        controlAvion.eliminarAvion(avion);
        FacesContext.getCurrentInstance().
 addMessage(null, new FacesMessage(
         FacesMessage.SEVERITY_INFO, "Informacion", "Datos borrados")
            );
        this.getAviones();
    }
   
}
