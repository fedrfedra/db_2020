package real_spring.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class TerminatorQuoter implements Quoter {

    @Value("${terminator}")
    private List<String> messages;


    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

    @PostConstruct
    public void init() {
        System.out.println("Мне нужна твоя одежду, ботинки и мотоцикл");
    }

    @PreDestroy
    public void killAll() {
        System.out.println("you are terminated...");
    }


}



