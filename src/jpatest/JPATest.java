/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest;

import entity.Achievement;
import entity.Player;
import entity.Videogame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import persistence.RepositoryBase;

/**
 *
 * @author lv1013
 */
public class JPATest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("JPATestPUPersonal");
        EntityManager entityManager = 
                managerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Videogame game = new Videogame();
        game.setName("League Of Legends");
        game.setRating(9);
                
        Achievement achievement1 = new Achievement();
        achievement1.setName("Level 30 reached");
        
        game.addAchievement(achievement1);
        
        Player player1=new Player();
        player1.setName("Alfonso Felix");
        
        //game.addPlayer(player1);
        
        achievement1.setVideogame(game);
        entityManager.persist(player1);
        
        player1.addVideogame(game);
        
        entityManager.persist(game);
        
        
        entityManager.getTransaction().commit();
        System.out.println(entityManager.find(Videogame.class, 1).getName());
        
        
        TypedQuery<Videogame>   query = 
                entityManager.createQuery(
                        "SELECT v FROM Videogame v WHERE v.rating >= :rating", Videogame.class);
        query.setParameter("rating", 4);
        List<Videogame> list = query.getResultList();
        for (Videogame videogame : list) {
            System.out.println(videogame.getName());
        }
        
        RepositoryBase<Videogame> repository;
        
    }

}
