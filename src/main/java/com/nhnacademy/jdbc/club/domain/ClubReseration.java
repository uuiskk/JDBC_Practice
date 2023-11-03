package com.nhnacademy.jdbc.club.domain;

import java.time.LocalDateTime;

public class ClubReseration {

    //학생 아이디
    private final String studentId;

    //club 아이디
    private final String clubId;

    public ClubReseration(String studentId, String clubId) {
        this.studentId = studentId;
        this.clubId = clubId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClubId() {
        return clubId;
    }
    
}
