package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findByName(String name) {
        Role role = (Role) entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name")
                .setParameter("name", name).getSingleResult();
        return role;
    }

    @Override
    public Role save(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class)
                .getResultList();
    }
}
