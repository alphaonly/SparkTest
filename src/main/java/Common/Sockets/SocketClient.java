package Common.Sockets;

import Common.Sockets.Exceptions.ConnectionFailed;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;

public class SocketClient implements Runnable {

    public SocketMessage serverResponse = null;
    private ObjectOutputStream outputStream = null;
    private ObjectInputStream inputStream = null;

    Socket clientSocket = null;
    public void connectToServer() throws ConnectionFailed {

        try{
            clientSocket = new Socket(CommonData.getServerHost(),CommonData.getServerPort());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println(inputStream);
        }catch (Exception e){
            System.out.println("Client:" +e);
            throw new ConnectionFailed();
        }
    }

    public void disconnectFromServer() throws RuntimeException {

        try {
            outputStream.close();
            inputStream.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(String login, String password){
        SocketMessage clientRequest = null;
        clientRequest = new SocketMessage();
        clientRequest.setMessageType(messageType.checkUserExists);
        clientRequest.setUser(new User(login, password));


        try {
            outputStream.writeObject(clientRequest);
            outputStream.flush();

            serverResponse = (SocketMessage) inputStream.readObject();
            if(serverResponse.userIsExist())
                if(serverResponse.getUser().isExist())
                    return serverResponse.getUser();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        return new User();
    }


    @Override
    public void run() {

        try {
            connectToServer();
            User user = login("alpha", "123456");
            disconnectFromServer();
        } catch (ConnectionFailed e) {
            throw new RuntimeException(e);
        }



    }

    public static void main(String[] args) {
        new Thread(new SocketClient()).start();
    }
}
