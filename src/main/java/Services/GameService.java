package Services;

import dao.GameDao;
import models.GameModel;


import java.util.List;

public class GameService {

    private GameDao gameDao = new GameDao();

    public GameModel findGame(int id){
        return gameDao.findById(id);
    }

    public void saveGame(GameModel gameModel){
        gameDao.save(gameModel);
    }
    public void deleteGame(GameModel gameModel){
        gameDao.delete(gameModel);
    }
    public void updateGame(GameModel gameModel){
        gameDao.update(gameModel);
    }
    public List<GameModel> findAll(){
        return gameDao.findAll();
    }

}
