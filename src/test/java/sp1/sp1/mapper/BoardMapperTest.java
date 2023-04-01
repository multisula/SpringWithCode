package sp1.sp1.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sp1.sp1.config.RootConfig;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j2
class BoardMapperTest {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(board -> log.info(board));
    }
}