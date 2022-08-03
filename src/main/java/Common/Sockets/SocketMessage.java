package Common.Sockets;

import java.io.Serializable;

enum messageType{
    getUser,
    getGame,
    sendUser,
    sendGame,
    checkUserExists
}


public class SocketMessage implements Serializable {

    private User user;
   private Game game;
   private messageType messageType;
   private String error;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setMessageType(Common.Sockets.messageType messageType) {
        this.messageType = messageType;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public User getUser() {
        return user;
    }

    public Common.Sockets.messageType getMessageType() {
        return messageType;
    }

    public String getError() {
        return error;
    }

    public boolean userIsExist(){
       return  user !=null;
    }

    public boolean gameIsExist(){
        return  game !=null;
    }
}
