package demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("demo")
public class DemoProperties {

  String greeting;

  boolean ha;
}
