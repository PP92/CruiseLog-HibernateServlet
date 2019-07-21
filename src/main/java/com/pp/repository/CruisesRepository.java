package com.pp.repository;

import com.pp.model.Cruise;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CruisesRepository {
    private static CruisesRepository cruisesRepository = null;
    private final Logger logger = LoggerFactory.getLogger(CruisesRepository.class);

    // singleton
    public static CruisesRepository getInstance() {
        if (cruisesRepository == null)
            cruisesRepository = new CruisesRepository();

        return cruisesRepository;
    }

    public List<Cruise> getAllCruises() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Cruise> result = session.createQuery("from Cruise", Cruise.class).list();

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Cruise getCruise(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Cruise result = session.get(Cruise.class, id);

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void saveCruise(Cruise cruise) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(cruise);

        session.getTransaction().commit();
        session.close();
    }

    public void updateCruise(Cruise cruise) {
        if (cruise.getId() != 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(cruise);

            session.getTransaction().commit();
            session.close();
        } else
            logger.warn("updateCruise: Brak id");
    }

    public void deleteCruise(Cruise cruise) {
        if (cruise.getId() != 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            try {
                session.delete(cruise);
            } catch (Exception e) {
                System.out.println(e);
            }

            session.getTransaction().commit();
            session.close();
        } else
            logger.warn("deleteCruise: Brak id");
    }

    public void deleteCruise(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cruise cruise = session.get(Cruise.class, id);
        if (cruise != null)
            session.delete(cruise);
        else
            logger.warn("Próba usunięcia nieistniejącego obiektu");

        session.getTransaction().commit();
        session.close();
    }
//  Wersja alternatywna
//    public void deleteCruiseById(int id){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        String sql = "delete Cruise where id = :id";
//        Query query = session.createQuery(sql).setParameter("id",id);
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//    }


}
