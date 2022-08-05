package Common.Sockets;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameObject {

    private int id;
    private User host;
    private String name;

    List<User> players;

    protected Game(){}

    public Game(User host, String description){
        this.host = host;
        this.name = description;
        this.players= new ArrayList<>();
    }


    public Game(int id, User host, String name) {
        this.id = id;
        this.host = host;
        this.name = name;
    }
    public void addPlayer(User user) throws AddUserException {

                players.add(user);

        }

        private class AddUserException extends Exception {
        }
}
