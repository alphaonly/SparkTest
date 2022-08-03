package dao;

import Utils.HibernateSessionFactoryUtil;
import Common.Sockets.GameObject;
import models.UserModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDao implements Dao{



    @Override
    public UserModel findById(int id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserModel.class, id);

    }
    public List<UserModel> findByLogin(String login) {

      //  return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserModel.class, login);
//        String hql = " from UserModel U where U.login=:login_id";
        String hql = " from UserModel U where U.login = :login_id";
        Query query =  HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(hql);
        query.setParameter("login_id", login);

        return query.getResultList();
    }
    @Override
    public void save(GameObject user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(GameObject user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(GameObject user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public void deleteAll() {
       Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx =  session.beginTransaction();
       Query q =  session.createQuery("delete from UserModel");
        q.executeUpdate();
       tx.commit();

        session.close();


    }
    @Override
    public List<UserModel> findAll() {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from UserModel").list();

    }

}

