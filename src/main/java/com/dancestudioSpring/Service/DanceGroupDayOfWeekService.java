package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Repository.DanceGroupDayOfWeekRepository;

@Service
public class DanceGroupDayOfWeekService {

	@Autowired
	DanceGroupDayOfWeekRepository danceGroupDayOfWeekRepository;

	public DanceGroupDayOfWeek findById(int id) {
		return danceGroupDayOfWeekRepository.findById(id);
	}
	


    public DanceGroupDayOfWeek add(DanceGroupDayOfWeek danceGroupDayOfWeek)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(danceGroupDayOfWeek);
            transaction.commit();
            session.close();
            return danceGroupDayOfWeek;
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
    public boolean update(DanceGroupDayOfWeek danceGroupDayOfWeek) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(danceGroupDayOfWeek);
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
    	DanceGroupDayOfWeek danceGroupDayOfWeek = findById(id);
    	if(danceGroupDayOfWeek == null)return false;
    	return delete(danceGroupDayOfWeek);
    }
    
    public boolean delete(DanceGroupDayOfWeek danceGroupDayOfWeek) {
    	if(danceGroupDayOfWeek == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(danceGroupDayOfWeek);
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
    public List <DanceGroupDayOfWeek> listAll() {
    	
        Transaction transaction = null;
        List < DanceGroupDayOfWeek > danceGroupDayOfWeeks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupDayOfWeeks = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName()).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeeks;
    }



    public DanceGroupDayOfWeek findByIdActive(int id) {
    	
        Transaction transaction = null;
        DanceGroupDayOfWeek danceGroupDayOfWeek = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName() 
            		+ " where id = :id_of_dance_group_day_of_week AND status = '1'");
            query.setParameter("id_of_dance_group_day_of_week", id);
            danceGroupDayOfWeek = (DanceGroupDayOfWeek)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeek;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroupDayOfWeek> listAllActive() {
    	
        Transaction transaction = null;
        List < DanceGroupDayOfWeek > danceGroupDayOfWeeks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupDayOfWeeks = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName() 
            		+ " WHERE status = '1' ORDER BY id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeeks;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroupDayOfWeek> listAllOrderByTimeFrom() {
    	
        Transaction transaction = null;
        List < DanceGroupDayOfWeek > danceGroupDayOfWeeks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupDayOfWeeks = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName() 
            		+ " ORDER BY timeFrom").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeeks;
    }
    
    @SuppressWarnings("unchecked")
	public List <DanceGroupDayOfWeek> listAllByDanceGroup(DanceGroup danceGroup) {
    	
        Transaction transaction = null;
        List < DanceGroupDayOfWeek > danceGroupDayOfWeeks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup ORDER BY id DESC");
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupDayOfWeeks = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeeks;
    }
    
    @SuppressWarnings("unchecked")
	public List <DanceGroupDayOfWeek> listAllEventByDanceGroup(DanceGroup danceGroup) {
    	
        Transaction transaction = null;
        List < DanceGroupDayOfWeek > danceGroupDayOfWeeks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND is_event = '1' ORDER BY id DESC");
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupDayOfWeeks = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeeks;
    }
    
    @SuppressWarnings("unchecked")
	public List <DanceGroupDayOfWeek> listAllActiveByDanceGroupOrderByTimeFrom(DanceGroup danceGroup) {
    	
        Transaction transaction = null;
        List < DanceGroupDayOfWeek > danceGroupDayOfWeeks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + DanceGroupDayOfWeek.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND status = '1' ORDER BY timeFrom ");
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            danceGroupDayOfWeeks = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupDayOfWeeks;
    }
    
    
    
    
    
}
