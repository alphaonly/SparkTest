package Common.Sockets;

import Services.UserService;
import models.GameModel;
import models.UserModel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements  Runnable {

    public void  go(){
        try {
            ObjectOutputStream outputStream = null;
            ObjectInputStream  inputStream = null;
            Socket clientSocket = null;
            SocketMessage clientRequest = null;
            SocketMessage serverResponse = null;

            UserService userService = new UserService();

            int count = 0;
            ServerSocket serverSocket = new ServerSocket(CommonData.getServerPort());
//            while (true == true) {
            while (count<=3) {
                count++;
                clientSocket = serverSocket.accept();

                outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                inputStream  = new ObjectInputStream(clientSocket.getInputStream());

                clientRequest = (SocketMessage) inputStream.readObject();

                serverResponse = new SocketMessage();

                switch (clientRequest.getMessageType()){
                    case getGame -> {


                        serverResponse.setGame(new Game(
                                new User(123, "akpha", "Michael", "Obrien"),
                                "text"));


                    }
                    case sendGame ->{}
                    case getUser -> {}
                    case sendUser ->{}
                    case checkUserExists -> {
                        if(clientRequest.userIsExist()) {
                            User user = (User)userService.findUser(clientRequest.getUser().getLogin());
                            Common.Sockets.User u;
                            u = user;
                            if (u.isExist()) {
                                serverResponse.setUser(user);


                            }
                        }




                    }
                }
                outputStream.writeObject(serverResponse);


                outputStream.close();
                inputStream.close();
                clientSocket.close();
                serverSocket.close();


            }


        }catch (Exception e){
            System.out.println("Server:" + e);

             }
    }


    @Override
    public void run() {
        this.go();
    }
}
