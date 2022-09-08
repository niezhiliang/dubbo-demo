package spring.test.config.transaction;

import java.io.FileNotFoundException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 20:14
 */
@Component
public class UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ScoreMapper scoreMapper;

    @Transactional
    public void updateUser() {
        String sql = "update user set age = ? where id = ?";
        jdbcTemplate.update(sql, new Random().nextInt(30), 1);
    }

    @Transactional(readOnly = true)
    public void updateUserAndScore(Integer userId, Integer score) throws FileNotFoundException {
        // new FileReader("c://sdfaf.h");
        // String sql = "update user set age = ? where id = ?";
        // jdbcTemplate.update(sql, new Random().nextInt(30), userId);
        try {

            String sql = "select *  from user";
            jdbcTemplate.queryForList(sql);
        } finally {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        // scoreMapper.updateScore(userId, score);
    }

    public void noTransaction() {
        System.out.println("--------");
    }
}
