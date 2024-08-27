package com.zzz123q.genieoj.judge.codesandbox.impl;

import com.zzz123q.genieoj.judge.codesandbox.CodeSandbox;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱(调用第三方代码沙箱完成判题工作)
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }

}