package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends GameObject {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> gameList;

    public  User(){}
    public  User(String login, String name){
        this.name = name;
        this.login = login;
        this.gameList = new ArrayList<>();

    }
    public void addGame(Game game){
        gameList.add(game);

    }

}
