package com.dancestudioSpring.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Repository.AbonementRepository;

@Service
public class AbonementService {

	@Autowired
	AbonementRepository abonementRepository;

	
    public Abonement findById(int id)
    {
    	return abonementRepository.findById(id);
    }

    public Abonement add(Abonement abonement)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(abonement);
            transaction.commit();
            session.close();
            return abonement;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update Abonement
     * @param Abonement
     */
    public boolean update(Abonement abonement) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(abonement);
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
    	Abonement abonement = findById(id);
    	if(abonement == null)return false;
    	return delete(abonement);
    }
    
    public boolean delete(Abonement abonement) {
    	if(abonement == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(abonement);
            /*
            Abonement Abonement = session.get(Abonement.class, id);
            if (Abonement != null) {
                session.delete(Abonement);
                System.out.println("Abonement is deleted");
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
    
    public boolean deleteFake(Abonement abonement) {
    	abonement.setStatusOfDeleted(1);
    	return this.update(abonement);
    }
    
    @SuppressWarnings("unchecked")
    public List <Abonement> listAll() {
    	
        Transaction transaction = null;
        List < Abonement > abonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            abonements = session.createQuery("FROM " + Abonement.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return abonements;
    }
    
    @SuppressWarnings("unchecked")
    public List <Abonement> listAllNotDeleted() {
    	
        Transaction transaction = null;
        List < Abonement > abonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            abonements = session.createQuery("FROM " + Abonement.class.getSimpleName() + " WHERE status_of_deleted = '0' order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return abonements;
    }
    
    @SuppressWarnings("unchecked")
    public List <Abonement> listAllNotDeletedOrderByName() {
    	
        Transaction transaction = null;
        List < Abonement > abonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            abonements = session.createQuery("FROM " + Abonement.class.getSimpleName() + " WHERE status_of_deleted = '0' order by name").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return abonements;
    }
    
    @SuppressWarnings("unchecked")
    public List <Abonement> listAllNotDeletedBySpecialStatusOrderByName(String special_status, int is_trial) {
    	
        Transaction transaction = null;
        List < Abonement > abonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Abonement> query = session.createQuery("FROM " + Abonement.class.getSimpleName() 
            		+ " WHERE status_of_deleted = '0' AND special_status = :special_status AND is_trial = :is_trial order by name");
            
            query.setParameter("special_status", special_status);
            query.setParameter("is_trial", is_trial);
            abonements = query.getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return abonements;
    }
    
    /*


        public async Task<bool> updateByColumn(Abonement abonement, string name, string value)
        {
            switch (name)
            {
                case "name":
                    abonement.name = value;
                    break;
                case "days":
                    abonement.days = int.Parse(value);
                    break;
                case "price":
                    abonement.price = int.Parse(value);
                    break;
                case "visits":
                    abonement.visits = int.Parse(value);
                    break;
                case "is_private":
                    abonement.isPrivate = int.Parse(value);
                    break;
                case "is_trial":
                    abonement.isTrial = int.Parse(value);
                    break;
                case "status_of_visible":
                    abonement.statusOfVisible = int.Parse(value);
                    break;
                case "status_for_app":
                    abonement.statusOfApp = int.Parse(value);
                    break;
                default:
                    break;
            }
            await _dbc.SaveChangesAsync();

            return true;
        }

     */
	
}
