package mybatis.repository;

import mybatis.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionRepositoy {
    Question findById(@Param("id") long id);
}
