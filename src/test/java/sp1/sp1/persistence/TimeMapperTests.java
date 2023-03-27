package sp1.sp1.persistence;

import demo.ex00.config.RootConfig;
import demo.ex00.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j2

public class TimeMapperTests {
    @Setter(onMethod_ = @Autowired)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime(){
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTiem());
    }
}
