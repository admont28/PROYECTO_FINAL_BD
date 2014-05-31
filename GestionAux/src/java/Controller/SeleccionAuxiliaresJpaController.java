/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.EvaluacionAuxiliares;
import Entities.Auxiliar;
import Entities.SeleccionAuxiliares;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author DavidMontoya
 */
public class SeleccionAuxiliaresJpaController implements Serializable {

    public SeleccionAuxiliaresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SeleccionAuxiliares seleccionAuxiliares) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EvaluacionAuxiliares idEvaluacionAuxiliares = seleccionAuxiliares.getIdEvaluacionAuxiliares();
            if (idEvaluacionAuxiliares != null) {
                idEvaluacionAuxiliares = em.getReference(idEvaluacionAuxiliares.getClass(), idEvaluacionAuxiliares.getEvaluacionAuxiliaresId());
                seleccionAuxiliares.setIdEvaluacionAuxiliares(idEvaluacionAuxiliares);
            }
            Auxiliar idAuxiliares = seleccionAuxiliares.getIdAuxiliares();
            if (idAuxiliares != null) {
                idAuxiliares = em.getReference(idAuxiliares.getClass(), idAuxiliares.getAuxiliarId());
                seleccionAuxiliares.setIdAuxiliares(idAuxiliares);
            }
            em.persist(seleccionAuxiliares);
            if (idEvaluacionAuxiliares != null) {
                idEvaluacionAuxiliares.getSeleccionAuxiliaresList().add(seleccionAuxiliares);
                idEvaluacionAuxiliares = em.merge(idEvaluacionAuxiliares);
            }
            if (idAuxiliares != null) {
                idAuxiliares.getSeleccionAuxiliaresList().add(seleccionAuxiliares);
                idAuxiliares = em.merge(idAuxiliares);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSeleccionAuxiliares(seleccionAuxiliares.getSeleccionAuxiliaresId()) != null) {
                throw new PreexistingEntityException("SeleccionAuxiliares " + seleccionAuxiliares + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SeleccionAuxiliares seleccionAuxiliares) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SeleccionAuxiliares persistentSeleccionAuxiliares = em.find(SeleccionAuxiliares.class, seleccionAuxiliares.getSeleccionAuxiliaresId());
            EvaluacionAuxiliares idEvaluacionAuxiliaresOld = persistentSeleccionAuxiliares.getIdEvaluacionAuxiliares();
            EvaluacionAuxiliares idEvaluacionAuxiliaresNew = seleccionAuxiliares.getIdEvaluacionAuxiliares();
            Auxiliar idAuxiliaresOld = persistentSeleccionAuxiliares.getIdAuxiliares();
            Auxiliar idAuxiliaresNew = seleccionAuxiliares.getIdAuxiliares();
            if (idEvaluacionAuxiliaresNew != null) {
                idEvaluacionAuxiliaresNew = em.getReference(idEvaluacionAuxiliaresNew.getClass(), idEvaluacionAuxiliaresNew.getEvaluacionAuxiliaresId());
                seleccionAuxiliares.setIdEvaluacionAuxiliares(idEvaluacionAuxiliaresNew);
            }
            if (idAuxiliaresNew != null) {
                idAuxiliaresNew = em.getReference(idAuxiliaresNew.getClass(), idAuxiliaresNew.getAuxiliarId());
                seleccionAuxiliares.setIdAuxiliares(idAuxiliaresNew);
            }
            seleccionAuxiliares = em.merge(seleccionAuxiliares);
            if (idEvaluacionAuxiliaresOld != null && !idEvaluacionAuxiliaresOld.equals(idEvaluacionAuxiliaresNew)) {
                idEvaluacionAuxiliaresOld.getSeleccionAuxiliaresList().remove(seleccionAuxiliares);
                idEvaluacionAuxiliaresOld = em.merge(idEvaluacionAuxiliaresOld);
            }
            if (idEvaluacionAuxiliaresNew != null && !idEvaluacionAuxiliaresNew.equals(idEvaluacionAuxiliaresOld)) {
                idEvaluacionAuxiliaresNew.getSeleccionAuxiliaresList().add(seleccionAuxiliares);
                idEvaluacionAuxiliaresNew = em.merge(idEvaluacionAuxiliaresNew);
            }
            if (idAuxiliaresOld != null && !idAuxiliaresOld.equals(idAuxiliaresNew)) {
                idAuxiliaresOld.getSeleccionAuxiliaresList().remove(seleccionAuxiliares);
                idAuxiliaresOld = em.merge(idAuxiliaresOld);
            }
            if (idAuxiliaresNew != null && !idAuxiliaresNew.equals(idAuxiliaresOld)) {
                idAuxiliaresNew.getSeleccionAuxiliaresList().add(seleccionAuxiliares);
                idAuxiliaresNew = em.merge(idAuxiliaresNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = seleccionAuxiliares.getSeleccionAuxiliaresId();
                if (findSeleccionAuxiliares(id) == null) {
                    throw new NonexistentEntityException("The seleccionAuxiliares with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SeleccionAuxiliares seleccionAuxiliares;
            try {
                seleccionAuxiliares = em.getReference(SeleccionAuxiliares.class, id);
                seleccionAuxiliares.getSeleccionAuxiliaresId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seleccionAuxiliares with id " + id + " no longer exists.", enfe);
            }
            EvaluacionAuxiliares idEvaluacionAuxiliares = seleccionAuxiliares.getIdEvaluacionAuxiliares();
            if (idEvaluacionAuxiliares != null) {
                idEvaluacionAuxiliares.getSeleccionAuxiliaresList().remove(seleccionAuxiliares);
                idEvaluacionAuxiliares = em.merge(idEvaluacionAuxiliares);
            }
            Auxiliar idAuxiliares = seleccionAuxiliares.getIdAuxiliares();
            if (idAuxiliares != null) {
                idAuxiliares.getSeleccionAuxiliaresList().remove(seleccionAuxiliares);
                idAuxiliares = em.merge(idAuxiliares);
            }
            em.remove(seleccionAuxiliares);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SeleccionAuxiliares> findSeleccionAuxiliaresEntities() {
        return findSeleccionAuxiliaresEntities(true, -1, -1);
    }

    public List<SeleccionAuxiliares> findSeleccionAuxiliaresEntities(int maxResults, int firstResult) {
        return findSeleccionAuxiliaresEntities(false, maxResults, firstResult);
    }

    private List<SeleccionAuxiliares> findSeleccionAuxiliaresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SeleccionAuxiliares.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public SeleccionAuxiliares findSeleccionAuxiliares(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SeleccionAuxiliares.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeleccionAuxiliaresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SeleccionAuxiliares> rt = cq.from(SeleccionAuxiliares.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
