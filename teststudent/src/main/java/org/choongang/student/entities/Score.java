package org.choongang.student.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Score {
    private long seq;
    private String sNo;
    private String subCode;
    private long sYear;
    private long sSem;
    private long sScore;
}