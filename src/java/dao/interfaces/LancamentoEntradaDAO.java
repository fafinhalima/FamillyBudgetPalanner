/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import beans.LacamentoEntrada;

/**
 *
 * @author Rafael
 */
public interface LancamentoEntradaDAO {
     /**
    * Este método insere um lancamento de entrada de receita
     * @param lancamento recebe um lancamento para ser inserido
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean insere(LacamentoEntrada lancamento) throws Exception;
    
     /**
    * Este método faz a remoção de um lançamento de entrada
    * @param lancamento O JavaBean contendo os dados do lancamento a ser removido
    * @return true se a remoção ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean delete(LacamentoEntrada lancamento) throws Exception;
}
