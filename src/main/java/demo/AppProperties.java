package demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("myapp")
public class AppProperties {

  String greeting;

  boolean ha;
}
