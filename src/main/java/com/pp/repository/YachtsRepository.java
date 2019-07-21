package com.pp.repository;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pp.model.Yacht;

public class YachtsRepository {
	private static YachtsRepository yachtsRepository = null;
    private final Logger logger = LoggerFactory.getLogger(YachtsRepository.class);

    // singleton
    public static YachtsRepository getInstance() {
        if (yachtsRepository == null)
        	yachtsRepository = new YachtsRepository();

        return yachtsRepository;
    }
    
    public List<Yacht> getAllYachts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Yacht> result = session.createQuery("from Yacht", Yacht.class).list();

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Yacht getYacht(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Yacht result = session.get(Yacht.class, id);

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void saveYacht(Yacht yacht) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(yacht);

        session.getTransaction().commit();
        session.close();
    }

    public void updateYacht(Yacht yacht) {
        if (yacht.getId() != 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(yacht);

            session.getTransaction().commit();
            session.close();
        } else
            logger.warn("updateYacht: Brak id");
    }

    public void deleteYacht(Yacht yacht) {
        if (yacht.getId() != 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            try {
                session.delete(yacht);
            } catch (Exception e) {
                System.out.println(e);
            }

            session.getTransaction().commit();
            session.close();
        } else
            logger.warn("deleteCruise: Brak id");
    }

    public void deleteYacht(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Yacht yacht = session.get(Yacht.class, id);
        if (yacht != null)
            session.delete(yacht);
        else
            logger.warn("Próba usunięcia nieistniejącego obiektu");

        session.getTransaction().commit();
        session.close();
    }

}
