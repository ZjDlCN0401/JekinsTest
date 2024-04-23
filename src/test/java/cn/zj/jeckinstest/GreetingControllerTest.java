package cn.zj.jeckinstest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GreetingControllerTest {

  @Test
  void greeting() {
    Assertions.assertThat(2).isEqualTo(1);
  }
}