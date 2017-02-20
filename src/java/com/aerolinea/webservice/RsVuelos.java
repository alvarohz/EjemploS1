package com.aerolinea.webservice;

import com.aerolinea.dao.VueloFacade;
import com.aerolinea.entidad.Vuelo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("reportes")
public class RsVuelos {
    
    VueloFacade vueloFacade = lookupVueloFacadeBean();
    
    @GET
    @Path("vuelos/{fecha1}/{fecha2}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vuelo> consultarVuelos(
            @PathParam("fecha1")String fecha1,
            @PathParam("fecha2")String fecha2){
    
    return vueloFacade.consultarVuelos(fecha1, fecha2);
    }

    private VueloFacade lookupVueloFacadeBean() {
        try {
            Context c = new InitialContext();
            return (VueloFacade) c.lookup("java:global/EjemploS1/VueloFacade!com.aerolinea.dao.VueloFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
