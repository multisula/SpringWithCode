package sp1.sp1.mapper;

import org.apache.ibatis.annotations.Select;
import sp1.sp1.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();
}
