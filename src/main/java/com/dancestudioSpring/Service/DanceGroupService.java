package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Repository.DanceGroupRepository;

@Service
public class DanceGroupService {

	@Autowired
	DanceGroupRepository danceGroupRepository;
	
	public DanceGroup findById(int id) {
		return danceGroupRepository.findById(id);
	}
	

    public DanceGroup add(DanceGroup danceGroup)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(danceGroup);
            transaction.commit();
            session.close();
            return danceGroup;
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
    public boolean update(DanceGroup danceGroup) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(danceGroup);
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
    	DanceGroup danceGroup = findById(id);
    	if(danceGroup == null)return false;
    	return delete(danceGroup);
    }
    
    public boolean delete(DanceGroup danceGroup) {
    	if(danceGroup == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(danceGroup);
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
    public List <DanceGroup> listAll() {
    	
        Transaction transaction = null;
        List < DanceGroup > danceGroupes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupes = session.createQuery("FROM " + DanceGroup.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupes;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroup> listAllOrderByName() {
    	
        Transaction transaction = null;
        List < DanceGroup > danceGroupes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupes = session.createQuery("FROM " + DanceGroup.class.getSimpleName() + " order by name ").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupes;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroup> listAllActive() {
    	
        Transaction transaction = null;
        List < DanceGroup > danceGroupes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupes = session.createQuery("FROM " + DanceGroup.class.getSimpleName() + " where status = '1' order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupes;
    }
    
    @SuppressWarnings("unchecked")
    public List <DanceGroup> listAllActiveForApp() {
    	
        Transaction transaction = null;
        List < DanceGroup > danceGroupes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            danceGroupes = session.createQuery("FROM " + DanceGroup.class.getSimpleName() 
            		+ " where status = '1' AND status_for_app = '1' order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return danceGroupes;
    }
	
}
