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
            System.out.println(response);
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
        System.out.println(response);
    }

    @Test
    public void executeCodeByProxy() {
        String code = "public class Main {\r\n" + //
                "    public static void main(String[] args) {\r\n" + //
                "        int a = Integer.parseInt(args[0]);\r\n" + //
                "        int b = Integer.parseInt(args[1]);\r\n" + //
                "        System.out.println(\"结果是: \" + (a + b));\r\n" + //
                "    }\r\n" + //
                "}";
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
        System.out.println(response);
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
            System.out.println(response);
        }
        scanner.close();
    }
}
