//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(
        collection = "unoffficialcodes"
)
public class UnofficialCode {
    @Id
    private Long submissionId;
    private String code;

    public UnofficialCode() {
    }

    public Long getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
