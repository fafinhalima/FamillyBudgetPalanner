/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import beans.Pessoa;
import beans.UsuarioBean;
import java.util.List;

/**
 *
 * @author Rafael
 */
public interface PessoaDAO {
    /**
    * Este método insere um usuario 
    * @param pessoa O JavaBean contendo os dados da pessoa a ser inserida
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean insere(Pessoa pessoa) throws Exception;
    /**
    * Este método faz a busca de uma pessoa no sistema
     * @param usuario
    * @return Um JavaBean Pessoa contendo os dados da pessoa a ser buscada
     * @throws java.lang.Exception
    */
    public List<Pessoa>  buscarLista(UsuarioBean usuario) throws Exception;
    
    /**
    * Este método faz a remoção de uma pessoa
    * @param pessoa O JavaBean contendo os dados da pessoa a ser removida
    * @return true se a remoção ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean delete(Pessoa pessoa) throws Exception;
}
