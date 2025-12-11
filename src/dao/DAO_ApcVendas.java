/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.ApcClientes;
import bean.ApcVendas;
import bean.ApcVendedor;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author arthu
 */
public class DAO_ApcVendas extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.eq("apc_idPedidos", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();    
        return lista;
    }
    
    public Object listClientes(String cliente) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.like("apcClientes", "%" + cliente + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object listVendedor(String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.ge("apcVendedor", vendedor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listPeriodo(Date dataInicio, Date dataFim) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.between("apcDataPedido", dataInicio, dataFim));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listClientesVendedor(String cliente, String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.like("apcClientes", "%" + cliente + "%"));
        criteria.add(Restrictions.like("apcVendedor", "%" + vendedor + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listClientesPeriodo(String cliente, Date dataInicio, Date dataFim) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.eq("apcClientes", cliente));
        criteria.add(Restrictions.between("apcDataPedido", dataInicio, dataFim));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listVendedorPeriodo(String vendedor, Date dataInicio, Date dataFim) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.eq("apcVendedor", vendedor));
        criteria.add(Restrictions.between("apcDataPedido", dataInicio, dataFim));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }


    public Object listClienteVendedorPeriodo(String cliente, String vendedor, Date dataInicio, Date dataFim) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        criteria.add(Restrictions.eq("apcClientes", cliente));
        criteria.add(Restrictions.eq("apcVendedor", vendedor));
        criteria.add(Restrictions.between("apcDataPedido", dataInicio, dataFim));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ApcVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();    
        return lista;
    }
    
    public boolean hasVendasDoCliente(ApcClientes cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT count(v) FROM ApcVendas v WHERE v.apcClientes = :cliente";
            Long count = (Long) session.createQuery(hql)
                                       .setParameter("cliente", cliente)
                                       .uniqueResult();
            return count > 0;
        } finally {
            session.close();
        }
    }

    
    public static void main(String[] args) {
        DAO_ApcVendas dao_ApcVendas = new DAO_ApcVendas();
        dao_ApcVendas.listAll();
        System.out.println("Deu certo");
    }
    
}