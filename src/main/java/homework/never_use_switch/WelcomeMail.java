package homework.never_use_switch;

public class WelcomeMail extends MailInfo{

    public WelcomeMail(String text, String email){
        this.text = text;
        this.email = email;
    }

    @Override
    public String constructMail(){
        return "WELCOME " + getText() + " was sent to" + getEmail();
    }

}
