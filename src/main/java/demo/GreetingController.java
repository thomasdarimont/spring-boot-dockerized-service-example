package demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
class GreetingController {

  private final GitProperties gitProperties;

  @GetMapping("/")
  Object greet(@RequestParam(defaultValue = "World") String name) {
    Map<String, Object> m = new LinkedHashMap<>();
    m.put("greeting", "Hello " + name);
    m.put("time", LocalDateTime.now());
    m.put("commit", gitProperties.getShortCommitId());
    m.put("commitTime", gitProperties.getCommitTime());
    return m;
  }
}
