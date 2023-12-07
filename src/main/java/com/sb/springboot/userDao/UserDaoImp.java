package com.sb.springboot.userDao;

import com.sb.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        List<User> resultList = entityManager.createQuery("select u from User u", User.class).getResultList();
        return resultList;
    }

    public User getOne(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("id"), id));
        User user = entityManager.createQuery(query).getSingleResult();
        return user;
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public void update(User updatedUser, Long id) {
        User needsUpdate = getOne(id);
        needsUpdate.setName(updatedUser.getName());
        needsUpdate.setCell(updatedUser.getCell());
        needsUpdate.setCountry(updatedUser.getCountry());
        needsUpdate.setSalary(updatedUser.getSalary());
        needsUpdate.setDl(updatedUser.getDl());
        entityManager.persist(needsUpdate);
    }
}