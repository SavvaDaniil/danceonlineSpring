package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementToDiscount;
import com.dancestudioSpring.Entity.Discount;
import com.dancestudioSpring.Repository.ConnectionAbonementToDiscountRepository;

@Service
public class ConnectionAbonementToDiscountService {

	@Autowired
	ConnectionAbonementToDiscountRepository connectionAbonementToDiscountRepository;
	
    public ConnectionAbonementToDiscount findById(int id)
    {
    	return connectionAbonementToDiscountRepository.findById(id);
    }
    
    public ConnectionAbonementToDiscount findByAbonementAndDiscount(Abonement abonement, Discount discount)
    {
        Transaction transaction = null;
        ConnectionAbonementToDiscount connectionAbonementToDiscount = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionAbonementToDiscount.class.getSimpleName() 
            		+ " WHERE abonementid = :id_of_abonement AND discountid = :id_of_discount order by id DESC");
			query.setParameter("id_of_abonement", abonement.getId());
			query.setParameter("id_of_discount", discount.getId());
			connectionAbonementToDiscount = (ConnectionAbonementToDiscount)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionAbonementToDiscount;
    }

    public ConnectionAbonementToDiscount add(ConnectionAbonementToDiscount connectionAbonementToDiscount)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(connectionAbonementToDiscount);
            transaction.commit();
            session.close();
            return connectionAbonementToDiscount;
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
    public boolean update(ConnectionAbonementToDiscount connectionAbonementToDiscount) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(connectionAbonementToDiscount);
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
    public List <ConnectionAbonementToDiscount> listAll() {
    	
        Transaction transaction = null;
        List < ConnectionAbonementToDiscount > connectionsAbonementToDiscount = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            connectionsAbonementToDiscount = session.createQuery("FROM " + ConnectionAbonementToDiscount.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsAbonementToDiscount;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionAbonementToDiscount> listAllByDiscount(Discount discount) {
    	
        Transaction transaction = null;
        List < ConnectionAbonementToDiscount > connectionsAbonementToDiscount = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionAbonementToDiscount.class.getSimpleName() 
            		+ " WHERE discountid = :id_of_discount order by id DESC");
			query.setParameter("id_of_discount", discount.getId());
			connectionsAbonementToDiscount = query.getResultList();
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsAbonementToDiscount;
    }
    
    public boolean delete(int id) {
    	ConnectionAbonementToDiscount connectionAbonementToDiscount = findById(id);
    	if(connectionAbonementToDiscount == null)return false;
    	return delete(connectionAbonementToDiscount);
    }
    
    public boolean delete(Abonement abonement, Discount discount) {
    	ConnectionAbonementToDiscount connectionAbonementToDiscount = findByAbonementAndDiscount(abonement, discount);
    	if(connectionAbonementToDiscount == null)return false;
    	return delete(connectionAbonementToDiscount);
    }
    
    
    public boolean delete(ConnectionAbonementToDiscount connectionAbonementToDiscount) {
    	if(connectionAbonementToDiscount == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(connectionAbonementToDiscount);
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
