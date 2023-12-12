package com.example.aftas.DTO;

import com.example.aftas.model.enums.IdentityDocumentType;

import java.util.Date;

public class MemberDTO {
    private Long num;
    private String name;
    private String familyName;
    private Date accessDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
}
