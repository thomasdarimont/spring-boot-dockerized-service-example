package demo;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
class GreetingController {

  private final Environment env;

//  private final GitProperties gitProperties;

//  private final BuildProperties buildProperties;

  private final DemoProperties demoProperties;

  @GetMapping("/")
  Object greet(@RequestParam(defaultValue = "World") String name) {
    Map<String, Object> m = new LinkedHashMap<>();
    m.put("greeting", String.format("%s %s", demoProperties.getGreeting(), name));
    m.put("time", LocalDateTime.now());
//    m.put("commit", gitProperties.getShortCommitId());
//    m.put("commitTime", gitProperties.getCommitTime());
//    m.put("commitMessage", gitProperties.get("commit.message.short"));
    m.put("active_profiles", Arrays.toString(env.getActiveProfiles()));
//    m.put("version", buildProperties.getVersion());
    m.put("ha", demoProperties.isHa());
    return m;
  }
}
