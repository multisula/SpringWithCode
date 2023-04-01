package sp1.sp1.service;

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

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
class BoardServiceTest {

    @Setter(onMethod_ = @Autowired)
    private BoardService boardService;

    @Test
    public void testExist(){
        log.info(boardService);
        assertNotNull(boardService);
    }

    @Test
    void testRegister() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");

        boardService.register(boardVO);

        log.info("생성된 게시물의 번호: " + boardVO.getBno());
    }

    @Test
    void testGet() {
        log.info(boardService.get(47L));
    }

    @Test
    void testModify() {
        BoardVO boardVO = boardService.get(47L);
        if(boardVO == null){
            return;
        }

        boardVO.setTitle("제목 수정합니다.");
        log.info("MODIFY RESULT: " + boardService.modify(boardVO));
    }

    @Test
    void testRemove() {
        log.info("REMOVE RESULT: " + boardService.remove(47L));
    }

    @Test
    void testGetList() {
        boardService.getList().forEach(boardVO -> log.info(boardVO));
    }
}