package mybatis.model.result;

@SuppressWarnings("unused")
public class PageableListResult<T> extends ListResult<T> {

    public PageableListResult() {
    }

    public PageableListResult(int offset, int limit, int totCnt) {
        page = new Page(offset, limit, totCnt);
    }

    public PageableListResult(int offset, int limit, int totCnt, int pageLimit) {
        page = new Page(offset, limit, totCnt, pageLimit);
    }

    private Page page;
}