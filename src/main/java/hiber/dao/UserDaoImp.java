package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
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
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserOnTheCar(String model, Integer series) {
      return (User) sessionFactory
              .getCurrentSession()
//              .createQuery("FROM User user WHERE user.car.model = '" + model + "'"
//                      + "AND user.car.series = " + series)
              .createQuery("select * from User where User.car.model= '" + model +
                      "' AND User.car.series = '" + series + "'")
              .getSingleResult();
   }
}
