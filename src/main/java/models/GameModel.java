package models;

import Common.Sockets.Game;

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
   // @JoinColumn(name = "game_id")
    @ManyToMany(mappedBy = "gameModels", fetch = FetchType.LAZY)
    List<UserModel> players;

    protected GameModel(){}
    
    public GameModel(UserModel host, String description){
        this.host = host.getId();
        this.name = description;
        this.players= new ArrayList<>();
    }


    public void addPlayer(UserModel userModel) throws  AddUserException{
        try {
            players.add(userModel);
        }catch (Exception e){ throw new AddUserException(); }
    }

    private class AddUserException extends Exception {
    }
}
