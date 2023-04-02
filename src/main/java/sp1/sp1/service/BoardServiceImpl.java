package sp1.sp1.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp1.sp1.domain.BoardVO;
import sp1.sp1.domain.Criteria;
import sp1.sp1.mapper.BoardMapper;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

//    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

    @Override
    public void register(BoardVO boardVO) {
        log.info("=====> Service - register " + boardVO);
        boardMapper.insertSelectKey(boardVO);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("=====> Service - get: " + bno);
        return boardMapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        log.info("=====> Service - modify: " + boardVO);
        return boardMapper.update(boardVO) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("=====> Service - remove: " + bno);
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        log.info("=====> Service - getList");
        return boardMapper.getList();
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("=====> Service - getList with criteria: " + criteria);
        return boardMapper.getListWithPaging(criteria);
    }

    @Override
    public int getTotal(Criteria criteria) {
        log.info("=====> Service - getTotal count");
        return boardMapper.getTotalCount(criteria);
    }
}
