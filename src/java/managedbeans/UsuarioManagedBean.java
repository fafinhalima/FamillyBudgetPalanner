/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import beans.Usuario;
import dao.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Rafael
 */
@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

       private  Usuario usuario = new Usuario();
    private List<Usuario> listaUsusarios;

    public List<Usuario> getListaUsusarios() {
        listaUsusarios = UsuarioDAO.list();
        return listaUsusarios;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   public void prepararAlterarUsuario(Usuario usuario){
        this.usuario = usuario;
    }
   
   public void prepararExcluirUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void excluirUsuario(){
        UsuarioDAO.delete(usuario);
        this.usuario = new Usuario();
    }
    
    public void adicionarUsuario(){
       UsuarioDAO.create(usuario);
       this.usuario = new Usuario();
    }
    
    public void alterarUsuario(){
       UsuarioDAO.update(usuario);
       this.usuario = new Usuario();
    }
}

