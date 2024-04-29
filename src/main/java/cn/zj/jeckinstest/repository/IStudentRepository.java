package cn.zj.jeckinstest.repository;

import cn.zj.jeckinstest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
