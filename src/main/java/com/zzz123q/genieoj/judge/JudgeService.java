package com.zzz123q.genieoj.judge;

import com.zzz123q.genieoj.model.entity.QuestionSubmit;

public interface JudgeService {

    /**
     * 根据题目提交id进行判题服务
     * 
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
