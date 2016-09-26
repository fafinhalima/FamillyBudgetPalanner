/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import beans.Pessoa;

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
}
