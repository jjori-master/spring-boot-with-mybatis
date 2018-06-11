package mybatis.service;

import lombok.extern.slf4j.Slf4j;
import mybatis.model.Question;
import mybatis.model.User;
import mybatis.model.filter.QuestionFilter;
import mybatis.model.result.PageableListResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class QnaServiceTest {

    @Autowired
    QnaService qnaService;

    @Test
    public void findByIdTest() {
        Question question = qnaService.getQuestionDetail(1L);
        assertThat(question.getTitle(), is("질문내용1"));
        assertThat(question.getContents(), is("질문1"));

        assertThat(question.getAnswers().length, is(2));
        assertThat(question.getAnswers()[0].getContents(), is("질문1에 대한 답변 1"));

        log.info(question.toString());
    }

    @Test
    public void getQuestionsTest() {
        QuestionFilter filter = new QuestionFilter();
        filter.setOffset(1);
        filter.setLimit(10);
        filter.setWriterEmail("jg.jo@widerplanet.com");

        PageableListResult<Question> pageableListResult
                = qnaService.getQuestions(filter);

        List<Question> list = pageableListResult.list;
        assertThat(list.size(), is(10));

        User wirter = new User(2, "jg.jo@widerplanet.com", null, "조종균");
        assertThat(list.get(0).getWriter(), is(wirter));
    }

    @Test
    public void 질문_등록_테스트() {
        Question question
                = new Question("안녕하세요 스프링 어노테이션은 무엇인가요?"
                , "정말 알고 싶네요!!" );

        User wirter
                = new User(2, "jg.jo@widerplanet.com", null, "조종균");
        question.setWriter(wirter);

        qnaService.saveQuestion(question);

        Question saveQuestion = qnaService.getQuestionDetail(32);

        question.setId(32);

        assertThat(saveQuestion, is(question));
    }
}
