package hiber.service;

import hiber.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserOnTheCar(String model, Integer series);
}
