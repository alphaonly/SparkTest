package Common.Sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Runnable {

    public void go(){
        Socket clientSocket = null;

        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        SocketMessage clientRequest = null;
        SocketMessage serverResponse = null;

        try{
            clientSocket = new Socket("localhost",CommonData.getServerPort());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());


            clientRequest = new SocketMessage();
            clientRequest.setMessageType(messageType.checkUserExists);
            clientRequest.setUser(new User("alpha", "123456"));


            outputStream.writeObject(clientRequest);
            outputStream.flush();



            serverResponse = (SocketMessage) inputStream.readObject();
            if(serverResponse.userIsExist())
                if(serverResponse.getUser().isExist())
                     System.out.println(serverResponse.getUser());

            outputStream.close();
            inputStream.close();
            clientSocket.close();




        }catch (Exception e){System.out.println("Client:" +e);}



    }


    @Override
    public void run() {

        this.go();

    }
}
