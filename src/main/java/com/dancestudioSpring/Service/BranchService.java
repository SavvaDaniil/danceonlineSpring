package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Branch;
import com.dancestudioSpring.Repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepository;
	
    public Branch findById(int id)
    {
    	Branch branch = branchRepository.findById(id);
		return branch;
    }


    public Branch add(Branch branch)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(branch);
            transaction.commit();
            session.close();
            return branch;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update Branch
     * @param Branch
     */
    public boolean update(Branch branch) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(branch);
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
    	Branch branch = findById(id);
    	if(branch == null)return false;
    	return delete(branch);
    }
    
    public boolean delete(Branch branch) {
    	if(branch == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(branch);
            /*
            Branch branch = session.get(Branch.class, id);
            if (branch != null) {
                session.delete(branch);
                System.out.println("Branch is deleted");
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
    public List <Branch> listAll() {
    	
        Transaction transaction = null;
        List < Branch > branches = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            branches = session.createQuery("FROM " + Branch.class.getSimpleName()).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return branches;
    }
    
}
