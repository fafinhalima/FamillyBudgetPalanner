package dao.interfaces;

import beans.UsuarioBean;

/**
 * Esta interface define os métodos utilizados na
 * manipulação de dados de usuários.
 */
public interface UsuarioDAO
{
   /**
    * Este método faz a busca de um usuário no sistema
    * @param usuario O JavaBean contendo os dados de busca (login) do usuário
    * @return Um JavaBean UsuarioBean contendo os dados do usuário buscado
     * @throws java.lang.Exception
    */
    public UsuarioBean buscarUsuario(UsuarioBean usuario) throws Exception;
    
    /**
    * Este método insere um usuario 
    * @param usuario O JavaBean contendo os dados do usuario a ser inserido
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean insere(UsuarioBean usuario) throws Exception;
    
}

