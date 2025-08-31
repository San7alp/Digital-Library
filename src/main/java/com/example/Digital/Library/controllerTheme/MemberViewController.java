package com.example.Digital.Library.controllerTheme;

import com.example.Digital.Library.entity.Member;
import com.example.Digital.Library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberViewController {

    private final MemberService memberService;

    @Autowired
    public MemberViewController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members"; // templates/members.html
    }

    @GetMapping("/add")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/save")
    public String saveMember(@ModelAttribute Member member) {
        memberService.addMember(member);
        return "redirect:/members";
    }
}

