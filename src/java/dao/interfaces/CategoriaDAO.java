package dao.interfaces;

import beans.CategoriaBean;
import beans.UsuarioBean;
import java.util.List;

/**
 * Esta interface define os métodos utilizados na
 * manipulação de dados de contatos.
 */
public interface CategoriaDAO
{
      /**
    * Este método faz a remoção de uma Cateogoria
    * @param categoria O JavaBean contendo os dados da categoria a ser inserida
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
 
    public boolean insere(CategoriaBean categoria) throws Exception;
   /**
    * Este método faz a remoção de uma Cateogoria
    * @param categoria O JavaBean contendo os dados da categoria a ser removida
    * @return true se a remoção ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean delete(CategoriaBean categoria) throws Exception;
   /**
    * Este método faz a busca de uma categoria no sistema
     * @param usuario
    * @return Um JavaBean Pessoa contendo os dados da categoria a ser buscada
     * @throws java.lang.Exception
    */
    public List<CategoriaBean>  buscarLista(UsuarioBean usuario) throws Exception;
    
}

