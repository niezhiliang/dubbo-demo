package spring.test.config.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/12 9:31
 */
@Component
public class ScoreMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public boolean updateScore(Integer userId, Integer score) {
        String sql = "update score set score = ? where user_id = ?";
        return jdbcTemplate.update(sql, score, userId) > 0;
    }
}
