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
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Entity.TeacherReplacement;
import com.dancestudioSpring.Repository.TeacherReplacementRepository;

@Service
public class TeacherReplacementService {

	@Autowired
	TeacherReplacementRepository teacheReplacementRepository;
	
    public TeacherReplacement findById(int id)
    {
    	TeacherReplacement teacherReplacement = teacheReplacementRepository.findById(id);
		return teacherReplacement;
    }


    public TeacherReplacement add(TeacherReplacement teacherReplacement)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(teacherReplacement);
            transaction.commit();
            session.close();
            return teacherReplacement;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update TeacherReplacement
     * @param TeacherReplacement
     */
    public boolean update(TeacherReplacement teacherReplacement) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(teacherReplacement);
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
    	TeacherReplacement teacherReplacement = findById(id);
    	if(teacherReplacement == null)return false;
    	return delete(teacherReplacement);
    }
    
    public boolean delete(TeacherReplacement teacherReplacement) {
    	if(teacherReplacement == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(teacherReplacement);
            /*
            TeacherReplacement TeacherReplacement = session.get(TeacherReplacement.class, id);
            if (TeacherReplacement != null) {
                session.delete(TeacherReplacement);
                System.out.println("TeacherReplacement is deleted");
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
    
    
    
    public TeacherReplacement find(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek) {

        Transaction transaction = null;
        TeacherReplacement teacherReplacement = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + TeacherReplacement.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND danceGroupDayOfWeekid = :id_of_danceGroupDayOfWeek order by id DESC");
			query.setParameter("id_of_danceGroup", danceGroup.getId());
			query.setParameter("id_of_danceGroupDayOfWeek", danceGroupDayOfWeek.getId());
			teacherReplacement = (TeacherReplacement)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherReplacement;
    }
    

	public List<TeacherReplacement> listAllByDanceGroupAndDates(DanceGroup danceGroup, Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List < TeacherReplacement > teacherReplacements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + TeacherReplacement.class.getSimpleName() 
            		+ " WHERE danceGroupid = :id_of_danceGroup AND dateFrom >= :dateFrom AND dateTo <= :dateTo order by dateOfDay DESC");
			query.setParameter("id_of_danceGroup", danceGroup.getId());
			query.setParameter("dateFrom", dateFrom);
			query.setParameter("dateTo", dateTo);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherReplacements;

    }

    public List<TeacherReplacement> listAllByDates(Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List < TeacherReplacement > teacherReplacements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + TeacherReplacement.class.getSimpleName() 
            		+ " WHERE dateFrom >= :dateFrom AND dateTo <= :dateTo order by dateOfDay DESC");
			query.setParameter("dateFrom", dateFrom);
			query.setParameter("dateTo", dateTo);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherReplacements;
    }
    
    
    public boolean delete(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek) {
    	TeacherReplacement teacherReplacement = this.find(dateOfDay, danceGroup, danceGroupDayOfWeek);
    	if(teacherReplacement == null)return false;
    	return this.delete(teacherReplacement);
    }
    
}
