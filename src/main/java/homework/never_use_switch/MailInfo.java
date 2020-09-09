package homework.never_use_switch;

import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
public abstract class MailInfo {
    String text;
    String email;
    public abstract String getMailType();

}
