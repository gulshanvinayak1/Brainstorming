//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Functions;

import com.Brainstroming.Tester.Collection.TestCase;
import com.Brainstroming.Tester.Entity.CurrentStandings;
import com.Brainstroming.Tester.Repository.OfficialSubmissionRepository;
import com.Brainstroming.Tester.Repository.UnofficialsubmissionRepository;
import com.Brainstroming.Tester.Service.CurrentStandingsService;
import com.Brainstroming.Tester.Service.TestCaseService;
import com.Brainstroming.Tester.kafka.KafkaDto;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCode {
    @Autowired
    OfficialSubmissionRepository officialSubmissionRepository;
    @Autowired
    UnofficialsubmissionRepository unofficialsubmissionRepository;
    @Autowired
    Compiler compiler;
    @Autowired
    TestCaseService testCaseService;
    @Autowired
    CurrentStandingsService currentStandingsService;

    public TestCode() {
    }

    public void deleteFile(String fileNameWithoutExtension) {
        String cppFilePath = fileNameWithoutExtension + ".cpp";
        String executablePath = fileNameWithoutExtension + ".exe";
        File cppFile = new File(cppFilePath);
        File exeFile = new File(executablePath);
        if (cppFile.exists() && !cppFile.delete()) {
            System.err.println("Failed to delete file: " + cppFilePath);
        }

        if (exeFile.exists() && !exeFile.delete()) {
            System.err.println("Failed to delete file: " + executablePath);
        }

    }

    public boolean testCode(KafkaDto kafkaDto, String filename) {
        boolean compile = this.compiler.compileCppCode(filename, kafkaDto.getCode());
        String veridict = "Accepted";
        if (compile) {
            Integer i = 0;
            Integer size = 5;

            while(veridict.equals("Accepted")) {

                List<TestCase> tests = this.testCaseService.getTestCasesFromIndex(kafkaDto.getTestid(), i, size);
                if (tests.isEmpty()) {
                    break;
                }

                for(int j = 0; j < tests.size(); ++j) {
                    if (!this.compiler.runTestCase(filename, ((TestCase)tests.get(j)).getInput(), ((TestCase)tests.get(j)).getOutput())) {
                        veridict = "Wrong Answer At" + (i + j);
                        break;
                    }

                    System.out.println("running on treestcase " + filename + " ===  " + (j + 1));
                }

                i = i + size;
                if (!veridict.equals("Accepted")) {
                    break;
                }
            }

            System.out.println(veridict);
        } else {
            veridict = "Compiliation error";
            System.out.println(compile);
        }

        if (kafkaDto.getScore() != 0) {
            this.officialSubmissionRepository.updateStatus(kafkaDto.getSubmissionId(), veridict);
            System.out.println("I am official submission");
            if (!this.currentStandingsService.existing(kafkaDto.getUserId(), kafkaDto.getContestId())) {
                CurrentStandings newEntry = new CurrentStandings();
                newEntry.setContestId(kafkaDto.getContestId());
                newEntry.setUserId(kafkaDto.getUserId());
                newEntry.setS1(Short.valueOf((short)0));
                newEntry.setS2(Short.valueOf((short)0));
                newEntry.setS3(Short.valueOf((short)0));
                newEntry.setS4(Short.valueOf((short)0));
                newEntry.setRank(0);
                this.currentStandingsService.add(newEntry);
            }

            if (kafkaDto.getProblemnum() == 1) {
                this.currentStandingsService.incrementS1(kafkaDto.getUserId(), kafkaDto.getContestId(), kafkaDto.getScore());
            } else if (kafkaDto.getProblemnum() == 2) {
                this.currentStandingsService.incrementS2(kafkaDto.getUserId(), kafkaDto.getContestId(), kafkaDto.getScore());
            } else if (kafkaDto.getProblemnum() == 3) {
                System.out.println("I am problem 3");
                this.currentStandingsService.incrementS3(kafkaDto.getUserId(), kafkaDto.getContestId(), kafkaDto.getScore());
            } else if (kafkaDto.getProblemnum() == 4) {
                this.currentStandingsService.incrementS4(kafkaDto.getUserId(), kafkaDto.getContestId(), kafkaDto.getScore());
            }
        } else {
            this.unofficialsubmissionRepository.updateStatus(kafkaDto.getSubmissionId(), veridict);
        }

        return true;
    }
}
