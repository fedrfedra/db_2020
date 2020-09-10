package db_connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DbConnect {

    @Autowired
    private OracleDaoImpl oracleDao;
    @Autowired
    private DerbyDaoImpl derbyDao;

    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        oracleDao.save();
    }

    @Scheduled(fixedDelay = 3000)
    public void doBackup(){
        derbyDao.save();
    }
}
