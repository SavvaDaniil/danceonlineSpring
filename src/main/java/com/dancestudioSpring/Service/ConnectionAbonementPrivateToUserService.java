package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementPrivateToUser;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Repository.ConnectionAbonementPrivateToUserRepository;

@Service
public class ConnectionAbonementPrivateToUserService {

	@Autowired
	ConnectionAbonementPrivateToUserRepository connectionAbonementPrivateToUserRepository;

    public ConnectionAbonementPrivateToUser findById(int id)
    {
    	return connectionAbonementPrivateToUserRepository.findById(id);
    }
	
    public ConnectionAbonementPrivateToUser findByAbonementPrivateAndUser(Abonement abonement, User user) {

        Transaction transaction = null;
        ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionAbonementPrivateToUser.class.getSimpleName() 
            		+ " WHERE abonementid = :id_of_abonement AND userid = :id_of_user order by id DESC");
			query.setParameter("id_of_abonement", abonement.getId());
			query.setParameter("id_of_user", user.getId());
			connectionAbonementPrivateToUser = (ConnectionAbonementPrivateToUser)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionAbonementPrivateToUser;
    }
    

    public ConnectionAbonementPrivateToUser add(ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(connectionAbonementPrivateToUser);
            transaction.commit();
            session.close();
            return connectionAbonementPrivateToUser;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update Abonement
     * @param Abonement
     */
    public boolean update(ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(connectionAbonementPrivateToUser);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
    	ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser = findById(id);
    	if(connectionAbonementPrivateToUser == null)return false;
    	return delete(connectionAbonementPrivateToUser);
    }
    
    public boolean delete(ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser) {
    	if(connectionAbonementPrivateToUser == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(connectionAbonementPrivateToUser);
            /*
            Abonement Abonement = session.get(Abonement.class, id);
            if (Abonement != null) {
                session.delete(Abonement);
                System.out.println("Abonement is deleted");
            }
            */

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    

    @SuppressWarnings("unchecked")
    public List <ConnectionAbonementPrivateToUser> listAll() {
    	
        Transaction transaction = null;
        List < ConnectionAbonementPrivateToUser > connectionsAbonementPrivateToUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            connectionsAbonementPrivateToUser = session.createQuery("FROM " + ConnectionAbonementPrivateToUser.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsAbonementPrivateToUser;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionAbonementPrivateToUser> listAllByUser(User user) {
    	
        Transaction transaction = null;
        List < ConnectionAbonementPrivateToUser > connectionsAbonementPrivateToUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionAbonementPrivateToUser.class.getSimpleName() 
            		+ " WHERE userid = :id_of_user order by id DESC");
			query.setParameter("id_of_user", user.getId());
			connectionsAbonementPrivateToUser = query.getResultList();
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsAbonementPrivateToUser;
    }
    
    
    
    
}
