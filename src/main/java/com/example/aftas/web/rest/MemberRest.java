package com.example.aftas.web.rest;

import com.example.aftas.handler.response.ApiResponse;
import com.example.aftas.model.Member;
import com.example.aftas.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberRest {
    
    private final MemberService memberService;
    Logger logger = LoggerFactory.getLogger(MemberRest.class);

    @GetMapping("/all")
    public ApiResponse<?> getAll(@ParameterObject Pageable pageable){
        List<Member> members = memberService.findAll(pageable);
        return ApiResponse
                .success("the member is retrieved successfully !", members);
    }
    @GetMapping("/{id}")
    public ApiResponse getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if(member == null) {
            ApiResponse<String> notFoundResponse = ApiResponse.notFound("Member not found");
            return notFoundResponse;
        }else {
            return ApiResponse.ok( "Success", member);
        }
    }

    @PostMapping("/add")
    public ApiResponse addMember(@Valid @RequestBody Member member) {
        try {

            Member memberObject = memberService.addMember(member);

            if(memberObject == null) {

                return ApiResponse.badRequest("Member not created");

            }else {
                return ApiResponse.created("Member created successfully", memberObject);
            }
        } catch (IllegalArgumentException e) {

            logger.error(e.getMessage(), e);

            return ApiResponse
                    .badRequest(e.getMessage());
        }
    }

    @GetMapping
    public ApiResponse searchMember(@RequestBody String name, Pageable pageable) {
        List<Member> members = memberService.searchMember(name, pageable);
        if(members.isEmpty()) {
            return ApiResponse.notFound("Member not found");
        }else {
            return ApiResponse.ok("Success", members);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse updateMember(@RequestBody Member member, @PathVariable Long id) {
        Member member1 = memberService.updateMember(member, id);
        if(member1 == null) {
            return ApiResponse.badRequest("Member not updated");
        }else {
            return ApiResponse.created("Member updated successfully", member1);
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteMember(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if(member == null) {
            return ApiResponse.notFound("Member not found");
        }else {
            memberService.deleteMember(id);
            return ApiResponse.ok("Member deleted successfully", member);
        }
    }
}
