/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.bean;

import com.aerolinea.dao.PaisFacade;
import com.aerolinea.entidad.Aeropuerto;
import com.aerolinea.entidad.Pais;
import com.aerolinea.sesion.controlAeropuerto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Alvaro
 */
@Named(value = "AeropuertoBean")
@SessionScoped
public class AeropuertoBean implements Serializable {

    @EJB
    private controlAeropuerto controlAeropuerto;
    @EJB
    private PaisFacade paisFacade;
    
    private List<Aeropuerto> aeropuertos;
    private List<Pais> paises;
    private Aeropuerto aeropuerto;
    private Pais pais;
    
    @PostConstruct
    public void init(){
        pais=new Pais();
        aeropuerto=new Aeropuerto();
    }
    public AeropuertoBean() {
    }
    public List<Aeropuerto> getAeropuertos() {
        aeropuertos=controlAeropuerto.getAllAeropuertos();
        return aeropuertos;
    }
    public void setAeropuertos(List<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }
    public List<Pais> getPaises() {
        paises=paisFacade.findAll();
        return paises;
    }
    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public String preparaNuevo(){
        aeropuerto=new Aeropuerto();
        pais = new Pais();
        return "AeropuertoForm.xhtml?faces-redirect=true";
    }        
    public String guardar(){
        if (aeropuerto.getIdaeropuerto()==null){
            //aeropuerto.setIdpais(pais);
            controlAeropuerto.guardarAeropuerto(aeropuerto);
        }else{
            //pais = new Pais(aeropuerto.getIdpais().getIdpais());
            //aeropuerto.setIdpais(pais);
            controlAeropuerto.modificarAeropuerto(aeropuerto);
        }
        return "AeropuertoLista.xhtml?faces-redirect=true";
    }
    public String seleccionaEdit(Aeropuerto a){
        aeropuerto=a;
        pais=a.getIdpais();
        return "AeropuertoForm.xhtml?faces-redirect=true";
    } 
    public void eliminar(Aeropuerto a){
        aeropuerto=a;
        controlAeropuerto.eliminarAeropuerto(aeropuerto);
        FacesContext.getCurrentInstance().
 addMessage(null, new FacesMessage(
         FacesMessage.SEVERITY_INFO, "Informacion", "Datos borrados")
            );
        this.getAeropuertos();
    }
    
    @FacesConverter(forClass = Pais.class)
    public static class PaisConverter implements Converter{

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, 
                String value) {
            return new Pais(Integer.parseInt(value));
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, 
                Object value) {
                return ((Pais)value).getIdpais().toString();
        }
    
    }
    
}
