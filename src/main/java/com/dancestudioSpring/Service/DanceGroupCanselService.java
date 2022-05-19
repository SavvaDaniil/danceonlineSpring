package com.dancestudioSpring.Service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupCansel;
import com.dancestudioSpring.Repository.DanceGroupCanselRepository;

@Service
public class DanceGroupCanselService {

	@Autowired
	DanceGroupCanselRepository danceGroupCanselRepository;

	public DanceGroupCansel findById(int id) {
		return danceGroupCanselRepository.findById(id);
	}
	

    public DanceGroupCansel add(DanceGroupCansel danceGroupCansel)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(danceGroupCansel);
            transaction.commit();
            session.close();
            return danceGroupCansel;
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
    public boolean update(DanceGroupCansel danceGroupCansel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(danceGroupCansel);
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
    	DanceGroupCansel danceGroupCansel = findById(id);
    	if(danceGroupCansel == null)return false;
    	return delete(danceGroupCansel);
    }
    
    public boolean delete(DanceGroupCansel danceGroupCansel) {
    	if(danceGroupCansel == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(danceGroupCansel);
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
    public List <DanceGroupCansel> listAll() {
    	
        Transaction transaction = null;
        List < DanceGroupCansel > danceGroupCansels = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupCansels = session.createQuery("FROM " + DanceGroupCansel.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupCansels;
    }
    

    @SuppressWarnings("unchecked")
    public List <DanceGroupCansel> listAllByDanceGroupAndDateOfLesson(DanceGroup danceGroup, Date dateOfLesson){

        Transaction transaction = null;
        List < DanceGroupCansel > danceGroupCansels = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupCansel.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND status = '1' AND dateFrom <= :dateOfLesson AND dateTo >= :dateOfLesson order by id DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateOfLesson", dateOfLesson);
            danceGroupCansels = query.getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupCansels;
    }
    
	public boolean isExist(DanceGroup danceGroup, Date dateOfLesson) {
        return this.listAllByDanceGroupAndDateOfLesson(danceGroup, dateOfLesson) != null;
    }
    

    @SuppressWarnings("unchecked")
    public List <DanceGroupCansel> listAllByDanceGroup(DanceGroup danceGroup){

        Transaction transaction = null;
        List < DanceGroupCansel > danceGroupCansels = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupCansel.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup ORDER BY id DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupCansels = query.getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupCansels;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroupCansel> listAllByDanceGroupOrderByDate(DanceGroup danceGroup){

        Transaction transaction = null;
        List < DanceGroupCansel > danceGroupCansels = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupCansel.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup ORDER BY dateFrom DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupCansels = query.getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupCansels;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroupCansel> listAllByDate(Date dateFrom, Date dateTo, boolean isOnlyActive){

        Transaction transaction = null;
        List < DanceGroupCansel > danceGroupCansels = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupCansel.class.getSimpleName() 
            		+ " WHERE dateFrom <= :dateFrom AND dateTo >= :dateTo "
					+ (isOnlyActive ? "AND status = '1'" : "") + " ORDER BY dateFrom DESC");
            
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
            danceGroupCansels = query.getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupCansels;
    }
    
    
    
    
    
}
