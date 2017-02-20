/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.bean;

import com.aerolinea.cliente.WsAvion_Service;
import com.aerolinea.entidad.Aeropuerto;
import com.aerolinea.entidad.Avion;
import com.aerolinea.entidad.Pais;
import com.aerolinea.sesion.controlAvion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Alvaro
 */
@Named(value = "AvionBean")
@SessionScoped
public class AvionBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_46866/EjemploS1/wsAvion.wsdl")
    private WsAvion_Service service;

    @EJB
    private controlAvion controlAvion;
    
    private List<Avion> aviones;
    private Avion avion;
    private String busqueda;
    
    @PostConstruct
    public void init(){
        avion=new Avion();
        aviones = new ArrayList<>();
    }
    
    public AvionBean() {
        busqueda="";
    }

    public List<Avion> getAviones() {
        List<com.aerolinea.cliente.Avion> lista = 
                consultarAviones(busqueda);
        aviones.clear();
        for(com.aerolinea.cliente.Avion a: lista){
            aviones.add(new Avion(a.getIdavion(), 
                    a.getCapacidad(), 
                    a.getDescripcion()));
        }
        //aviones = controlAvion.consultarAviones(busqueda);
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
        if (avion.getIdavion()==null){
            com.aerolinea.cliente.Avion a = 
                    new com.aerolinea.cliente.Avion();
            //a.setIdavion(Integer.SIZE);
            a.setCapacidad(avion.getCapacidad());
            a.setDescripcion(avion.getDescripcion());
            create(a);
            //controlAvion.guardarAvion(avion);
        }
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

    private void create(com.aerolinea.cliente.Avion entity) {
        com.aerolinea.cliente.WsAvion port = service.getWsAvionPort();
        port.create(entity);
    }

    private java.util.List<com.aerolinea.cliente.Avion> consultarAviones(java.lang.String descripcion) {
        com.aerolinea.cliente.WsAvion port = service.getWsAvionPort();
        return port.consultarAviones(descripcion);
    }
   
}
