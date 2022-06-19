package com.arseniisemenov.hibernateapp.dao;

import com.arseniisemenov.hibernateapp.models.City;
import com.arseniisemenov.hibernateapp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDao {
    public City findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    public void save(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(city);
        tx1.commit();
        session.close();
    }

    public void update(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(city);
        tx1.commit();
        session.close();
    }

    public void delete(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(city);
        tx1.commit();
        session.close();
    }

    public List<City> findAll() {
        List<City> cities = (List<City>)HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM City").list();
        return cities;
    }

    public List<City> searchCities(String name, Integer citizens, String story) {
        System.out.println("NAME: " + name);
        String query = "FROM City WHERE name LIKE '%' || ? || '%' AND citizens > ? AND story LIKE '%' || ? || '%'";

        List<City> cities = (List<City>)HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery(query)
                .setParameter(0, (name != null) ? name : "")
                .setParameter(1, (citizens != null) ? citizens : 0)
                .setParameter(2, (story != null) ? story : "")
                .list();
        return cities;
    }
}
