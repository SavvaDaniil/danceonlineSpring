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
import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Entity.TeacherSalary;
import com.dancestudioSpring.Repository.TeacherSalaryRepository;

@Service
public class TeacherSalaryService {

	@Autowired
	TeacherSalaryRepository teacherSalaryRepository;

	public TeacherSalary findById(int id) {
		return teacherSalaryRepository.findById(id);
	}

    public TeacherSalary add(TeacherSalary teacherSalary)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(teacherSalary);
            transaction.commit();
            session.close();
            return teacherSalary;
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
    public boolean update(TeacherSalary teacherSalary) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(teacherSalary);
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
    	TeacherSalary teacherSalary = findById(id);
    	if(teacherSalary == null)return false;
    	return delete(teacherSalary);
    }
    
    public boolean delete(TeacherSalary teacherSalary) {
    	if(teacherSalary == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(teacherSalary);
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
	
    
    
    

    public TeacherSalary find(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, Teacher teacher)
    {
        Transaction transaction = null;
        TeacherSalary teacherSalary = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + TeacherSalary.class.getSimpleName() 
            		+ " where teacherid = :id_of_teacher AND danceGroupid = :id_of_danceGroup"
            		+ " AND danceGroupDayOfWeekid = :id_of_danceGroupDayOfWeek AND dateOfDay = :dateOfDay order by id DESC");
            query.setParameter("id_of_teacher", teacher.getId());
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("id_of_danceGroupDayOfWeek", danceGroupDayOfWeek.getId());
            query.setParameter("dateOfDay", dateOfDay);
            teacherSalary = (TeacherSalary)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherSalary;
    }
    

    public TeacherSalary find(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek)
    {
        Transaction transaction = null;
        TeacherSalary teacherSalary = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + TeacherSalary.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup"
            		+ " AND danceGroupDayOfWeekid = :id_of_danceGroupDayOfWeek AND dateOfDay = :dateOfDay order by id DESC");
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("id_of_danceGroupDayOfWeek", danceGroupDayOfWeek.getId());
            query.setParameter("dateOfDay", dateOfDay);
            teacherSalary = (TeacherSalary)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherSalary;
    }
    



    @SuppressWarnings("unchecked")
    public List<TeacherSalary> listAll()
    {
        Transaction transaction = null;
        List<TeacherSalary> teacherSalaries = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + TeacherSalary.class.getSimpleName() 
            		+ " order by id DESC");
            teacherSalaries = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherSalaries;
    }

    @SuppressWarnings("unchecked")
    public List<TeacherSalary> listAllByDanceGroupAndDates(DanceGroup danceGroup, Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List<TeacherSalary> teacherSalaries = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + TeacherSalary.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup"
            		+ " AND dateOfDay >= :dateFrom AND dateFrom <= :dateFrom order by id DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateFrom", dateTo);
            teacherSalaries = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherSalaries;
    }
	
	
}
