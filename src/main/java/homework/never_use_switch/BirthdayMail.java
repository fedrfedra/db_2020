package homework.never_use_switch;

public class BirthdayMail extends MailInfo {

    public BirthdayMail(String text, String email){
        this.text = text;
        this.email = email;
    }

    @Override
    public String getMailType(){
        return "Happy Birthday " + getText() + " was sent to" + getEmail();
    }
}
