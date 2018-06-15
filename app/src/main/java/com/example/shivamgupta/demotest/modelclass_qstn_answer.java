package com.example.shivamgupta.demotest;

/**
 * Created by shivam gupta on 13-06-2018.
 */

public class modelclass_qstn_answer {
    String question,answer;

    public modelclass_qstn_answer(String question,String answer)
    {
        this.question=question;
        this.answer=answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
