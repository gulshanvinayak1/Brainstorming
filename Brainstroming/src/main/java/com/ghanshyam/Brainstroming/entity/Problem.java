//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "published_problems",
        indexes = {@Index(
                name = "idx_contestid_problemnum",
                columnList = "contest_id DESC, problem_num ASC"
        )}
)
public class Problem {
    @Id
    private String id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "testid",
            nullable = false
    )
    private Integer testid;
    @Column(
            name = "contest_id",
            nullable = false
    )
    private Integer contestId;
    @Column(
            name = "problem_num",
            nullable = false
    )
    private Integer problemnum;
    @Column(
            name = "statement",
            columnDefinition = "TEXT"
    )
    private String statement;
    @Column(
            name = "input_format",
            columnDefinition = "TEXT"
    )
    private String inputFormat;
    @Column(
            name = "output_format",
            columnDefinition = "TEXT"
    )
    private String outputFormat;
    @Column(
            name = "sample_input",
            columnDefinition = "TEXT"
    )
    private String sampleInput;
    @Column(
            name = "sample_output",
            columnDefinition = "TEXT"
    )
    private String sampleOutput;
    @Column(
            name = "note",
            columnDefinition = "TEXT"
    )
    private String note;
    @Column(
            name = "memory_limit",
            nullable = false
    )
    private Integer memoryLimit;
    @Column(
            name = "time_limit",
            nullable = false
    )
    private Integer timeLimit;
    @Column(
            name = "difficulty"
    )
    private Integer difficulty;

    public Problem() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTestid() {
        return this.testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getStatement() {
        return this.statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getInputFormat() {
        return this.inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getOutputFormat() {
        return this.outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getSampleInput() {
        return this.sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return this.sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getMemoryLimit() {
        return this.memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Integer getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getContestId() {
        return this.contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getProblemnum() {
        return this.problemnum;
    }

    public void setProblemnum(Integer problemnum) {
        this.problemnum = problemnum;
    }
}
