package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.ConnectionDiscountToUser;
import com.dancestudioSpring.Entity.Discount;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Repository.ConnectionDiscountToUserRepository;

@Service
public class ConnectionDiscountToUserService {

	@Autowired
	ConnectionDiscountToUserRepository connectionDiscountToUserRepository;


	public ConnectionDiscountToUser findById(int id) {
		return connectionDiscountToUserRepository.findById(id);
	}


    public ConnectionDiscountToUser findByDiscountAndUser(Discount discount, User user)
    {
        Transaction transaction = null;
        ConnectionDiscountToUser connectionDiscountToUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionDiscountToUser.class.getSimpleName() 
            		+ " WHERE discountid = :id_of_discount AND userid = :id_of_user order by id DESC");
			query.setParameter("id_of_discount", discount.getId());
			query.setParameter("id_of_user", user.getId());
			connectionDiscountToUser = (ConnectionDiscountToUser)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionDiscountToUser;
    }

    public boolean isAnyByUserAndDiscount(User user, Discount discount)
    {
        return this.findByDiscountAndUser(discount, user) != null;
    }

    
	
    public ConnectionDiscountToUser add(ConnectionDiscountToUser connectionDiscountToUser)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(connectionDiscountToUser);
            transaction.commit();
            session.close();
            return connectionDiscountToUser;
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
    public boolean update(ConnectionDiscountToUser connectionDiscountToUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(connectionDiscountToUser);
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
    public List <ConnectionDiscountToUser> listAll() {
    	
        Transaction transaction = null;
        List < ConnectionDiscountToUser > connectionsDiscountToUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            connectionsDiscountToUser = session.createQuery("FROM " + ConnectionDiscountToUser.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsDiscountToUser;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionDiscountToUser> listAllByUser(User user) {
    	
        Transaction transaction = null;
        List < ConnectionDiscountToUser > connectionsDiscountToUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionDiscountToUser.class.getSimpleName() 
            		+ " WHERE userid = :id_of_user order by id DESC");
			query.setParameter("id_of_user", user.getId());
			connectionsDiscountToUser = query.getResultList();
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsDiscountToUser;
    }

    
    
    public boolean delete(int id) {
    	ConnectionDiscountToUser connectionDiscountToUser = findById(id);
    	if(connectionDiscountToUser == null)return false;
    	return delete(connectionDiscountToUser);
    }
    
    public boolean delete(Discount discount, User user) {
    	ConnectionDiscountToUser connectionDiscountToUser = this.findByDiscountAndUser(discount, user);
    	if(connectionDiscountToUser == null)return false;
    	return delete(connectionDiscountToUser);
    }
    
    
    public boolean delete(ConnectionDiscountToUser connectionDiscountToUser) {
    	if(connectionDiscountToUser == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(connectionDiscountToUser);
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
}
