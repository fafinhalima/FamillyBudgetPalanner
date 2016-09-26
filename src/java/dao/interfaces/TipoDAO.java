/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;
import java.util.List;

import beans.TipoEntradaSaida;
/**
 *
 * @author Rafael
 */
public interface TipoDAO {
  /**
    * Este método faz a busca de um usuário no sistema
    * @return Uma Coleção contendo os dados do Tipo de entrada e saida buscados
     * @throws java.lang.Exception
    */
    public List<TipoEntradaSaida> buscaTipo() throws Exception; 
}
