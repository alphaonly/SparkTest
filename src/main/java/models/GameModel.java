package models;

import Common.Sockets.Game;
import Common.Sockets.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class GameModel extends Game {



    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "host")
    private int host;
    @Column(name = "name_text")
    String name;


    protected GameModel(){}
    
    public GameModel(UserModel host, String description){
        this.host = host.getId();
        this.name = description;
    }

    public int getId() {
        return id;
    }

    public int getHost() {
        return host;
    }


    public String getName() {
        return name;
    }


    public Game toGame(){
        //gameList.stream().map()
        return new  Game(this.id,new User(this.host),this.name);
    }


    private class AddUserException extends Exception {
    }
}
