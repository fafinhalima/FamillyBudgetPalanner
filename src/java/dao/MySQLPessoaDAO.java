/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.PessoaDAO;
import beans.Pessoa;
/**
 *
 * @author Rafael
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class MySQLPessoaDAO implements PessoaDAO{
   
    private Session session;
    
    
    /**
    * Este método insere um usuario 
    * @param usuario O JavaBean contendo os dados do usuario a ser inserido
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean insere(Pessoa pessoa) throws Exception
    {
      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx;
       tx = null;
      try
      {
        tx = session.beginTransaction();
        session.save(pessoa);
        tx.commit();
        return true;
      }
      catch(HibernateException ex)
      {
            System.err.println("Erro: " + ex.getMessage());

      }
      finally
      {
        session.close();
      }
      return false;
    }
}
