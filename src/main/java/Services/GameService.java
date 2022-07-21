package Services;

import dao.GameDao;
import models.Game;


import java.util.List;

public class GameService {

    private GameDao gameDao = new GameDao();

    public Game findGame(int id){
        return gameDao.findById(id);
    }

    public void saveGame(Game game){
        gameDao.save(game);
    }
    public void deleteGame(Game game){
        gameDao.delete(game);
    }
    public void updateGame(Game game){
        gameDao.update(game);
    }
    public List<Game> findAll(){
        return gameDao.findAll();
    }

}
