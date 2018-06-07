package mybatis.service;

import mybatis.repository.QuestionRepositoy;
import mybatis.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private QuestionRepositoy questionRepositoy;

    Question findById(long id) {
        return questionRepositoy.findById(id);
    }
}
