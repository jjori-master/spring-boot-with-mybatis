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
public class Question {
    private long id;
    private String title;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    private Answer[] answers;

    private User writer;

    public Question() {}

    public Question(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Question(long id, String title, String contents) {
        this(title, contents);
        this.id = id;
    }
}
