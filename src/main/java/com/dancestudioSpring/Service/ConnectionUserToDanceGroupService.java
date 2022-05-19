package com.dancestudioSpring.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.ConnectionUserToDanceGroup;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Repository.ConnectionUserToDanceGroupRepository;

@Service
public class ConnectionUserToDanceGroupService {

	@Autowired
	ConnectionUserToDanceGroupRepository connectionUserToDanceGroupRepository;

	public ConnectionUserToDanceGroup findById(int id) {
		return connectionUserToDanceGroupRepository.findById(id);
	}
	

    public ConnectionUserToDanceGroup findByDanceGroupAndUser(DanceGroup danceGroup, User user)
    {
        Transaction transaction = null;
        ConnectionUserToDanceGroup connectionUserToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionUserToDanceGroup.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND userid = :id_of_user order by id DESC");
			query.setParameter("id_of_danceGroup", danceGroup.getId());
			query.setParameter("id_of_user", user.getId());
			connectionUserToDanceGroup = (ConnectionUserToDanceGroup)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionUserToDanceGroup;
    }

    public boolean isAnyByUserAndDanceGroup(User user, DanceGroup DanceGroup)
    {
        return this.findByDanceGroupAndUser(DanceGroup, user) != null;
    }

    
	
    public ConnectionUserToDanceGroup add(ConnectionUserToDanceGroup connectionUserToDanceGroup)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(connectionUserToDanceGroup);
            transaction.commit();
            session.close();
            return connectionUserToDanceGroup;
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
    public boolean update(ConnectionUserToDanceGroup ConnectionUserToDanceGroup) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(ConnectionUserToDanceGroup);
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
    public List <ConnectionUserToDanceGroup> listAll() {
    	
        Transaction transaction = null;
        List < ConnectionUserToDanceGroup > connectionsUserToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            connectionsUserToDanceGroup = session.createQuery("FROM " + ConnectionUserToDanceGroup.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsUserToDanceGroup;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionUserToDanceGroup> listAllByUser(User user) {
    	
        Transaction transaction = null;
        List < ConnectionUserToDanceGroup > connectionsUserToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + ConnectionUserToDanceGroup.class.getSimpleName() 
            		+ " WHERE userid = :id_of_user order by id DESC");
			query.setParameter("id_of_user", user.getId());
			connectionsUserToDanceGroup = query.getResultList();
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsUserToDanceGroup;
    }

    @SuppressWarnings("unchecked")
    public List <ConnectionUserToDanceGroup> listAllByDanceGroup(DanceGroup danceGroup, boolean onlyLast30Days) {
    	
        Transaction transaction = null;
        List < ConnectionUserToDanceGroup > connectionsUserToDanceGroup = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            if(onlyLast30Days) {
            	Calendar calendarDateMinus30Days = Calendar.getInstance();
            	calendarDateMinus30Days.setTime(new Date());
            	calendarDateMinus30Days.add(Calendar.DATE, -30);
            	SimpleDateFormat dateMinus30DaysStringFormat = new SimpleDateFormat("yyyy-MM-dd");
            	String dateMinus30DaysString = dateMinus30DaysStringFormat.format(calendarDateMinus30Days.getTime());
            	
                @SuppressWarnings("rawtypes")
    			Query query = session.createQuery("FROM " + ConnectionUserToDanceGroup.class.getSimpleName() 
                		+ " WHERE danceGroupid = :id_of_danceGroup AND dateOfUpdate >= :dateMinus30DaysString order by id DESC");
    			query.setParameter("id_of_danceGroup", danceGroup.getId());
    			query.setParameter("dateMinus30DaysString", dateMinus30DaysString);
    			connectionsUserToDanceGroup = query.getResultList();
            	
            } else {
                @SuppressWarnings("rawtypes")
    			Query query = session.createQuery("FROM " + ConnectionUserToDanceGroup.class.getSimpleName() 
                		+ " WHERE danceGroupid = :id_of_danceGroup order by id DESC");
    			query.setParameter("id_of_danceGroup", danceGroup.getId());
    			connectionsUserToDanceGroup = query.getResultList();
            }
			
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return connectionsUserToDanceGroup;
    }

    
    
    public boolean delete(int id) {
    	ConnectionUserToDanceGroup connectionUserToDanceGroup = findById(id);
    	if(connectionUserToDanceGroup == null)return false;
    	return delete(connectionUserToDanceGroup);
    }
    
    public boolean delete(DanceGroup DanceGroup, User user) {
    	ConnectionUserToDanceGroup connectionUserToDanceGroup = this.findByDanceGroupAndUser(DanceGroup, user);
    	if(connectionUserToDanceGroup == null)return false;
    	return delete(connectionUserToDanceGroup);
    }
    
    
    public boolean delete(ConnectionUserToDanceGroup connectionUserToDanceGroup) {
    	if(connectionUserToDanceGroup == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(connectionUserToDanceGroup);
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
