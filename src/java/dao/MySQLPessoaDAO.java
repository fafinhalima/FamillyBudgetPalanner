/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.PessoaDAO;
import beans.Pessoa;
import beans.UsuarioBean;
import java.util.List;
/**
 *
 * @author Rafael
 */
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class MySQLPessoaDAO implements PessoaDAO{
   
    private Session session;
    List<Pessoa> lista =null;
    
    /**
    * Este método insere uma pessoa 
    * @param pessoa O JavaBean contendo os dados de pessoa a ser inserida
    * @return true se inserir ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    @Override
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
    /**
    * Este método faz a busca de uma pessoa no sistema
     * @param usuario
    * @return Um JavaBean Pessoa contendo os dados da pessoa a ser buscada
     * @throws java.lang.Exception
    */
    public List<Pessoa>  buscarLista(UsuarioBean usuario) throws Exception
    {
        if(usuario == null)
            throw new Exception("O parâmetro é nulo");
       
      session = MySQLOrcamentoDAOFactory.getInstance();
      Query q = session.createQuery("select p from Pessoa p where p.loginUsuario.login = ? ");
      q.setString(0, usuario.getLogin());
     
      List l = q.list();
      if (!l.isEmpty())
      {
         lista = (List<Pessoa>)q.list();
        return lista;
      }
        return null;
    }
    /**
    * Este método faz a remoção de uma pessoa
    * @param pessoa O JavaBean contendo os dados da pessoa a ser removida
    * @return true se a remoção ocorrer com sucesso e false caso contrário
     * @throws java.lang.Exception
    */
    @Override
    public boolean delete(Pessoa pessoa) throws Exception
    {
        if(pessoa == null)
        throw new Exception("O parâmetro é nulo");

      session = MySQLOrcamentoDAOFactory.getInstance();
      Transaction tx = null;
      try
      {
        tx = session.beginTransaction();
        session.delete(pessoa);
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
