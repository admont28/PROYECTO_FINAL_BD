/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Beans.util.PaginationHelper;
import Controller.AreaJpaController;
import Controller.LoginJpaController;
import Entities.Area;
import Entities.Auxiliar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.persistence.Persistence;

/**
 *
 * @author DavidMontoya
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private String id;
    private String password;
    private boolean autenticado=false;
    
    private DataModel items = null;
    private LoginJpaController jpaController = null;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    /**
    * Metodo que me permite ejecutar la accion del inicio de sesion de los usuarios de la empresa.
    * @return retorna el rol de la persona si existe, de lo contrario retorna un string vacio.
    */ 
    public String login(){
       Object login = getJpaController().validacionLogin(id, password);
       if(login instanceof Auxiliar){
           return "index";
       }
       return "/login";
    }

    public LoginJpaController getJpaController() {
        if(jpaController == null)
            jpaController = new LoginJpaController(Persistence.createEntityManagerFactory("GestionAuxPU"));
        return jpaController;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataModel getItems() {
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }

    public PaginationHelper getPagination() {
        return pagination;
    }

    public void setPagination(PaginationHelper pagination) {
        this.pagination = pagination;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
    
    
    
}
