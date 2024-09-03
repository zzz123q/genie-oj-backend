package com.zzz123q.genieoj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzz123q.genieoj.exception.BusinessException;
import com.zzz123q.genieoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zzz123q.genieoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zzz123q.genieoj.model.entity.QuestionSubmit;
import com.zzz123q.genieoj.model.entity.User;
import com.zzz123q.genieoj.model.vo.QuestionSubmitVO;
import com.zzz123q.genieoj.result.BaseResponse;
import com.zzz123q.genieoj.result.ErrorCode;
import com.zzz123q.genieoj.result.ResultUtils;
import com.zzz123q.genieoj.service.QuestionSubmitService;
import com.zzz123q.genieoj.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 题目提交接口
 */
// @RestController
// @RequestMapping("/question_submit")
@Slf4j
@Api(tags = "题目提交接口")
@Deprecated
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     */
    @PostMapping("/")
    @ApiOperation("提交题目")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表
     * (管理员与用户本人可以看见全部信息, 非用户本人只能看到部分公开信息)
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    @PostMapping("/list/page")
    @ApiOperation("分页获取题目提交列表")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(
            @RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        Page<QuestionSubmitVO> questionSubmitVOPage = questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,
                loginUser);
        return ResultUtils.success(questionSubmitVOPage);
    }

}
