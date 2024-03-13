package hiber.dao;

import hiber.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public User getUserByCar(String model, int series) {
        String hql = "select car.user from Car car where model = :nameParameter and series = :seriesParameter";
        Query query = sessionFactory.getCurrentSession()
                .createQuery(hql);
        query.setParameter("nameParameter", model);
        query.setParameter("seriesParameter", series);
        List<User> list = query.getResultList();
        return list.size() == 0 ? null : list.get(0);
    }
}

