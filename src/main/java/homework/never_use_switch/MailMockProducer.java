package homework.never_use_switch;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

import static heroes.RandomUtil.randomItem;

/**
 * @author Evgeny Borisov
 */
public class MailMockProducer {

    private MailDistributor mailDistributor = new MailDistributor();
    private Faker faker = new Faker();
    private DataFactory dataFactory = new DataFactory();


    @SneakyThrows
    public void sendMailsForever() {
        Reflections scanner = new Reflections("homework.never_use_switch");
        List<Class<? extends MailInfo>> classes = new ArrayList<>(scanner.getSubTypesOf(MailInfo.class));
        while (true) {
            MailInfo mailInfo = randomItem(classes).getDeclaredConstructor(String.class, String.class)
                    .newInstance(faker.chuckNorris().fact(), dataFactory.getEmailAddress());
            try {
                mailDistributor.sendMailInfo(mailInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        new MailMockProducer().sendMailsForever();
    }
}






