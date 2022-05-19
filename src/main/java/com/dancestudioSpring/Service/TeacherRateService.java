package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Entity.TeacherRate;
import com.dancestudioSpring.Repository.TeacherRateRepository;

@Service
public class TeacherRateService {

	@Autowired
	TeacherRateRepository teacherRateRepository;
	

    public TeacherRate findById(int id)
    {
    	TeacherRate teacherRate = teacherRateRepository.findById(id);
		return teacherRate;
    }


    public TeacherRate add(TeacherRate TeacherRate)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(TeacherRate);
            transaction.commit();
            session.close();
            return TeacherRate;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update TeacherRate
     * @param TeacherRate
     */
    public boolean update(TeacherRate teacherRate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(teacherRate);
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
    	TeacherRate teacherRate = findById(id);
    	if(teacherRate == null)return false;
    	return delete(teacherRate);
    }
    
    public boolean delete(TeacherRate teacherRate) {
    	if(teacherRate == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(teacherRate);
            /*
            TeacherRate TeacherRate = session.get(TeacherRate.class, id);
            if (TeacherRate != null) {
                session.delete(TeacherRate);
                System.out.println("TeacherRate is deleted");
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
    public List <TeacherRate> listAll() {
    	
        Transaction transaction = null;
        List < TeacherRate > teacherRatees = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            teacherRatees = session.createQuery("FROM " + TeacherRate.class.getSimpleName()).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherRatees;
    }

    public List <TeacherRate> listAllByTeacher(Teacher teacher){
    	return this.listAllByIdOfTeacher(teacher.getId());
    }
    @SuppressWarnings("unchecked")
    public List <TeacherRate> listAllByIdOfTeacher(int id_of_teacher) {
    	
        Transaction transaction = null;
        List < TeacherRate > teacherRatees = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<TeacherRate> query = session.createQuery("FROM " + TeacherRate.class.getSimpleName() + " where teacherid = :id_of_teacher ");
            query.setParameter("id_of_teacher", id_of_teacher);
            teacherRatees = query.getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacherRatees;
    }
    
    
    public boolean deleteAllByIdOfTeacher(int id_of_teacher) {
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            String hql = "delete from TeacherRate where teacherid = :id_of_teacher ";
            
            session.createQuery(hql).setParameter("id_of_teacher", id_of_teacher).executeUpdate();
            
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    	
    }
    
    
    
    
    
}
