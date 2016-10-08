/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.LacamentoEntrada;
import dao.interfaces.LancamentoEntradaDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rafael
 */
public class MySQLLancamentoEntradaDAO implements LancamentoEntradaDAO {
    
    private Session session;
    
    
   /**
    * Este método insere um lancamento de entrada de receita
     * @param lancamento recebe um lancamento para ser inserido
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean insere(LacamentoEntrada lancamento) throws Exception
    {
      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx;
       tx = null;
      try
      {
        tx = session.beginTransaction();
        session.save(lancamento);
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
     /**
    * Este método faz a remoção de um lançamento de entrada
    * @param lancamento O JavaBean contendo os dados do lancamento a ser removido
    * @return true se a remoção ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    public boolean delete(LacamentoEntrada lancamento) throws Exception
    {
        if(lancamento == null)
        throw new Exception("O parâmetro é nulo");

      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx = null;
      try
      {
        tx = session.beginTransaction();
        session.delete(lancamento);
        tx.commit();
        return true;
      }
      catch(HibernateException ex)
      {
        ex.printStackTrace();
        tx.rollback(); //Desfaz a operação de remoção
      }
      finally
      {
        session.close();
      }
      return false;
    }
}
