package demo.greetings;

import demo.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGreetingService implements GreetingService{

    private final AppProperties appProperties;

    @Override
    public String greet(String name) {
        return String.format("%s %s", appProperties.getGreeting(), name);
    }
}
