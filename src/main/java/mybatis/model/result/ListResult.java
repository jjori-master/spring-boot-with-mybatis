package mybatis.model.result;

import java.util.ArrayList;
import java.util.List;

public class ListResult<T> {
    public List<T> list = new ArrayList<>();

    ListResult() {
    }

    @SuppressWarnings("unused")
    public ListResult(List<T> array) {
        list.addAll(array);
    }
}