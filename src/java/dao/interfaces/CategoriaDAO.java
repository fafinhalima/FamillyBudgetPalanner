package dao.interfaces;

import beans.CategoriaBean;

/**
 * Esta interface define os métodos utilizados na
 * manipulação de dados de contatos.
 */
public interface CategoriaDAO
{
   /**
    * Este método faz a remoção de uma Cateogoria
    * @param categoria O JavaBean contendo os dados da categoria a ser removida
    * @return true se a remoção ocorrer com sucesso e false caso contrário
    */
    public boolean delete(CategoriaBean contato) throws Exception;
    
}

