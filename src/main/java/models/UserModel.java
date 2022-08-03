package models;

import Common.Sockets.GameObject;
import Common.Sockets.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel extends User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="name")
    private String name;

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public List<GameModel> getGameModels() {
        return gameModels;
    }

    @Column(name="surname")
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<GameModel> gameModels;

    public UserModel(){}
    public UserModel(String login, String name){
        this.name = name;
        this.login = login;
        this.gameModels = new ArrayList<>();

    }
    public void addGame(GameModel gameModel){
        gameModels.add(gameModel);

    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        String output = new String("Имя пользователя:" + this.name + "\n"
                +"login:" +this.login +"\n"
                +"Игры:" + this.gameModels +"\n"
                );

        return output;
    }
//    public User toUser(){
//
//        return new User()
//    }
}
