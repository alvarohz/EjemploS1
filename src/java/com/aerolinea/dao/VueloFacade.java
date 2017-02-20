/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.dao;

import com.aerolinea.entidad.Vuelo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alvaro
 */
@Stateless
public class VueloFacade extends AbstractFacade<Vuelo> {

    @PersistenceContext(unitName = "EjemploS1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VueloFacade() {
        super(Vuelo.class);
    }
    
    public List<Vuelo> consultarVuelos(String fecha1, 
            String fecha2)
    {
        try{
        Date f1 = 
                new SimpleDateFormat("dd-MM-yyyy").parse(fecha1);
        Date f2 = 
                new SimpleDateFormat("dd-MM-yyyy").parse(fecha2);
        Query q = em.createQuery("select v from Vuelo v"
                + " where v.fecha between :desde and :hasta");
        q.setParameter("desde", f1);
        q.setParameter("hasta", f2);
        return q.getResultList();
        }catch(Exception e){return null;}
    }
    
}
