package mybatis.service;

import mybatis.dao.AnswerDao;
import mybatis.dao.QuestionDao;
import mybatis.model.Answer;
import mybatis.model.Question;
import mybatis.model.filter.QuestionFilter;
import mybatis.model.result.PageableListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QnaService {
    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    Question getQuestionDetail(@SuppressWarnings("SameParameterValue") long id) {
        Question question = questionDao.findById(id);
        Answer[] answers = answerDao.getAnswersByQuestionId(id);
        question.setAnswers(answers);

        return question;
    }

    PageableListResult<Question> getQuestions(QuestionFilter filter) {
        Question[] questions = questionDao.getQuestions(filter);

        int totCnt = questionDao.getQuestionTotCount(filter);
        int offset = filter.getOffset();
        int limit = filter.getLimit();

        PageableListResult<Question> pageableListResult
                = new PageableListResult<>(offset, limit, totCnt);

        pageableListResult.list.addAll(Arrays.asList(questions));

        return pageableListResult;
    }

    void saveQuestion(Question question) {
        questionDao.saveQuestion(question);
    }
}
