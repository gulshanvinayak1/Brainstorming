//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDto {
    public ConvertDto() {
    }

    public static Object convertToObject(SubmissionDto submissionDto, Long submissionId) {
        KafkaDto kafkaDto = new KafkaDto();
        kafkaDto.setUserId(submissionDto.getUserId());
        kafkaDto.setCode(submissionDto.getCode());
        kafkaDto.setContestId(submissionDto.getContestId());
        kafkaDto.setScore(submissionDto.getScore());
        kafkaDto.setTestid(submissionDto.getTestid());
        kafkaDto.setSubmissionId(submissionId);
        kafkaDto.setProblemnum(submissionDto.getProblemnum());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.valueToTree(kafkaDto);
    }
}
