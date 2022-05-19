package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementToDanceGroup;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Repository.ConnectionAbonementToDanceGroupRepository;

@Service
public class ConnectionAbonementToDanceGroupService {

	@Autowired
	ConnectionAbonementToDanceGroupRepository connectionAbonementToDanceGroupRepository;
	
    public ConnectionAbonementToDanceGroup findById(int id)
    {
    	return connectionAbonementToDanceGroupRepository.findById(id);
    }

    public ConnectionAbonementToDanceGroup findByAbonementAndDanceGroup(Abonement abonement, DanceGroup danceGroup) {

        Transaction transaction = null;
        ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionAbonementToDanceGroup.class.getSimpleName() 
            		+ " WHERE abonementid = :id_of_abonement AND danceGroupid = :id_of_dance_group order by id DESC");
			query.setParameter("id_of_abonement", abonement.getId());
			query.setParameter("id_of_dance_group", danceGroup.getId());
			connectionAbonementToDanceGroup = (ConnectionAbonementToDanceGroup)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionAbonementToDanceGroup;
    }


    public ConnectionAbonementToDanceGroup add(ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(connectionAbonementToDanceGroup);
            transaction.commit();
            session.close();
            return connectionAbonementToDanceGroup;
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
    public boolean update(ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(connectionAbonementToDanceGroup);
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
    	ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup = findById(id);
    	if(connectionAbonementToDanceGroup == null)return false;
    	return delete(connectionAbonementToDanceGroup);
    }
    

    public boolean delete(Abonement abonement, DanceGroup danceGroup)
    {
    	ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup = this.findByAbonementAndDanceGroup(abonement, danceGroup);
    	if(connectionAbonementToDanceGroup == null)return false;
    	return this.delete(connectionAbonementToDanceGroup);
    }
    
    public boolean delete(ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup) {
    	if(connectionAbonementToDanceGroup == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(connectionAbonementToDanceGroup);
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
    public List <ConnectionAbonementToDanceGroup> listAll() {
    	
        Transaction transaction = null;
        List < ConnectionAbonementToDanceGroup > connectionsAbonementToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            connectionsAbonementToDanceGroup = session.createQuery("FROM " + ConnectionAbonementToDanceGroup.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsAbonementToDanceGroup;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionAbonementToDanceGroup> listAllByDanceGroup(DanceGroup danceGroup) {
    	
        Transaction transaction = null;
        List < ConnectionAbonementToDanceGroup > connectionsAbonementToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionAbonementToDanceGroup.class.getSimpleName() 
            		+ " WHERE userid = :id_of_dance_group order by id DESC");
			query.setParameter("id_of_dance_group", danceGroup.getId());
			connectionsAbonementToDanceGroup = query.getResultList();
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsAbonementToDanceGroup;
    }


}
