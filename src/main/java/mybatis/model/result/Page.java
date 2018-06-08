package mybatis.model.result;

import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("unused")
@Getter
@ToString
public class Page {
    private final static int DEFAULT_OFFSET = 0;
    private final static int DEFAULT_LIST_LIMIT = 10;
    private final static int DEFAULT_PAGE_LIMIT = 5;

    private int totCnt;
    private int totPageCnt;
    private int pageStart;
    private int pageEnd;
    private int currentPage;
    private int pageLimit;
    private int listLimit;

    public Page(int offset, int totCnt) {
        this.setPage(offset, DEFAULT_LIST_LIMIT, totCnt, DEFAULT_PAGE_LIMIT);
    }

    Page(int offset, int limit, int totCnt) {
        this.setPage(offset, limit, totCnt, DEFAULT_PAGE_LIMIT);
    }

    Page(int offset, int limit, int totCnt, int pageLimit) {
        this.setPage(offset, limit, totCnt, pageLimit);
    }

    private void setPage(int offset, int limit, int totCnt, int pageLimit) {
        this.totCnt = totCnt;
        this.listLimit = limit == -1 ? this.totCnt : limit;
        this.pageLimit = pageLimit;
        this.currentPage = totCnt == 0 ? 1 : (offset / this.listLimit) + 1;
        this.totPageCnt = totCnt == 0 ? 1 : (totCnt / this.listLimit) + ((totCnt % this.listLimit) >= 1 ? 1 : 0);
        this.pageStart = (this.currentPage - 1) / this.pageLimit * this.pageLimit + 1;
        this.pageEnd = this.pageStart + this.pageLimit - 1;
        this.pageEnd = this.pageEnd > this.totPageCnt ? this.totPageCnt : this.pageEnd;
    }
}
