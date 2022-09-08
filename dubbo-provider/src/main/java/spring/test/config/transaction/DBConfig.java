package spring.test.config.transaction;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 20:16
 */
@Component
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "spring.test.config.transaction")
public class DBConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassname;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DruidDataSource data = new DruidDataSource();
        data.setDriverClassName(driverClassname);
        data.setUrl(url);
        data.setUsername(username);
        data.setPassword(password);
        return data;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
