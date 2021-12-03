package com.example.docker_demo.service.impl;

import com.example.docker_demo.repository.BaseRepository;
import com.example.docker_demo.service.BaseService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.*;

public abstract class BaseServiceImpl<T, V, ID extends Serializable> implements BaseService<T, V, ID> {

    protected abstract BaseRepository<T, ID> currentJpaRepository();

    @Override
    public T save(T entity) {
        return this.currentJpaRepository().save(entity);
    }

    @Override
    public T findOne(ID id) {
        Optional<T> byId = this.currentJpaRepository().findById(id);
        T t = byId.get();
        return  t;
    }

    @Override
    public T delete(ID id) {
        T entity = this.findOne(id);
        if (null != entity) {
            this.currentJpaRepository().delete(entity);
        }
        return entity;
    }

    @Override
    public Page<T> findByPage(V example, Pageable pageable) {
        return currentJpaRepository().findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        List<T> list = currentJpaRepository().findAll();
        if (null == list) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public void deleteInBatch(Iterable<T> var1) {
        this.currentJpaRepository().deleteInBatch(var1);
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}