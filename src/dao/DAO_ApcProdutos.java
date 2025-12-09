/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.ApcProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author arthu
 */
public class DAO_ApcProdutos extends DAO_Abstract{

    @Override
    public void insert(Object objeto) {
        session.beginTransaction();
        session.save(objeto);
        session.getTransaction().commit();

    }

    @Override
    public void update(Object objeto) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(objeto);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object objeto) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(objeto);
        session.getTransaction().commit();    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcProdutos.class);
        criteria.add(Restrictions.eq("apc_idProdutos", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();    
        return lista;
    }
    
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcProdutos.class);
        criteria.add(Restrictions.like("apcNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object listValor(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcProdutos.class);
        criteria.add(Restrictions.ge("apcPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNomeValor(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcProdutos.class);
        criteria.add(Restrictions.like("apcNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("apcPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();    
        return lista;
    }
    
    public static void main(String[] args) {
        DAO_ApcProdutos dao_ApcProdutos = new DAO_ApcProdutos();
        dao_ApcProdutos.listAll();
        System.out.println("Deu certo");
    }
    
}
