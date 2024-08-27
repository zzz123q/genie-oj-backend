package com.zzz123q.genieoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzz123q.genieoj.exception.BusinessException;
import com.zzz123q.genieoj.mapper.QuestionSubmitMapper;
import com.zzz123q.genieoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zzz123q.genieoj.model.entity.Question;
import com.zzz123q.genieoj.model.entity.QuestionSubmit;
import com.zzz123q.genieoj.model.entity.User;
import com.zzz123q.genieoj.model.enums.QuestionSubmitLanguageEnum;
import com.zzz123q.genieoj.model.enums.QuestionSubmitStatusEnum;
import com.zzz123q.genieoj.result.ErrorCode;
import com.zzz123q.genieoj.service.QuestionService;
import com.zzz123q.genieoj.service.QuestionSubmitService;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 题目提交(question_submit)表服务实现
 */
@Service
@Slf4j
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
        implements QuestionSubmitService {

    @Resource
    private QuestionService questionService;

    /**
     * 题目提交
     * 
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // 判断实体是否存在，根据类别获取实体
        Long questionId = questionSubmitAddRequest.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        String language = questionSubmitAddRequest.getLanguage();
        if (QuestionSubmitLanguageEnum.getEnumByValue(language) == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言错误");
        }

        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(loginUser.getId());
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(language);
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean result = this.save(questionSubmit);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目提交失败");
        }

        return questionSubmit.getId();
    }

}
