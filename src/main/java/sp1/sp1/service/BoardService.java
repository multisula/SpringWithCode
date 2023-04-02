package sp1.sp1.service;

import sp1.sp1.domain.BoardVO;
import sp1.sp1.domain.Criteria;

import java.util.List;

public interface BoardService {
    public void register(BoardVO boardVO);
    public BoardVO get(Long bno);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long bno);
    public List<BoardVO> getList();
    public List<BoardVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
}
