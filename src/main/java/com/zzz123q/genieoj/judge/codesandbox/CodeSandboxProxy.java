package com.zzz123q.genieoj.judge.codesandbox;

import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息:{}", executeCodeRequest);
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息:{}", executeCodeResponse);
        return executeCodeResponse;
    }
}
