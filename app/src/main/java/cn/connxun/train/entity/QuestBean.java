package cn.connxun.train.entity;

/**
 * Created by wushange on 2017/9/3.
 */

public class QuestBean {


    /**
     * id : 1
     * question : 问题一
     * answer : 内容一
     * datetime : null
     * state : 0
     */

    private int id;
    private String question;
    private String answer;
    private String datetime;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "QuestBean{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", datetime='" + datetime + '\'' +
                ", state=" + state +
                '}';
    }
}
