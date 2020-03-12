/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.EntityBase;
import javax.persistence.EntityManager;

/**
 *
 * @author lv1013
 * @param <T>
 */
public abstract class RepositoryBase<T extends EntityBase> 
        implements Repository<T>{
    
    private final EntityManager entityManager;
    private final Class<T> cls;
    
    protected RepositoryBase(EntityManager entityManager, Class<T> cls){
        this.entityManager=entityManager;
        this.cls=cls;
    }

    @Override
    public T find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T save(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
