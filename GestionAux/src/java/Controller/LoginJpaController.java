/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Auxiliar;
import Entities.Secretaria;
import Entities.Solicitante;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author DavidMontoya
 */
public class LoginJpaController implements Serializable{
    
    private EntityManagerFactory emf = null;
    
    public LoginJpaController(EntityManagerFactory emf) {
         this.emf = emf;
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public Object validacionLogin(String id, String password){
        try {
            EntityManager em = getEntityManager();
            /*
            Auxiliar
            Solicitante
            Secretaria
            Consejo Currilar - pendiente
            */
            Query q = em.createQuery("SELECT a.password FROM Auxiliar a WHERE a.codigoAuxiliar = :COD_AUX");
            q.setParameter("COD_AUX", id);
            String resultado = (String) q.getSingleResult();
            String passEncrypt = md5(password);
            if(passEncrypt.equals(resultado)){
                return Auxiliar.class;
            }else{
               q = em.createQuery("SELECT s.password FROM Solicitante s WHERE s.solicitanteId = :SOL_ID");
               q.setParameter("SOL_ID", id);
               resultado = (String) q.getSingleResult();
               if(passEncrypt.equals(id)){
                   return Solicitante.class;
               }else{
                   q = em.createQuery("SELECT secre.password FROM Secretaria secre WHERE secre.secretariaId :SECRE_ID");
                   q.setParameter("SECRE_ID", id);
                   resultado = (String) q.getSingleResult();
                   if(passEncrypt.equals(resultado)){
                       return Secretaria.class;
                   }
               }
            }
            return null; 
        } catch (Exception ex) {
            System.out.println("Error en encriptación");
            Logger.getLogger(LoginJpaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    private static String md5(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0" + Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
        }
    
    
}
