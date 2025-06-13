package com.example.Digital.Library.controller;

import com.example.Digital.Library.entity.Member;
import com.example.Digital.Library.service.BookService;
import com.example.Digital.Library.service.MemberService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/member")
public class MemberController {
    @Autowired
    public MemberController(MemberService ms) {
        this.ms = ms;
    }

    private MemberService ms;
    @PostMapping("/add")
    public ResponseEntity<Member> add(@RequestBody Member m){
        Member saved=this.ms.addMember(m);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Member>> get(){
        return new ResponseEntity<>(this.ms.findAll(),HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> get(@PathVariable UUID id){
        return new ResponseEntity<>(this.ms.findById(id), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Member> update(@PathVariable UUID id, @RequestBody Member updatedData) {
        try {
            Member updated = ms.updateMember(id, updatedData);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
