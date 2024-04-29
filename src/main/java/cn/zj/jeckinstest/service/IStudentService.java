package cn.zj.jeckinstest.service;


import cn.zj.jeckinstest.common.IBaseService;
import cn.zj.jeckinstest.entity.Student;
import cn.zj.jeckinstest.repository.IStudentRepository;

import java.util.List;

public interface IStudentService extends IBaseService<Student, Long, IStudentRepository> {


}
