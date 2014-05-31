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
import Entities.Solicitante;
import Entities.InconformidadAuxiliares;
import Entities.Auxiliar;
import Entities.IncAuxAuxiliar;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author DavidMontoya
 */
public class IncAuxAuxiliarJpaController implements Serializable {

    public IncAuxAuxiliarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IncAuxAuxiliar incAuxAuxiliar) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitante idSolicitante = incAuxAuxiliar.getIdSolicitante();
            if (idSolicitante != null) {
                idSolicitante = em.getReference(idSolicitante.getClass(), idSolicitante.getSolicitanteId());
                incAuxAuxiliar.setIdSolicitante(idSolicitante);
            }
            InconformidadAuxiliares idInconformidadAuxiliares = incAuxAuxiliar.getIdInconformidadAuxiliares();
            if (idInconformidadAuxiliares != null) {
                idInconformidadAuxiliares = em.getReference(idInconformidadAuxiliares.getClass(), idInconformidadAuxiliares.getInconformidadAuxiliaresId());
                incAuxAuxiliar.setIdInconformidadAuxiliares(idInconformidadAuxiliares);
            }
            Auxiliar idAuxiliar = incAuxAuxiliar.getIdAuxiliar();
            if (idAuxiliar != null) {
                idAuxiliar = em.getReference(idAuxiliar.getClass(), idAuxiliar.getAuxiliarId());
                incAuxAuxiliar.setIdAuxiliar(idAuxiliar);
            }
            em.persist(incAuxAuxiliar);
            if (idSolicitante != null) {
                idSolicitante.getIncAuxAuxiliarList().add(incAuxAuxiliar);
                idSolicitante = em.merge(idSolicitante);
            }
            if (idInconformidadAuxiliares != null) {
                idInconformidadAuxiliares.getIncAuxAuxiliarList().add(incAuxAuxiliar);
                idInconformidadAuxiliares = em.merge(idInconformidadAuxiliares);
            }
            if (idAuxiliar != null) {
                idAuxiliar.getIncAuxAuxiliarList().add(incAuxAuxiliar);
                idAuxiliar = em.merge(idAuxiliar);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIncAuxAuxiliar(incAuxAuxiliar.getIncAuxAuxiliarId()) != null) {
                throw new PreexistingEntityException("IncAuxAuxiliar " + incAuxAuxiliar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IncAuxAuxiliar incAuxAuxiliar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IncAuxAuxiliar persistentIncAuxAuxiliar = em.find(IncAuxAuxiliar.class, incAuxAuxiliar.getIncAuxAuxiliarId());
            Solicitante idSolicitanteOld = persistentIncAuxAuxiliar.getIdSolicitante();
            Solicitante idSolicitanteNew = incAuxAuxiliar.getIdSolicitante();
            InconformidadAuxiliares idInconformidadAuxiliaresOld = persistentIncAuxAuxiliar.getIdInconformidadAuxiliares();
            InconformidadAuxiliares idInconformidadAuxiliaresNew = incAuxAuxiliar.getIdInconformidadAuxiliares();
            Auxiliar idAuxiliarOld = persistentIncAuxAuxiliar.getIdAuxiliar();
            Auxiliar idAuxiliarNew = incAuxAuxiliar.getIdAuxiliar();
            if (idSolicitanteNew != null) {
                idSolicitanteNew = em.getReference(idSolicitanteNew.getClass(), idSolicitanteNew.getSolicitanteId());
                incAuxAuxiliar.setIdSolicitante(idSolicitanteNew);
            }
            if (idInconformidadAuxiliaresNew != null) {
                idInconformidadAuxiliaresNew = em.getReference(idInconformidadAuxiliaresNew.getClass(), idInconformidadAuxiliaresNew.getInconformidadAuxiliaresId());
                incAuxAuxiliar.setIdInconformidadAuxiliares(idInconformidadAuxiliaresNew);
            }
            if (idAuxiliarNew != null) {
                idAuxiliarNew = em.getReference(idAuxiliarNew.getClass(), idAuxiliarNew.getAuxiliarId());
                incAuxAuxiliar.setIdAuxiliar(idAuxiliarNew);
            }
            incAuxAuxiliar = em.merge(incAuxAuxiliar);
            if (idSolicitanteOld != null && !idSolicitanteOld.equals(idSolicitanteNew)) {
                idSolicitanteOld.getIncAuxAuxiliarList().remove(incAuxAuxiliar);
                idSolicitanteOld = em.merge(idSolicitanteOld);
            }
            if (idSolicitanteNew != null && !idSolicitanteNew.equals(idSolicitanteOld)) {
                idSolicitanteNew.getIncAuxAuxiliarList().add(incAuxAuxiliar);
                idSolicitanteNew = em.merge(idSolicitanteNew);
            }
            if (idInconformidadAuxiliaresOld != null && !idInconformidadAuxiliaresOld.equals(idInconformidadAuxiliaresNew)) {
                idInconformidadAuxiliaresOld.getIncAuxAuxiliarList().remove(incAuxAuxiliar);
                idInconformidadAuxiliaresOld = em.merge(idInconformidadAuxiliaresOld);
            }
            if (idInconformidadAuxiliaresNew != null && !idInconformidadAuxiliaresNew.equals(idInconformidadAuxiliaresOld)) {
                idInconformidadAuxiliaresNew.getIncAuxAuxiliarList().add(incAuxAuxiliar);
                idInconformidadAuxiliaresNew = em.merge(idInconformidadAuxiliaresNew);
            }
            if (idAuxiliarOld != null && !idAuxiliarOld.equals(idAuxiliarNew)) {
                idAuxiliarOld.getIncAuxAuxiliarList().remove(incAuxAuxiliar);
                idAuxiliarOld = em.merge(idAuxiliarOld);
            }
            if (idAuxiliarNew != null && !idAuxiliarNew.equals(idAuxiliarOld)) {
                idAuxiliarNew.getIncAuxAuxiliarList().add(incAuxAuxiliar);
                idAuxiliarNew = em.merge(idAuxiliarNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = incAuxAuxiliar.getIncAuxAuxiliarId();
                if (findIncAuxAuxiliar(id) == null) {
                    throw new NonexistentEntityException("The incAuxAuxiliar with id " + id + " no longer exists.");
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
            IncAuxAuxiliar incAuxAuxiliar;
            try {
                incAuxAuxiliar = em.getReference(IncAuxAuxiliar.class, id);
                incAuxAuxiliar.getIncAuxAuxiliarId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The incAuxAuxiliar with id " + id + " no longer exists.", enfe);
            }
            Solicitante idSolicitante = incAuxAuxiliar.getIdSolicitante();
            if (idSolicitante != null) {
                idSolicitante.getIncAuxAuxiliarList().remove(incAuxAuxiliar);
                idSolicitante = em.merge(idSolicitante);
            }
            InconformidadAuxiliares idInconformidadAuxiliares = incAuxAuxiliar.getIdInconformidadAuxiliares();
            if (idInconformidadAuxiliares != null) {
                idInconformidadAuxiliares.getIncAuxAuxiliarList().remove(incAuxAuxiliar);
                idInconformidadAuxiliares = em.merge(idInconformidadAuxiliares);
            }
            Auxiliar idAuxiliar = incAuxAuxiliar.getIdAuxiliar();
            if (idAuxiliar != null) {
                idAuxiliar.getIncAuxAuxiliarList().remove(incAuxAuxiliar);
                idAuxiliar = em.merge(idAuxiliar);
            }
            em.remove(incAuxAuxiliar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IncAuxAuxiliar> findIncAuxAuxiliarEntities() {
        return findIncAuxAuxiliarEntities(true, -1, -1);
    }

    public List<IncAuxAuxiliar> findIncAuxAuxiliarEntities(int maxResults, int firstResult) {
        return findIncAuxAuxiliarEntities(false, maxResults, firstResult);
    }

    private List<IncAuxAuxiliar> findIncAuxAuxiliarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IncAuxAuxiliar.class));
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

    public IncAuxAuxiliar findIncAuxAuxiliar(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IncAuxAuxiliar.class, id);
        } finally {
            em.close();
        }
    }

    public int getIncAuxAuxiliarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IncAuxAuxiliar> rt = cq.from(IncAuxAuxiliar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
