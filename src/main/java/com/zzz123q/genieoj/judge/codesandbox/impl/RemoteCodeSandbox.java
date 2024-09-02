package com.zzz123q.genieoj.judge.codesandbox.impl;

import com.zzz123q.genieoj.exception.BusinessException;
import com.zzz123q.genieoj.judge.codesandbox.CodeSandbox;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zzz123q.genieoj.result.ErrorCode;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

/**
 * 远程代码沙箱(实际调用接口的沙箱)
 */
public class RemoteCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://192.168.220.129:8082/executeCode";
        HttpResponse httpResponse = HttpUtil.createPost(url)
                .body(JSONUtil.toJsonStr(executeCodeRequest))
                .execute();
        String resPonseBodyStr = httpResponse.body();
        if (StrUtil.isBlank(resPonseBodyStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROE, "代码沙箱返回结果为空");
        }
        return JSONUtil.toBean(resPonseBodyStr, ExecuteCodeResponse.class);
    }

}