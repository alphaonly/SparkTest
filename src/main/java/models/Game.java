package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game extends GameObject{
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User host;
    @Column(name = "name_text")
    String name;

    List<User> players;


    public Game(User host,String name){
        this.host = host;
        this.name = name;
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
