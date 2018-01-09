package demo.greetings;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
class GreetingController {

  private final Environment env;

  private final GreetingService greetingService;

  @GetMapping("/")
  Object greet(@RequestParam(defaultValue = "World") String name) {

    Map<String, Object> m = new LinkedHashMap<>();
    m.put("greeting", greetingService.greet(name));

    m.put("time", LocalDateTime.now());

    return m;
  }
}
