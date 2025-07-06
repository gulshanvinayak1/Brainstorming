//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Controller;

import com.Brainstroming.Tester.Collection.TestArray;
import com.Brainstroming.Tester.Collection.TestCase;
import com.Brainstroming.Tester.Service.TestCaseService;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/testcase"})
public class TestCasesController {
    @Autowired
    TestCaseService testCaseService;

    public TestCasesController() {
    }

    @PostMapping({"/addnewTestArray"})
    public boolean addnewTestArray(@RequestBody TestArray testArray) {
        return this.testCaseService.addTestArray(testArray);
    }

    @PostMapping({"/uploadtestcase/{testId}"})
    public ObjectId uploadnewtestcase(@PathVariable Integer testId, @RequestBody TestCase testCase) {
        return this.testCaseService.uploadTestCase(testCase, testId);
    }

    @PutMapping({"/updatetestcase/{testCaseId}"})
    public boolean updatetestCase(@RequestBody TestCase testCase) {
        return this.testCaseService.updateTestCase(testCase);
    }

    @GetMapping({"/getTestCaseById/{testId}"})
    public Optional<TestCase> gettestcasebyid(@PathVariable ObjectId testId) {
        return this.testCaseService.getTestCaseById(testId);
    }

    @DeleteMapping({"/deletemapping/{testsId}/{index}"})
    public boolean deletetestcase(@PathVariable Integer testsId, @PathVariable Integer index) {
        this.testCaseService.deleteTestCase(testsId, index);
        return true;
    }

    @GetMapping({"/getinbatch/{size}/{testId}"})
    public List<TestCase> yo(@PathVariable Integer size, @PathVariable Integer testId) {
        return this.testCaseService.getTestCasesFromIndex(testId, 0, size);
    }
}
