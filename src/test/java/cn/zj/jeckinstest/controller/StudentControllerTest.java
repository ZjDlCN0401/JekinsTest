package cn.zj.jeckinstest.controller;

import cn.zj.jeckinstest.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private ObjectMapper mapper = new ObjectMapper();

  @Test
  @Order(2)
  void findAll() throws Exception {

    // TODO: write test cases for findAll()
    mockMvc.perform(get("/student").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("Bob123"))
            .andExpect(jsonPath("$",hasSize(4)))
            .andDo(print());
  }


  @Test
  @Order(0)
  void create() throws Exception {
    // TODO: write test cases for create()
    mockMvc.perform(post("/student")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content("{\"name\":\"Bob\",\"age\":20}"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
  }


  @Test
  @Order(1)
  void testCreate() throws Exception {
    // TODO: write test cases for testCreate()
    mockMvc.perform(post("/student/many")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content("[{\"name\":\"Alice\",\"age\":21},{\"name\":\"Bob1\",\"age\":22},{\"name\":\"Bob2\",\"age\":23}]"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
  }


  @Test
  @Order(4)
  void deleteMethod() throws Exception {
    // TODO: write test cases for delete()
    mockMvc.perform(delete("/student/1")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andDo(print());

    // TODO: write test cases for getAll and check size
    mockMvc.perform(get("/student")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$",hasSize(3)))
            .andDo(print());

  }


  @Test
  @Order(3)
  void update() throws Exception,JsonProcessingException {
    // TODO: write test cases for update()
    Student student = new Student();
    student.setId(4L);
    student.setName("Bob_updated");
    student.setAge((short)30);

    mockMvc.perform(put("/student")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(mapper.writeValueAsString(student)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print());

    mockMvc.perform(get("/student/4")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(4))
            .andExpect(jsonPath("$.name").value("Bob_updated"))
            .andExpect(jsonPath("$.age").value(30))
            .andDo(print());
  }
}