package mybatis.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Answer {
    private String contents;
    private String userName;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
