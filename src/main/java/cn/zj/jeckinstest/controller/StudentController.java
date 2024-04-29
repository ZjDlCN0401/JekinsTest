package cn.zj.jeckinstest.controller;

import cn.zj.jeckinstest.entity.Student;
import cn.zj.jeckinstest.service.IStudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  // 注入IStudentService
  private final IStudentService studentService;

  public StudentController(IStudentService studentService)
  {
    this.studentService = studentService;
  }

  // 查询所有学生
  @GetMapping()
  public List<Student> findAll()
  {
    return studentService.findAll();
  }

  // 查询学生
  @GetMapping("/{id}")
  public Student findById(@PathVariable Long id)
  {
    return studentService.findOne(id);
  }

  // 创建学生
  @PostMapping("")
  public Student create(@RequestBody Student student)
  {
    return studentService.save(student);
  }


  @PostMapping("/many")
  public List<Student> create(@RequestBody List<Student> students)
  {
    return studentService.save(students);
  }

  // 删除学生
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id)
  {
    studentService.delete(id);
  }

  // 更新学生
  @PutMapping()
  public Student update(@RequestBody Student student)
  {
    studentService.update(student);
    return student;
  }

}
