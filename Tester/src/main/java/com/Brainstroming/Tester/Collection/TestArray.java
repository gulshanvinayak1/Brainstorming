
package com.Brainstroming.Tester.Collection;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TestArray {
    @Id
    public Integer testId;
    public List<ObjectId> testsIds;

    public TestArray() {
    }

    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public List<ObjectId> getTestsIds() {
        return this.testsIds;
    }

    public void setTestsIds(List<ObjectId> testsIds) {
        this.testsIds = testsIds;
    }
}
