package com.zzz123q.genieoj.judge;

import org.springframework.stereotype.Service;

import com.zzz123q.genieoj.judge.codesandbox.model.JudgeInfo;
import com.zzz123q.genieoj.judge.strategy.DefaultJudgeStrategy;
import com.zzz123q.genieoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.zzz123q.genieoj.judge.strategy.JudgeContext;
import com.zzz123q.genieoj.judge.strategy.JudgeStrategy;

/**
 * 判题管理
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * 
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        String language = judgeContext.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if (language.equals("java")) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }

        JudgeInfo judgeInfo = judgeStrategy.doJudge(judgeContext);
        return judgeInfo;
    }
}
