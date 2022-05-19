package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.ConnectionDanceGroupToUserAdmin;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Repository.ConnectionDanceGroupToUserAdminRepository;

@Service
public class ConnectionDanceGroupToUserAdminService {

	@Autowired
	ConnectionDanceGroupToUserAdminRepository connectionDanceGroupToUserAdminRepository;

	public ConnectionDanceGroupToUserAdmin findById(int id) {
		return connectionDanceGroupToUserAdminRepository.findById(id);
	}


    public ConnectionDanceGroupToUserAdmin findByDanceGroupAndUser(DanceGroup danceGroup, User user)
    {
        Transaction transaction = null;
        ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionDanceGroupToUserAdmin.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND userid = :id_of_user order by id DESC");
			query.setParameter("id_of_danceGroup", danceGroup.getId());
			query.setParameter("id_of_user", user.getId());
			connectionDanceGroupToUserAdmin = (ConnectionDanceGroupToUserAdmin)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionDanceGroupToUserAdmin;
    }

    public boolean isAnyByUserAndDanceGroup(User user, DanceGroup danceGroup)
    {
        return this.findByDanceGroupAndUser(danceGroup, user) != null;
    }

    
	
    public ConnectionDanceGroupToUserAdmin add(ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(connectionDanceGroupToUserAdmin);
            transaction.commit();
            session.close();
            return connectionDanceGroupToUserAdmin;
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
    public boolean update(ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(connectionDanceGroupToUserAdmin);
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
    public List <ConnectionDanceGroupToUserAdmin> listAll() {
    	
        Transaction transaction = null;
        List < ConnectionDanceGroupToUserAdmin > connectionsDanceGroupToUserAdmin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            connectionsDanceGroupToUserAdmin = session.createQuery("FROM " + ConnectionDanceGroupToUserAdmin.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsDanceGroupToUserAdmin;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionDanceGroupToUserAdmin> listAllByUser(User user) {
    	
        Transaction transaction = null;
        List < ConnectionDanceGroupToUserAdmin > connectionsDanceGroupToUserAdmin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionDanceGroupToUserAdmin.class.getSimpleName() 
            		+ " WHERE userid = :id_of_user order by id DESC");
			query.setParameter("id_of_user", user.getId());
			connectionsDanceGroupToUserAdmin = query.getResultList();
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsDanceGroupToUserAdmin;
    }

    
    
    public boolean delete(int id) {
    	ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin = findById(id);
    	if(connectionDanceGroupToUserAdmin == null)return false;
    	return delete(connectionDanceGroupToUserAdmin);
    }
    
    public boolean delete(DanceGroup danceGroup, User user) {
    	ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin = this.findByDanceGroupAndUser(danceGroup, user);
    	if(connectionDanceGroupToUserAdmin == null)return false;
    	return delete(connectionDanceGroupToUserAdmin);
    }
    
    
    public boolean delete(ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin) {
    	if(connectionDanceGroupToUserAdmin == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(connectionDanceGroupToUserAdmin);
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
