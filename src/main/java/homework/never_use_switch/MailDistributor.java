package homework.never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class MailDistributor {

    public void sendMailInfo(MailInfo mailInfo) {
        System.out.println(mailInfo.constructMail());
    }
}

