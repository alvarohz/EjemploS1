/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.dao;

import com.aerolinea.entidad.Avion;
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
public class AvionFacade extends AbstractFacade<Avion> {

    @PersistenceContext(unitName = "EjemploS1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvionFacade() {
        super(Avion.class);
    }
    
    public List<Avion> consultarAviones(String descripcion){
//        Query q2 = em.createNativeQuery("select * from avion where "
//                + "descripcion like :desc");
        Query q = em.createQuery("select a from Avion a where a.descripcion like"
                + " :desc");
        q.setParameter("desc", "%"+descripcion+"%");
        return q.getResultList();
    }
    
}
