package dao;
import Utils.HibernateSessionFactoryUtil;
import models.GameModel;
import Common.Sockets.GameObject;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GameDao implements Dao {

    @Override
    public GameModel findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(GameModel.class, id);
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
    public List<GameModel> findAll() {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();

    }
    public void deleteAll() {
        HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("delete from games").list();
    }
}
