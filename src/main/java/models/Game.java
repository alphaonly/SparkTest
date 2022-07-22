package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game extends GameObject {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "host")
    private int host;
    @Column(name = "name_text")
    String name;
   // @JoinColumn(name = "game_id")
    @ManyToMany(mappedBy = "games", fetch = FetchType.LAZY)
    List<User> players;


    public Game(User host,String description){
        this.host = host.getId();
        this.name = description;
        this.players= new ArrayList<>();
    }
    public void addPlayer(User user) throws  AddUserException{
        try {
            players.add(user);
        }catch (Exception e){ throw new AddUserException(); }
    }

    private class AddUserException extends Exception {
    }
}
