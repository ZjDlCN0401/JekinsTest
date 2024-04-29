package cn.zj.jeckinstest.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBaseService<T, ID extends Comparable<ID>,R extends JpaRepository<T, ID >> {

  List<T> findAll();

  T findOne(ID id);

  T save(T entity);

  List<T> save(List<T> entity);

  void delete(ID id);

  void delete(T entity);

  void update(T entity);

}
