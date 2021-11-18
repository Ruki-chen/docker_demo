package com.example.docker_demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @Author cwr
 */
@Transactional
public interface BaseService <T, V, ID extends Serializable> {
    T save(T entity);

    T findOne(ID id);

    T delete(ID id);

    Page<T> findByPage(V example, Pageable pageable);

    List<T> findAll();

    void deleteInBatch(Iterable<T> var1);
}
