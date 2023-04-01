package sp1.sp1.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sp1.sp1.config.RootConfig;
import sp1.sp1.domain.BoardVO;

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

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");

        mapper.insert(boardVO);

        log.info(boardVO);
    }

    @Test
    public void testInsertSelectKey(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글 select key");
        boardVO.setContent("새로 작성하는 내용 select key");
        boardVO.setWriter("newbie");

        mapper.insertSelectKey(boardVO);

        log.info(boardVO);
    }

    @Test
    public void testRead() {
        BoardVO boardVO = mapper.read(63L);

        log.info(boardVO);
    }

    @Test
    public void testDelete() {
        log.info("DELETE COUNT: " + mapper.delete(63L));
    }

    @Test
    public void testUpdate(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(64L);
        boardVO.setTitle("수정된 제목");
        boardVO.setContent("수정된 내용");
        boardVO.setWriter("user00");

        int count = mapper.update(boardVO);

        log.info("UPDATE COUNT: " + count);
    }
}