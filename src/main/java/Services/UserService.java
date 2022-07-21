package Services;

import dao.UserDao;
import models.GameObject;
import models.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public User findUser(int id){
        return userDao.findById(id);
    }

    public void saveUser(User user){
        userDao.save(user);
    }
    public void deleteUser(User user){
        userDao.delete(user);
    }
    public void updateUser(User user){
        userDao.update(user);
    }
    public List<User> findAll(){
        return userDao.findAll();
    }

}
