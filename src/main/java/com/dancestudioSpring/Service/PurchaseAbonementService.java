package com.dancestudioSpring.Service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Component.HibernateUtil;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.PurchaseAbonement;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Repository.PurchaseAbonementRepository;

@Service
public class PurchaseAbonementService {

	@Autowired
	PurchaseAbonementRepository purchaseAbonementRepository;


	public PurchaseAbonement findById(int id) {
		return purchaseAbonementRepository.findById(id);
	}
	

    public PurchaseAbonement add(PurchaseAbonement purchaseAbonement)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(purchaseAbonement);
            transaction.commit();
            session.close();
            return purchaseAbonement;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update PurchaseAbonement
     * @param PurchaseAbonement
     */
    public boolean update(PurchaseAbonement purchaseAbonement) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(purchaseAbonement);
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
    	PurchaseAbonement PurchaseAbonement = findById(id);
    	if(PurchaseAbonement == null)return false;
    	return delete(PurchaseAbonement);
    }
    
    public boolean delete(PurchaseAbonement purchaseAbonement) {
    	if(purchaseAbonement == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(purchaseAbonement);
            /*
            PurchaseAbonement PurchaseAbonement = session.get(PurchaseAbonement.class, id);
            if (PurchaseAbonement != null) {
                session.delete(PurchaseAbonement);
                System.out.println("PurchaseAbonement is deleted");
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
    public List <PurchaseAbonement> listAll() {
    	
        Transaction transaction = null;
        List < PurchaseAbonement > purchaseAbonementes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            purchaseAbonementes = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() + " order by id DESC").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonementes;
    }
	
    
    
    

    @SuppressWarnings("unchecked")
	public List<PurchaseAbonement> listAllByDates(Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where dateOfBuy >= :dateFrom AND dateOfBuy <= :dateTo ORDER BY dateOfBuy");
            
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements;
    }
    
    @SuppressWarnings("unchecked")
	public List<PurchaseAbonement> listAllByDates(DanceGroup danceGroup, Date dateFrom, Date dateTo)
    {
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup"
            		+ " AND dateOfBuy >= :dateFrom AND dateOfBuy <= :dateTo ORDER BY dateOfBuy");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateFrom", dateFrom);
            query.setParameter("dateTo", dateTo);
            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements;
    }

    @SuppressWarnings("unchecked")
	public List<PurchaseAbonement> listAllByUser(User user)
    {
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where userid = :id_of_user ORDER BY dateOfBuy DESC");
            
            query.setParameter("id_of_user", user.getId());
            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements;
    }

    @SuppressWarnings("unchecked")
	public List<PurchaseAbonement> listAllActiveByUser(User user)
    {
    	Date dateNow = new Date();
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where userid = :id_of_user"
            		+ " AND visits_left > 0 AND (dateOfMustBeUsedTo >= :dateNow OR dateOfMustBeUsedTo IS NULL) ORDER BY dateOfBuy DESC");

            query.setParameter("dateNow", dateNow);
            query.setParameter("id_of_user", user.getId());
            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements;
    }

    @SuppressWarnings("unchecked")
	public List<PurchaseAbonement> listAllActiveByUser(User user, Date dateOfLesson)
    {
    	Date dateNow = new Date();
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where userid = :id_of_user"
            		+ " AND visits_left > 0 AND (dateOfMustBeUsedTo >= :dateNow OR dateOfMustBeUsedTo IS NULL)"
            		+ " AND dateOfBuy <= :dateOfLesson ORDER BY dateOfBuy DESC");

            query.setParameter("id_of_user", user.getId());
            query.setParameter("dateNow", dateNow);
            query.setParameter("dateOfLesson", dateOfLesson);
            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements;
    }
    
    
    @SuppressWarnings("unchecked")
	public boolean isAlreadyBuyed(User user, Abonement abonement)
    {
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where userid = :id_of_user AND abonementid = :id_of_abonement ORDER BY dateOfBuy DESC");

            query.setParameter("id_of_user", user.getId());
            query.setParameter("id_of_abonement", abonement.getId());
            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements != null;
    }
    

    @SuppressWarnings("unchecked")
	public boolean isTrialAlreadyBuyed(User user)
    {
        Transaction transaction = null;
        List<PurchaseAbonement> purchaseAbonements = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + PurchaseAbonement.class.getSimpleName() 
            		+ " where userid = :id_of_user AND is_trila = '1'"
            		+ " ORDER BY dateOfBuy DESC");

            query.setParameter("id_of_user", user.getId());

            purchaseAbonements = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchaseAbonements != null;
    }
}
