package mybatis.dao;

import mybatis.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AnswerDao {
    Answer[] getAnswersByQuestionId(@Param("questionId") long id);
}
