package mybatis.model.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
class BaseFilter {
    private int offset;
    private int limit;
    private String searchType;
    private String searchText;
}
