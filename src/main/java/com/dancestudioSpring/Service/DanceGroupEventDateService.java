package com.dancestudioSpring.Service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupEventDate;
import com.dancestudioSpring.Repository.DanceGroupEventDateRepository;

@Component
public class DanceGroupEventDateService {

	@Autowired
	DanceGroupEventDateRepository danceGroupEventDateRepository;


	public DanceGroupEventDate findById(int id) {
		return danceGroupEventDateRepository.findById(id);
	}

    public DanceGroupEventDate add(DanceGroupEventDate danceGroupEventDate)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(danceGroupEventDate);
            transaction.commit();
            session.close();
            return danceGroupEventDate;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update DanceGroup
     * @param DanceGroup
     */
    public boolean update(DanceGroupEventDate danceGroupEventDate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(danceGroupEventDate);
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
    	DanceGroupEventDate danceGroupEventDate = findById(id);
    	if(danceGroupEventDate == null)return false;
    	return delete(danceGroupEventDate);
    }
    
    public boolean delete(DanceGroupEventDate danceGroupEventDate) {
    	if(danceGroupEventDate == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(danceGroupEventDate);
            /*
            DanceGroup DanceGroup = session.get(DanceGroup.class, id);
            if (DanceGroup != null) {
                session.delete(DanceGroup);
                System.out.println("DanceGroup is deleted");
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
    public List <DanceGroupEventDate> listAll() {
    	
        Transaction transaction = null;
        List < DanceGroupEventDate > danceGroupEventDates = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupEventDates = session.createQuery("FROM " + DanceGroupEventDate.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupEventDates;
    }
	
    
    
    
    

    @SuppressWarnings("unchecked")
	public List<DanceGroupEventDate> listAllByDanceGroup(DanceGroup danceGroup)
    {
        Transaction transaction = null;
        List<DanceGroupEventDate> danceGroupEventDates = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + DanceGroupEventDate.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup ORDER BY id DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupEventDates = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupEventDates;
    }
    
    @SuppressWarnings("unchecked")
	public List<DanceGroupEventDate> listAllActiveByDanceGroup(DanceGroup danceGroup)
    {
        Transaction transaction = null;
        List<DanceGroupEventDate> danceGroupEventDates = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + DanceGroupEventDate.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup AND active = '1' ORDER BY id DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupEventDates = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupEventDates;
    }
    
    @SuppressWarnings("unchecked")
	public List<DanceGroupEventDate> listAllActiveByDanceGroup(DanceGroup danceGroup, Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List<DanceGroupEventDate> danceGroupEventDates = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + DanceGroupEventDate.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup AND active = '1'"
            		+ " AND dateOfEvent >= :dateFrom AND dateOfEvent <= :dateTo ORDER BY id DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
            danceGroupEventDates = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupEventDates;
    }
    
    @SuppressWarnings("unchecked")
	public List<DanceGroupEventDate> listAllActiveByDates(Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List<DanceGroupEventDate> danceGroupEventDates = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + DanceGroupEventDate.class.getSimpleName() 
            		+ " where active = '1'"
            		+ " AND dateOfEvent >= :dateFrom AND dateOfEvent <= :dateTo ORDER BY id DESC");
            
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
            danceGroupEventDates = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupEventDates;
    }
}
