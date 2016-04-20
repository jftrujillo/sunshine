/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import boundary.UsuarioFacade;
import entities.Usuario;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author jhon
 */
@Named(value = "ususariosPresentacion")
@Dependent
public class UsusariosPresentacion {

    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario;
    

    /**
     * Creates a new instance of UsusariosPresentacion
     */
    public UsusariosPresentacion() {
        this.usuario =  new Usuario();
    }
    
    public List<String> columNames (){
    List<String> columns = new ArrayList<>();
    Field propiedades[] = Usuario.class.getFields();
    for (int i = 0 ; i < 2; i++){
    columns.add (propiedades[i].getName());
    }
    return columns;
    }
    
}
