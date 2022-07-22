import Services.GameService;
import Services.UserService;
import models.Game;
import models.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class SparktestClass {

    public static void main(String[] args) {
//        //get("/hello",(req,res)->"Hello World");
//        final Map<String, String> map;
//        get("/hello/:name/:age", (request, response) -> {
//            final Map<String,String>  map1 = request.params();
//            Iterator<String> it = map1.values().iterator();
//            while(it.hasNext()){
//                System.out.println(it.next());
//            }
//
//            return "Hello: " + request.params(); });
//        get("/helloname/:p1", (request, response) -> "Hello: " + request.params());



        User user1 = new User("alpha_only","Pavel");
        User user2 = new User("equinox293","Vasiliy");
        Game game = new Game(user1, "Poker party1");

        user1.addGame(game);
        user2.addGame(game);

        UserService userService = new UserService();
        GameService gameService = new GameService();

//        userService.saveUser(user1);
//        userService.saveUser(user2);
//        gameService.saveGame(game);

            List<User> userlist;
            userlist = userService.findAll();

            System.out.println(userlist);
            userService.deleteAll();
            userlist = userService.findAll();
            System.out.println(userlist);




    }
}
