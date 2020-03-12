/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Invitado
 */
@Entity
@Table (name="player")
public class Player extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "player_videogame",
        joinColumns = @JoinColumn(name = "player_id"),
        inverseJoinColumns = @JoinColumn(name = "videogame_id")
    )
    private Collection<Videogame> videogames;

    public Player() {
        this.videogames=new HashSet();
    }
    
    public Collection<Videogame> getVideogames() {
        return videogames;
    }

    public void setVideogames(Collection<Videogame> videogames) {
        this.videogames = videogames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addVideogame(Videogame v){
        v.addPlayer(this);
        this.videogames.add(v);
    }
    
    @Override
    public String toString() {
        return "entity.Player[ id=" + id + " ]";
    }
    
}
