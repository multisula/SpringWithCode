package sp1.sp1.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date redgate;
    private Date updateDate;
}