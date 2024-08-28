package com.zzz123q.genieoj.judge.codesandbox.impl;

import java.util.List;

import com.zzz123q.genieoj.judge.codesandbox.CodeSandbox;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zzz123q.genieoj.judge.codesandbox.model.JudgeInfo;
import com.zzz123q.genieoj.model.enums.JudgeInfoMessageEnum;
import com.zzz123q.genieoj.model.enums.QuestionSubmitStatusEnum;

/**
 * 示例代码沙箱(仅用于业务流程测试)
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = ExecuteCodeResponse.builder()
                .outputList(inputList)
                .message("测试执行成功")
                .status(QuestionSubmitStatusEnum.SUCCEED.getValue())
                .build();
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setTime(100L);
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }

}