package mybatis.model.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionFilter extends BaseFilter {
    private String title;
    private String contests;
}
