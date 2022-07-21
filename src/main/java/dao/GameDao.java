package dao;
import Utils.HibernateSessionFactoryUtil;
import models.Game;
import models.GameObject;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GameDao implements Dao {

    @Override
    public Game findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Game.class, id);
    }

    @Override
    public void update(GameObject game) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(game);
        tx1.commit();
        session.close();
    }

    @Override
    public void save(GameObject game) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(game);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(GameObject game) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(game);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Game> findAll() {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();

    }
}
