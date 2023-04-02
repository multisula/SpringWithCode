package sp1.sp1.mapper;

import org.apache.ibatis.annotations.*;
import sp1.sp1.domain.BoardVO;
import sp1.sp1.domain.Criteria;

import java.util.List;

public interface BoardMapper {

    // paging
    @Select("SELECT bno, title, content, writer, regdate, updateDate " +
            "FROM ( " +
            "   SELECT /*+INDEX_DESC(tbl_board pk_board) */ " +
            "       ROWNUM rn, bno, title, content, writer, regdate, updateDate " +
            "   FROM tbl_board " +
            "   WHERE ROWNUM <= #{pageNum} * #{amount} ) " +
            "WHERE rn > (#{pageNum} - 1) * #{amount}")
    public List<BoardVO> getListWithPaging(Criteria cri);

    ////////////////////////////////////////////////

    @Select("SELECT * FROM tbl_board WHERE bno > 0")
    public List<BoardVO> getList();

    @Insert("INSERT INTO tbl_board(bno, title, content, writer) " +
            "VALUES(SEQ_BOARD.NEXTVAL, #{title}, #{content}, #{writer})")
    public void insert(BoardVO boardVO);

    @SelectKey(statement = "SELECT SEQ_BOARD.NEXTVAL FROM DUAL",
            keyProperty = "bno", before = true, resultType = Long.class)
    @Insert("INSERT INTO tbl_board(bno, title, content, writer) " +
            "VALUES(#{bno}, #{title}, #{content}, #{writer})")
    public void insertSelectKey(BoardVO boardVO);

    @Select("SELECT * FROM tbl_board WHERE bno = #{bno}")
    public BoardVO read(Long bno);

    @Delete("DELETE FROM tbl_board WHERE bno = #{bno}")
    public int delete(Long bno);

    @Update("UPDATE tbl_board SET " +
            "title = #{title}, " +
            "content = #{content}, " +
            "writer = #{writer}, " +
            "updateDate = SYSDATE " +
            "WHERE bno = #{bno}")
    int update(BoardVO boardVO);
}
