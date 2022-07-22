package dao;

import Utils.HibernateSessionFactoryUtil;
import models.GameObject;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDao implements Dao{



    @Override
    public User findById(int id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);

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
       Session session =  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
               // .beginTransaction();
        Transaction tx =  session.beginTransaction();
       Query q =  session.createQuery("delete from User");
        q.executeUpdate();
       tx.commit();

        session.close();
//       .createQuery("delete from User")
//                .executeUpdate();

    }
    @Override
    public List<User> findAll() {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();

    }

}

