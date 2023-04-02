package sp1.sp1.mapper;

import org.apache.ibatis.annotations.*;
import sp1.sp1.domain.BoardVO;
import sp1.sp1.domain.Criteria;

import java.util.List;

public interface BoardMapper {

    // paging
    public List<BoardVO> getListWithPaging(Criteria criteria);
    public int getTotalCount(Criteria criteria);

    ////////////////////////////////////////////////

    public List<BoardVO> getList();
    public void insert(BoardVO boardVO);
    public void insertSelectKey(BoardVO boardVO);
    public BoardVO read(Long bno);
    public int delete(Long bno);
    int update(BoardVO boardVO);
}
