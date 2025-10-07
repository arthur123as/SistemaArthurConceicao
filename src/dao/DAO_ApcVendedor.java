/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.ApcVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author arthu
 */
public class DAO_ApcVendedor extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(ApcVendedor.class);
        criteria.add(Restrictions.eq("apc_idVendedor", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();    
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();    
        return lista;
    }
    
    public static void main(String[] args) {
        DAO_ApcVendedor dao_ApcVendedor = new DAO_ApcVendedor();
        dao_ApcVendedor.listAll();
        System.out.println("Deu certo");
    }
    
}
