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
import Entities.FechaHorario;
import Entities.Hora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author DavidMontoya
 */
public class HoraJpaController implements Serializable {

    public HoraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Hora hora) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FechaHorario idFechaHorario = hora.getIdFechaHorario();
            if (idFechaHorario != null) {
                idFechaHorario = em.getReference(idFechaHorario.getClass(), idFechaHorario.getFechaHorarioId());
                hora.setIdFechaHorario(idFechaHorario);
            }
            em.persist(hora);
            if (idFechaHorario != null) {
                idFechaHorario.getHoraList().add(hora);
                idFechaHorario = em.merge(idFechaHorario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHora(hora.getHoraId()) != null) {
                throw new PreexistingEntityException("Hora " + hora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hora hora) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hora persistentHora = em.find(Hora.class, hora.getHoraId());
            FechaHorario idFechaHorarioOld = persistentHora.getIdFechaHorario();
            FechaHorario idFechaHorarioNew = hora.getIdFechaHorario();
            if (idFechaHorarioNew != null) {
                idFechaHorarioNew = em.getReference(idFechaHorarioNew.getClass(), idFechaHorarioNew.getFechaHorarioId());
                hora.setIdFechaHorario(idFechaHorarioNew);
            }
            hora = em.merge(hora);
            if (idFechaHorarioOld != null && !idFechaHorarioOld.equals(idFechaHorarioNew)) {
                idFechaHorarioOld.getHoraList().remove(hora);
                idFechaHorarioOld = em.merge(idFechaHorarioOld);
            }
            if (idFechaHorarioNew != null && !idFechaHorarioNew.equals(idFechaHorarioOld)) {
                idFechaHorarioNew.getHoraList().add(hora);
                idFechaHorarioNew = em.merge(idFechaHorarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = hora.getHoraId();
                if (findHora(id) == null) {
                    throw new NonexistentEntityException("The hora with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hora hora;
            try {
                hora = em.getReference(Hora.class, id);
                hora.getHoraId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hora with id " + id + " no longer exists.", enfe);
            }
            FechaHorario idFechaHorario = hora.getIdFechaHorario();
            if (idFechaHorario != null) {
                idFechaHorario.getHoraList().remove(hora);
                idFechaHorario = em.merge(idFechaHorario);
            }
            em.remove(hora);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hora> findHoraEntities() {
        return findHoraEntities(true, -1, -1);
    }

    public List<Hora> findHoraEntities(int maxResults, int firstResult) {
        return findHoraEntities(false, maxResults, firstResult);
    }

    private List<Hora> findHoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hora.class));
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

    public Hora findHora(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hora.class, id);
        } finally {
            em.close();
        }
    }

    public int getHoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hora> rt = cq.from(Hora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
