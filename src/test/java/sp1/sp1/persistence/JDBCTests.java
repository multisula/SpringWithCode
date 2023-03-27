package sp1.sp1.persistence.persistence;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class JDBCTests {

    static{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testConnection() {
        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:oracle:thin:@192.168.0.7:15121/orclpdb",
                            "sula",
                            "1234")){
            log.info(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
