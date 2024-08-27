package com.zzz123q.genieoj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzz123q.genieoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zzz123q.genieoj.model.entity.QuestionSubmit;
import com.zzz123q.genieoj.model.entity.User;

/**
 * 题目提交(question_submit)表服务
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     * 
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
