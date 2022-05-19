package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

    public User findById(int id)
    {
    	User user = userRepository.findById(id);
		return user;
    }

    public User findByUsername(String username)
    {
    	User user = userRepository.findByUsername(username);
		return user;
    }
    
    public User findByUsernameExceptId(int id_of_user, String username) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
			Query<User> query = session.createQuery("FROM " + User.class.getSimpleName() 
            		+ " where id != :id_of_user AND username = :username order by id DESC");
            query.setParameter("id_of_user", id_of_user);
            query.setParameter("username", username);
            User user = query.getSingleResult();
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    
    public User add(User user)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update User
     * @param User
     */
    public boolean update(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
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
    	User user = findById(id);
    	if(user == null)return false;
    	return delete(user);
    }
    
    public boolean delete(User user) {
    	if(user == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(user);
            /*
            User User = session.get(User.class, id);
            if (User != null) {
                session.delete(User);
                System.out.println("User is deleted");
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
    
    
    
    
    


    public List<User> searchUsers(int page, String queryString)
    {
        page--;
        int take = 30;
        int skip = page * take;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
        	if (!queryString.isEmpty()) {
	            @SuppressWarnings({ "unchecked" })
				Query<User> query = session.createQuery("FROM " + User.class.getSimpleName() 
						+ " WHERE username LIKE :queryString OR secondname LIKE :queryString OR firstname LIKE :queryString OR phone LIKE :queryString"
						+ " order by id DESC LIMIT :skip, :take");
				query.setParameter("queryString", "%"+queryString+"%");
				query.setParameter("skip", skip);
				query.setParameter("take", take);
	            List<User> users = query.getResultList();
	            
	            return users;
        	} else {
	            @SuppressWarnings({ "unchecked" })
				Query<User> query = session.createQuery("FROM " + User.class.getSimpleName() + " order by id DESC LIMIT :skip, :take");
				query.setParameter("skip", skip);
				query.setParameter("take", take);
	            List<User> users = query.getResultList();
	            
	            return users;
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public int searchCount(String queryString)
    {
        
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
        	if (!queryString.isEmpty()) {
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery("SELECT COUNT(*) FROM " + User.class.getSimpleName() 
						+ " WHERE username LIKE :queryString OR secondname LIKE :queryString OR firstname LIKE :queryString OR phone LIKE :queryString"
						+ " order by id DESC");
				query.setParameter("queryString", "%"+queryString+"%");
				
	            return (int)query.uniqueResult();
        	} else {
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery("SELECT COUNT(*) FROM " + User.class.getSimpleName() + " order by id DESC");
	            
	            return (int)query.uniqueResult();
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    
}
