package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.AbonementDynamicDateMustBeUsedTo;
import com.dancestudioSpring.Repository.AbonementDynamicDateMustBeUsedToRepository;

@Service
public class AbonementDynamicDateMustBeUsedToService {

	@Autowired
	AbonementDynamicDateMustBeUsedToRepository abonementDynamicDateMustBeUsedToRepository;
	
    public AbonementDynamicDateMustBeUsedTo findById(int id)
    {
    	return abonementDynamicDateMustBeUsedToRepository.findById(id);
    }
    
    

    public AbonementDynamicDateMustBeUsedTo add(AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(abonementDynamicDateMustBeUsedTo);
            transaction.commit();
            session.close();
            return abonementDynamicDateMustBeUsedTo;
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
    public boolean update(AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(abonementDynamicDateMustBeUsedTo);
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
    	AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo = findById(id);
    	if(abonementDynamicDateMustBeUsedTo == null)return false;
    	return delete(abonementDynamicDateMustBeUsedTo);
    }
    
    public boolean delete(AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo) {
    	if(abonementDynamicDateMustBeUsedTo == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(abonementDynamicDateMustBeUsedTo);
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
    public List <AbonementDynamicDateMustBeUsedTo> listAll() {
    	
        Transaction transaction = null;
        List < AbonementDynamicDateMustBeUsedTo > abonementDynamicDatesMustBeUsedTo = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            abonementDynamicDatesMustBeUsedTo = session.createQuery("FROM " + Abonement.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return abonementDynamicDatesMustBeUsedTo;
    }

    @SuppressWarnings("unchecked")
    public List <AbonementDynamicDateMustBeUsedTo> listAllByAbonement(Abonement abonement, boolean isOrderByDate) {
    	
        Transaction transaction = null;
        List < AbonementDynamicDateMustBeUsedTo > abonementDynamicDatesMustBeUsedTo = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            abonementDynamicDatesMustBeUsedTo = (isOrderByDate 
            		? session.createQuery("FROM " + Abonement.class.getSimpleName() + " order by dateFrom DESC").getResultList()
            		: session.createQuery("FROM " + Abonement.class.getSimpleName() + " order by id DESC").getResultList()
            		);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return abonementDynamicDatesMustBeUsedTo;
    }
    
    
}
