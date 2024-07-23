package com.douglas.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class BaseJPA<T, ID> implements BaseRepository<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> domainClass;

    public BaseJPA(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    @Override
    @Transactional
    public T findById(ID id) {
        return entityManager.find(domainClass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + domainClass.getName(), domainClass).getResultList();
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;

    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(ID id) {
        T entity = entityManager.find(domainClass, id);
        if (entity != null) {
            delete(entity);
        }
    }

}
