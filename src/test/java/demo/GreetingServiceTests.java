package demo;

import demo.greetings.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
public class GreetingServiceTests {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void shouldShowDefaultGreeting() {

        String greeting = greetingService.greet("Tom");

        assertThat(greeting).isEqualTo("Hello Tom");
    }
}
