package com.zzz123q.genieoj.judge.codesandbox;

import com.zzz123q.genieoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.zzz123q.genieoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.zzz123q.genieoj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂(静态工厂)
 * 根据字符串参数创建指定的代码沙箱
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱实例
     * 
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
