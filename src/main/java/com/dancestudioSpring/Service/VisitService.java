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
import com.dancestudioSpring.Entity.PurchaseAbonement;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Entity.Visit;
import com.dancestudioSpring.Repository.VisitRepository;

@Service
public class VisitService {

	@Autowired
	VisitRepository visitRepository;

	public Visit findById(int id) {
		return visitRepository.findById(id);
	}

    public Visit add(Visit visit)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(visit);
            transaction.commit();
            session.close();
            return visit;
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
    public boolean update(Visit visit) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(visit);
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
    	Visit visit = findById(id);
    	if(visit == null)return false;
    	return delete(visit);
    }
    
    public boolean delete(Visit visit) {
    	if(visit == null)return false;
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(visit);
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
	
    
    
    

    public Visit find(User user, DanceGroup danceGroup, Date dateOfBuy)
    {
        Transaction transaction = null;
        Visit visit = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where userid = :id_of_user AND danceGroupid = :id_of_danceGroup AND dateOfBuy = :dateOfBuy order by id DESC");
            query.setParameter("id_of_user", user.getId());
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateOfBuy", dateOfBuy);
            visit = (Visit)query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visit;
    }

    @SuppressWarnings("unchecked")
    public List<Visit> listByDanceGroupAndDateOfBuy(DanceGroup danceGroup, Date dateOfBuy)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup AND dateOfBuy = :dateOfBuy order by dateOfBuy DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateOfBuy", dateOfBuy);
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
    public List<Visit> listAllByFilter(DanceGroup danceGroup, Date filterDateFrom, Date filterDateTo)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup AND dateOfBuy >= :filterDateFrom AND dateOfBuy <= :filterDateTo order by dateOfBuy DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("filterDateFrom", filterDateFrom);
            query.setParameter("filterDateTo", filterDateTo);
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public List<Visit> listAllByFilter(DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, Date filterDateFrom, Date filterDateTo)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup AND danceGroupDayOfWeekid = :id_of_danceGroupDayOfWeek "
            		+ "AND dateOfBuy >= :filterDateFrom AND dateOfBuy <= :filterDateTo order by dateOfBuy DESC");
            
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("id_of_danceGroupDayOfWeek", danceGroupDayOfWeek.getId());
            query.setParameter("filterDateFrom", filterDateFrom);
            query.setParameter("filterDateTo", filterDateTo);
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public List<Visit> listAll(User user)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where userid = :id_of_user order by dateOfBuy DESC");
            
            query.setParameter("id_of_user", user.getId());
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public List<Visit> listAllByUserAndPurchaseAbonement(User user, PurchaseAbonement purchaseAbonement)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where userid = :id_of_user AND purchaseAbonementid = :id_of_purchaseAbonement order by dateOfBuy DESC");
            
            query.setParameter("id_of_user", user.getId());
            query.setParameter("id_of_purchaseAbonement", purchaseAbonement.getId());
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public List<Visit> listAll(User user, DanceGroup danceGroup)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where userid = :id_of_user AND danceGroupid = :id_of_danceGroup order by id DESC");

            query.setParameter("id_of_user", user.getId());
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public List<Visit> listAll(User user, DanceGroup danceGroup, Date dateOfBuy)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where userid = :id_of_user AND danceGroupid = :id_of_danceGroup AND dateOfBuy = :dateOfBuy order by dateOfAdd DESC");

            query.setParameter("id_of_user", user.getId());
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateOfBuy", dateOfBuy);
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public List<Visit> listAll(User user, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, Date dateOfBuy)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where userid = :id_of_user AND danceGroupid = :id_of_danceGroup AND danceGroupDayOfWeekid = :id_of_danceGroupDayOfWeek"
            		+ " AND dateOfBuy = :dateOfBuy order by dateOfAdd DESC");

            query.setParameter("id_of_user", user.getId());
            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("id_of_danceGroupDayOfWeek", danceGroupDayOfWeek.getId());
            query.setParameter("dateOfBuy", dateOfBuy);
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits;
    }

    @SuppressWarnings("unchecked")
	public int getNumberOfVisitByPurchaseAbonement(PurchaseAbonement purchaseAbonement, int id_of_visit)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where purchaseAbonementid = :id_of_purchaseAbonement AND id <= :id_of_visit order by id DESC");

            query.setParameter("id_of_visit", id_of_visit);
            query.setParameter("id_of_purchaseAbonement", purchaseAbonement.getId());
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits != null ? visits.size() : 0;
    }
    
    @SuppressWarnings("unchecked")
	public int getNumberOfVisitByDanceGroupAndDataOfBuy(DanceGroup danceGroup, Date dateOfBuy)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where danceGroupid = :id_of_danceGroup "
            		+ " AND dateOfBuy = :dateOfBuy order by dateOfAdd DESC");

            query.setParameter("id_of_danceGroup", danceGroup.getId());
            query.setParameter("dateOfBuy", dateOfBuy);
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits != null ? visits.size() : 0;
    }
    

    @SuppressWarnings("unchecked")
	public int countAllByPurchaseAbonement(PurchaseAbonement purchaseAbonement)
    {
        Transaction transaction = null;
        List<Visit> visits = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM " + Visit.class.getSimpleName() 
            		+ " where purchaseAbonementid = :id_of_purchaseAbonement order by id DESC");

            query.setParameter("id_of_purchaseAbonement", purchaseAbonement.getId());
            visits = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return visits != null ? visits.size() : 0;
    }

    
}
