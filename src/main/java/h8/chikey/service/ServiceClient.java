package h8.chikey.service;

import h8.chikey.dao.DAO;
import h8.chikey.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceClient implements DAO<Client,Integer> {


    public ServiceClient(SessionFactory factory) {
        this.factory=factory;
    }
    SessionFactory factory;

    @Override
    public void create(Client client) {
        try(Session sess = factory.openSession()){
            sess.beginTransaction();
            sess.save(client);
            sess.getTransaction().commit();
        }
    }

    @Override
    public Client read(Integer integer) {
        try(Session sess = factory.openSession()){
            return sess.get(Client.class , integer);
        }
    }

    @Override
    public void delete(Client client) {
        try(Session sess = factory.openSession()){
            sess.beginTransaction();
            sess.delete(client);
            sess.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) {
        try(Session sess = factory.openSession()){
            sess.beginTransaction();
            sess.update(client);
            sess.getTransaction().commit();
        }
    }

    @Override
    public List<Client> reedALL() {
        try(Session sess = factory.openSession()) {
            String hql = "FROM Client";
            Query<Client> query = sess.createQuery(hql);
            List<Client> list = query.list();
            return list;
        }
    }
}
