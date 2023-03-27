package sp1.sp1.persistence.persistence;

import demo.ex00.config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j2
public class DataSourceTests {
    @Setter(onMethod_ = @Autowired)
    private DataSource dataSource;

    @Setter(onMethod_ = @Autowired)
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try(Connection con = dataSource.getConnection()){
            log.info(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMyBatis() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection();) {
            log.info(session);
            log.info(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}
