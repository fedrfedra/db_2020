package real_spring.db_connect;

import org.springframework.stereotype.Component;

@Component
@Oracle
public class OracleDaoImpl implements Dao {

    @Override
    public void save() {
        System.out.println("Oracle is here");
    }
}
