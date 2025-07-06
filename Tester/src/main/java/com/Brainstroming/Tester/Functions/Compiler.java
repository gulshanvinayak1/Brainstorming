//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.springframework.stereotype.Component;

@Component
public class Compiler {
    public Compiler() {
    }

    private void writeToFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        try {
            writer.write(content);
        } catch (Throwable var7) {
            try {
                writer.close();
            } catch (Throwable var6) {
                var7.addSuppressed(var6);
            }

            throw var7;
        }

        writer.close();
    }

    public boolean compileCppCode(String filename, String content) {
        String cppFilePath = filename + ".cpp";
        String executablePath = filename + ".exe";

        try {
            this.writeToFile(cppFilePath, content);
            Process compileProcess = (new ProcessBuilder(new String[]{"cmd.exe", "/c", "g++ " + cppFilePath + " -o " + executablePath})).redirectErrorStream(true).start();
            compileProcess.waitFor();
            return compileProcess.exitValue() == 0;
        } catch (InterruptedException | IOException var6) {
            Exception e = var6;
            ((Exception)e).printStackTrace();
            return false;
        }
    }

    public boolean runTestCase(String executablePath, String input, String expectedOutput) {
        try {
            Process runProcess = (new ProcessBuilder(new String[]{"cmd.exe", "/c", executablePath})).redirectErrorStream(true).start();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(runProcess.getOutputStream()));

            try {
                writer.write(input);
                writer.flush();
            } catch (Throwable var9) {
                try {
                    writer.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            writer.close();
            String output = ((String)(new BufferedReader(new InputStreamReader(runProcess.getInputStream()))).lines().reduce("", (acc, line) -> {
                return acc + line + "\n";
            })).trim();
            runProcess.waitFor();
            return output.equals(expectedOutput);
        } catch (InterruptedException | IOException var10) {
            Exception e = var10;
            ((Exception)e).printStackTrace();
            return false;
        }
    }
}
