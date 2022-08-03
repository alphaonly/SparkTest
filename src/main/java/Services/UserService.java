package Services;

import Common.Sockets.Exceptions.DatabaseInconsistencyException;
import dao.UserDao;
import models.UserModel;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public UserModel findUser(int id){
        return userDao.findById(id);
    }
    public UserModel findUser(String login) throws DatabaseInconsistencyException {
        List<UserModel> userModelList = userDao.findByLogin(login);
        if (userModelList.size() == 1){
            return userModelList.get(0);
        }else {
            throw new DatabaseInconsistencyException();
        }

    }

    public void saveUser(UserModel userModel){
        userDao.save(userModel);
    }
    public void deleteUser(UserModel userModel){
        userDao.delete(userModel);
    }
    public void updateUser(UserModel userModel){
        userDao.update(userModel);
    }
    public List<UserModel> findAll(){
        return userDao.findAll();
    }
    public void deleteAll() { userDao.deleteAll();}


    public static void main(String[] args) {


        UserService userService = new UserService();

        try {
            UserModel userModel =  userService.findUser("alpha");
        }catch (Exception e){}

//        userService.saveUser(new UserModel("alpha","O'Brien"));
//        userService.saveUser(new UserModel("nachos","Pringle"));
//        userService.deleteAll();
//          List<UserModel> list =  userService.findAll();

//          System.out.println(list);
    }

}
