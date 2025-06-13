package com.example.Digital.Library.service;

import com.example.Digital.Library.entity.Member;
import com.example.Digital.Library.repository.MemberRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class MemberService {
    public MemberService(MemberRepo mr) {
        this.mr = mr;
    }

    private MemberRepo mr;

    public Member addMember(Member m){
        log.info("Saving a member..");
        Member saved= this.mr.save(m);
        log.info("Saved..",saved.getId());
        return saved;
    }
    public List<Member> findAll(){
        return this.mr.findAll();
    }
    public Member findById(UUID id){
        Optional<Member>m=this.mr.findById(id);
        if(m.isPresent()){
            return m.get();
        }
        else{
            return null;
        }
    }
    public Member updateMember(UUID id, Member newData) {
        Optional<Member> existingOpt = this.mr.findById(id);

        if (existingOpt.isPresent()) {
            Member existing = existingOpt.get();

            // Using Lombok's @With to create a new updated Member
            Member updated = existing
                    .withFname(newData.getFname())
                    .withLname(newData.getLname())
                    .withMobile(newData.getMobile())
                    .withEmail(newData.getEmail());

            return mr.save(updated);
        } else {
            throw new RuntimeException("Member not found with ID: " + id);
        }
    }

}
