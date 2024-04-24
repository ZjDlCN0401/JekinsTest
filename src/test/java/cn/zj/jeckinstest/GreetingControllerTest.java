package cn.zj.jeckinstest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GreetingControllerTest {

  @Test
  void greeting() {
    Assertions.assertThat(1).isEqualTo(1);
  }
  
  @Test
  void greeting2() {
    Assertions.assertThat(1).isEqualTo(1);
  }
  
  @Test
  void greeting3() {
    Assertions.assertThat(3).isEqualTo(1);
  }
}