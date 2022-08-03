package Common.Sockets;

import models.UserModel;

import java.util.List;

public class User extends GameObject  {

    public int id;
    public String login;
    private String password;
    private String name;
    private String surname;
    private List<Game> games;

    public User(){}
    public User(int id, String login, String name, String surname, List<Game> games) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.games = games;
    }
    public User(int id, String login, String name, String surname) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
    }
    public User(String login, String password) {

        this.login = login;
        this.password = password;
    }
//    public User(UserModel userModel){
//        this.id = userModel.getId();
//        this.login = userModel.getLogin();
//        this.name = userModel.getName();
//        this.surname = userModel.getSurname();
//        this.
//    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean isExist(){

        int id;
        String login;

        if(UserModel.class.isInstance(this)){
            UserModel userModel = (UserModel)this;
            id = userModel.getId();
            login = userModel.getLogin();
        } else{
           // id = ((UserModel) this).getId();
            id = this.id;
            login = this.login;
        }


        if ( id >= 0 && login != null)
            return true;
        else
            return  false;
    }
}
