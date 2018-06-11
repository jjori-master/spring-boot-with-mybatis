package mybatis.dao;

import mybatis.model.Question;
import mybatis.model.filter.QuestionFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionDao {
    /**
     * TIP - mybatis 특성상 1개의 파라미터는 @Param 어노테이션을 이용해 파라미터 이름을 선언할 필요는 없다.
     */
    Question findById(@Param("id") long id);

    int getQuestionTotCount(QuestionFilter filter);
    Question[] getQuestions(QuestionFilter filter);

    void saveQuestion(Question question);
}
