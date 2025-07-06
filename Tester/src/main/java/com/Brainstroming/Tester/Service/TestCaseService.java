//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Service;

import com.Brainstroming.Tester.Collection.TestArray;
import com.Brainstroming.Tester.Collection.TestCase;
import com.Brainstroming.Tester.Repository.TestArrayRepository;
import com.Brainstroming.Tester.Repository.TestCaseRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {
    @Autowired
    private TestCaseRepository testCaseRepository;
    @Autowired
    private TestArrayRepository testArrayRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public TestCaseService() {
    }

    public ObjectId uploadTestCase(TestCase testCase, Integer testId) {
        TestCase saved = (TestCase)this.testCaseRepository.save(testCase);
        System.out.println(saved._id);
        this.pushTestIdToTestsArray(testId, saved.get_id());
        return saved.get_id();
    }

    public boolean addTestArray(TestArray testArray) {
        this.testArrayRepository.save(testArray);
        return true;
    }

    public boolean updateTestCase(TestCase testCase) {
        this.updateDocumentById(testCase);
        return true;
    }

    public Optional<TestCase> getTestCaseById(ObjectId testCaseId) {
        return this.testCaseRepository.findById(testCaseId);
    }

    public boolean deleteTestCase(Integer testArrayId, Integer index) {
        List<ObjectId> delId = this.getNextElementsFromIndex(testArrayId, index, 1);
        this.testCaseRepository.deleteById((ObjectId)delId.get(0));
        this.removeElementByValue(testArrayId, (ObjectId)delId.get(0));
        System.out.println(((ObjectId)delId.get(0)).toHexString());
        return true;
    }

    public void pushTestIdToTestsArray(Integer testId, ObjectId newTestId) {
        Query query = new Query(Criteria.where("_id").is(testId));
        Update update = (new Update()).push("testsIds", newTestId);
        this.mongoTemplate.updateFirst(query, update, "testArray");
    }

    public void updateDocumentById(TestCase newTestCase) {
        Query query = new Query(Criteria.where("_id").is(newTestCase.get_id()));
        newTestCase.set_id(newTestCase.get_id());
        this.mongoTemplate.findAndReplace(query, newTestCase, "testCase");
    }

    public List<ObjectId> getNextElementsFromIndex(Integer testId, Integer startIndex, Integer numberOfElements) {
        Query query = new Query(Criteria.where("_id").is(testId));
        query.fields().include("testsIds").slice("testsIds", startIndex, numberOfElements);
        TestArray document = (TestArray)this.mongoTemplate.findOne(query, TestArray.class, "testArray");
        return document != null ? document.getTestsIds() : null;
    }

    public List<TestCase> getTestCasesFromIndex(Integer testId, Integer startIndex, Integer numberOfElements) {
        List<ObjectId> objectIds = this.getNextElementsFromIndex(testId, startIndex, numberOfElements);
        Query query = new Query(Criteria.where("_id").in(objectIds));
        return this.mongoTemplate.find(query, TestCase.class, "testCase");
    }

    public void removeElementByValue(Integer testsId, ObjectId testCaseId) {
        Query query = new Query(Criteria.where("_id").is(testsId));
        Update update = (new Update()).pull("testsIds", testCaseId);
        this.mongoTemplate.updateFirst(query, update, "testArray");
    }
}
