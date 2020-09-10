package db_connect;


import org.springframework.stereotype.Component;

@Component
@Derby
public class DerbyDaoImpl implements Dao {

    @Override
    public void save() {
        System.out.println("Derby is here");
    }
}
