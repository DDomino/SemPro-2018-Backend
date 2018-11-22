/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andreas
 */
public class CarFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    public List<String> getAllCars() {
        List<String> res = em.createQuery("SELECT c FROM Cars c").getResultList();
        return res;
    }
    
    
}
