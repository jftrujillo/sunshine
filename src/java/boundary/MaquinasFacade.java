/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Maquinas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhon
 */
@Stateless
public class MaquinasFacade extends AbstractFacade<Maquinas> {

    @PersistenceContext(unitName = "SunshinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaquinasFacade() {
        super(Maquinas.class);
    }
    
}
