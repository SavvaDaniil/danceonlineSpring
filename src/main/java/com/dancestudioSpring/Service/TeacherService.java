package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	

    public Teacher findById(int id)
    {
    	Teacher teacher = teacherRepository.findById(id);
		return teacher;
    }


    public Teacher add(Teacher Teacher)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(Teacher);
            transaction.commit();
            session.close();
            return Teacher;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update Teacher
     * @param Teacher
     */
    public boolean update(Teacher Teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(Teacher);
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
    	Teacher Teacher = findById(id);
    	if(Teacher == null)return false;
    	return delete(Teacher);
    }
    
    public boolean delete(Teacher Teacher) {
    	if(Teacher == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(Teacher);
            /*
            Teacher Teacher = session.get(Teacher.class, id);
            if (Teacher != null) {
                session.delete(Teacher);
                System.out.println("Teacher is deleted");
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
    public List <Teacher> listAll() {
    	
        Transaction transaction = null;
        List < Teacher > teacheres = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            teacheres = session.createQuery("FROM " + Teacher.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacheres;
    }
}
