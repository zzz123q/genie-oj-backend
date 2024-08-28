package com.zzz123q.genieoj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.zzz123q.genieoj.judge.codesandbox.CodeSandbox;
import com.zzz123q.genieoj.judge.codesandbox.CodeSandboxFactory;
import com.zzz123q.genieoj.judge.codesandbox.CodeSandboxProxy;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zzz123q.genieoj.judge.codesandbox.model.ExecuteCodeResponse;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

@SpringBootTest
public class CodeSandboxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    public void executeCode() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.nextLine();
            String code = "int main () {}";
            String language = "java";
            List<String> inputList = Arrays.asList("1 2", "3 4");
            Long timeLimit = 1000L;
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .timeLimit(timeLimit)
                    .build();

            CodeSandbox box = CodeSandboxFactory.newInstance(type);
            ExecuteCodeResponse response = box.executeCode(executeCodeRequest);
        }
        scanner.close();
    }

    @Test
    public void executeCodeByValue() {
        String code = "int main () {}";
        String language = "java";
        List<String> inputList = Arrays.asList("1 2", "3 4");
        Long timeLimit = 1000L;
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .timeLimit(timeLimit)
                .build();

        CodeSandbox box = CodeSandboxFactory.newInstance(type);
        ExecuteCodeResponse response = box.executeCode(executeCodeRequest);
    }

    @Test
    public void executeCodeByProxy() {
        String code = "int main () {}";
        String language = "java";
        List<String> inputList = Arrays.asList("1 2", "3 4");
        Long timeLimit = 1000L;
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .timeLimit(timeLimit)
                .build();

        CodeSandbox box = CodeSandboxFactory.newInstance(type);
        box = new CodeSandboxProxy(box);
        ExecuteCodeResponse response = box.executeCode(executeCodeRequest);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.nextLine();
            String code = "int main () {}";
            String language = "java";
            List<String> inputList = Arrays.asList("1 2", "3 4");
            Long timeLimit = 1000L;
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .timeLimit(timeLimit)
                    .build();

            CodeSandbox box = CodeSandboxFactory.newInstance(type);
            ExecuteCodeResponse response = box.executeCode(executeCodeRequest);
        }
        scanner.close();
    }
}
