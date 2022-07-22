package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Game> games;

    public  User(){}
    public  User(String login, String name){
        this.name = name;
        this.login = login;
        this.games = new ArrayList<>();

    }
    public void addGame(Game game){
        games.add(game);

    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        String output = new String("Имя пользователя:" + this.name + "\n"
                +"login:" +this.login +"\n"
                +"Игры:" + this.games +"\n"
                );

        return output;
    }
}
