/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.PreexistingEntityException;
import Entities.AuxCumplimientoActividades;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.TipoAuxiliar;
import Entities.CumplimientoActividades;
import Entities.Auxiliar;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author DavidMontoya
 */
public class AuxCumplimientoActividadesJpaController implements Serializable {

    public AuxCumplimientoActividadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AuxCumplimientoActividades auxCumplimientoActividades) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoAuxiliar idTipoAuxiliar = auxCumplimientoActividades.getIdTipoAuxiliar();
            if (idTipoAuxiliar != null) {
                idTipoAuxiliar = em.getReference(idTipoAuxiliar.getClass(), idTipoAuxiliar.getTipoAuxiliarId());
                auxCumplimientoActividades.setIdTipoAuxiliar(idTipoAuxiliar);
            }
            CumplimientoActividades idCumplimientoActividades = auxCumplimientoActividades.getIdCumplimientoActividades();
            if (idCumplimientoActividades != null) {
                idCumplimientoActividades = em.getReference(idCumplimientoActividades.getClass(), idCumplimientoActividades.getCumpActId());
                auxCumplimientoActividades.setIdCumplimientoActividades(idCumplimientoActividades);
            }
            Auxiliar idAuxiliar = auxCumplimientoActividades.getIdAuxiliar();
            if (idAuxiliar != null) {
                idAuxiliar = em.getReference(idAuxiliar.getClass(), idAuxiliar.getAuxiliarId());
                auxCumplimientoActividades.setIdAuxiliar(idAuxiliar);
            }
            em.persist(auxCumplimientoActividades);
            if (idTipoAuxiliar != null) {
                idTipoAuxiliar.getAuxCumplimientoActividadesList().add(auxCumplimientoActividades);
                idTipoAuxiliar = em.merge(idTipoAuxiliar);
            }
            if (idCumplimientoActividades != null) {
                idCumplimientoActividades.getAuxCumplimientoActividadesList().add(auxCumplimientoActividades);
                idCumplimientoActividades = em.merge(idCumplimientoActividades);
            }
            if (idAuxiliar != null) {
                idAuxiliar.getAuxCumplimientoActividadesList().add(auxCumplimientoActividades);
                idAuxiliar = em.merge(idAuxiliar);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAuxCumplimientoActividades(auxCumplimientoActividades.getAuxCumpActividadesId()) != null) {
                throw new PreexistingEntityException("AuxCumplimientoActividades " + auxCumplimientoActividades + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AuxCumplimientoActividades auxCumplimientoActividades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AuxCumplimientoActividades persistentAuxCumplimientoActividades = em.find(AuxCumplimientoActividades.class, auxCumplimientoActividades.getAuxCumpActividadesId());
            TipoAuxiliar idTipoAuxiliarOld = persistentAuxCumplimientoActividades.getIdTipoAuxiliar();
            TipoAuxiliar idTipoAuxiliarNew = auxCumplimientoActividades.getIdTipoAuxiliar();
            CumplimientoActividades idCumplimientoActividadesOld = persistentAuxCumplimientoActividades.getIdCumplimientoActividades();
            CumplimientoActividades idCumplimientoActividadesNew = auxCumplimientoActividades.getIdCumplimientoActividades();
            Auxiliar idAuxiliarOld = persistentAuxCumplimientoActividades.getIdAuxiliar();
            Auxiliar idAuxiliarNew = auxCumplimientoActividades.getIdAuxiliar();
            if (idTipoAuxiliarNew != null) {
                idTipoAuxiliarNew = em.getReference(idTipoAuxiliarNew.getClass(), idTipoAuxiliarNew.getTipoAuxiliarId());
                auxCumplimientoActividades.setIdTipoAuxiliar(idTipoAuxiliarNew);
            }
            if (idCumplimientoActividadesNew != null) {
                idCumplimientoActividadesNew = em.getReference(idCumplimientoActividadesNew.getClass(), idCumplimientoActividadesNew.getCumpActId());
                auxCumplimientoActividades.setIdCumplimientoActividades(idCumplimientoActividadesNew);
            }
            if (idAuxiliarNew != null) {
                idAuxiliarNew = em.getReference(idAuxiliarNew.getClass(), idAuxiliarNew.getAuxiliarId());
                auxCumplimientoActividades.setIdAuxiliar(idAuxiliarNew);
            }
            auxCumplimientoActividades = em.merge(auxCumplimientoActividades);
            if (idTipoAuxiliarOld != null && !idTipoAuxiliarOld.equals(idTipoAuxiliarNew)) {
                idTipoAuxiliarOld.getAuxCumplimientoActividadesList().remove(auxCumplimientoActividades);
                idTipoAuxiliarOld = em.merge(idTipoAuxiliarOld);
            }
            if (idTipoAuxiliarNew != null && !idTipoAuxiliarNew.equals(idTipoAuxiliarOld)) {
                idTipoAuxiliarNew.getAuxCumplimientoActividadesList().add(auxCumplimientoActividades);
                idTipoAuxiliarNew = em.merge(idTipoAuxiliarNew);
            }
            if (idCumplimientoActividadesOld != null && !idCumplimientoActividadesOld.equals(idCumplimientoActividadesNew)) {
                idCumplimientoActividadesOld.getAuxCumplimientoActividadesList().remove(auxCumplimientoActividades);
                idCumplimientoActividadesOld = em.merge(idCumplimientoActividadesOld);
            }
            if (idCumplimientoActividadesNew != null && !idCumplimientoActividadesNew.equals(idCumplimientoActividadesOld)) {
                idCumplimientoActividadesNew.getAuxCumplimientoActividadesList().add(auxCumplimientoActividades);
                idCumplimientoActividadesNew = em.merge(idCumplimientoActividadesNew);
            }
            if (idAuxiliarOld != null && !idAuxiliarOld.equals(idAuxiliarNew)) {
                idAuxiliarOld.getAuxCumplimientoActividadesList().remove(auxCumplimientoActividades);
                idAuxiliarOld = em.merge(idAuxiliarOld);
            }
            if (idAuxiliarNew != null && !idAuxiliarNew.equals(idAuxiliarOld)) {
                idAuxiliarNew.getAuxCumplimientoActividadesList().add(auxCumplimientoActividades);
                idAuxiliarNew = em.merge(idAuxiliarNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = auxCumplimientoActividades.getAuxCumpActividadesId();
                if (findAuxCumplimientoActividades(id) == null) {
                    throw new NonexistentEntityException("The auxCumplimientoActividades with id " + id + " no longer exists.");
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
            AuxCumplimientoActividades auxCumplimientoActividades;
            try {
                auxCumplimientoActividades = em.getReference(AuxCumplimientoActividades.class, id);
                auxCumplimientoActividades.getAuxCumpActividadesId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auxCumplimientoActividades with id " + id + " no longer exists.", enfe);
            }
            TipoAuxiliar idTipoAuxiliar = auxCumplimientoActividades.getIdTipoAuxiliar();
            if (idTipoAuxiliar != null) {
                idTipoAuxiliar.getAuxCumplimientoActividadesList().remove(auxCumplimientoActividades);
                idTipoAuxiliar = em.merge(idTipoAuxiliar);
            }
            CumplimientoActividades idCumplimientoActividades = auxCumplimientoActividades.getIdCumplimientoActividades();
            if (idCumplimientoActividades != null) {
                idCumplimientoActividades.getAuxCumplimientoActividadesList().remove(auxCumplimientoActividades);
                idCumplimientoActividades = em.merge(idCumplimientoActividades);
            }
            Auxiliar idAuxiliar = auxCumplimientoActividades.getIdAuxiliar();
            if (idAuxiliar != null) {
                idAuxiliar.getAuxCumplimientoActividadesList().remove(auxCumplimientoActividades);
                idAuxiliar = em.merge(idAuxiliar);
            }
            em.remove(auxCumplimientoActividades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AuxCumplimientoActividades> findAuxCumplimientoActividadesEntities() {
        return findAuxCumplimientoActividadesEntities(true, -1, -1);
    }

    public List<AuxCumplimientoActividades> findAuxCumplimientoActividadesEntities(int maxResults, int firstResult) {
        return findAuxCumplimientoActividadesEntities(false, maxResults, firstResult);
    }

    private List<AuxCumplimientoActividades> findAuxCumplimientoActividadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AuxCumplimientoActividades.class));
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

    public AuxCumplimientoActividades findAuxCumplimientoActividades(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AuxCumplimientoActividades.class, id);
        } finally {
            em.close();
        }
    }

    public int getAuxCumplimientoActividadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AuxCumplimientoActividades> rt = cq.from(AuxCumplimientoActividades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
