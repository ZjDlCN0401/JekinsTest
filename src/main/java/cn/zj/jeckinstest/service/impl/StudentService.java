package cn.zj.jeckinstest.service.impl;

import cn.zj.jeckinstest.entity.Student;
import cn.zj.jeckinstest.repository.IStudentRepository;
import cn.zj.jeckinstest.service.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

  private final IStudentRepository studentRepository;

  public StudentService(IStudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public Student findOne(Long id) {
    return studentRepository.findById(id).orElse(null);
  }

  @Transactional
  @Override
  public Student save(Student entity) {
    return studentRepository.save(entity);
  }

  @Transactional
  @Override
  public List<Student> save(List<Student> students ) {
    return studentRepository.saveAll(students);
  }

  @Transactional
  @Override
  public void delete(Long id) {
    studentRepository.deleteById(id);
  }

  @Transactional
  @Override
  public void delete(Student entity) {
    studentRepository.delete(entity);
  }

  @Transactional
  @Override
  public void update(Student entity) {
    studentRepository.save(entity);
  }
}
