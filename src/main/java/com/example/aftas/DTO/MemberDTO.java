package com.example.aftas.DTO;

import com.example.aftas.model.enums.IdentityDocumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

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
