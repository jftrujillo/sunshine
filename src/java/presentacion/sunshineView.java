/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import boundary.UsuarioFacade;
import entities.Host;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author jhon
 */
@Named(value = "sunshineView")
@Dependent
public class sunshineView {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    private Usuario usuario;
    
     
    
    /**
     * Creates a new instance of sunshineView
     */
    public sunshineView() {
        this.usuario = new Usuario();
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
   
      
      public int getTotalUsers(){
      return usuarioFacade.findAll().size();
      }
      
      public List<Usuario> getNameUsers(){
          List<Usuario> nameUsers = new ArrayList<>();
          nameUsers = usuarioFacade.findAll();
          return nameUsers;
         
      }
      
      public String getPassUser(){
      
          return usuarioFacade.find(2).getContraseña();
      }
      
      public Boolean  createNewUser(){
          return null;
      }
      
      
    
}
