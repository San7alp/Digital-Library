package com.example.Digital.Library.controllerTheme;


import com.example.Digital.Library.dto.IssueDatadto;
import com.example.Digital.Library.service.IssueDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/issuedata")
public class IssueDataViewController {

    private final IssueDataService issueDataService;

    @Autowired
    public IssueDataViewController(IssueDataService issueDataService) {
        this.issueDataService = issueDataService;
    }

    @GetMapping("/add")
    public String showIssueDataForm(Model model) {
        model.addAttribute("issuedata", new IssueDatadto());
        return "add-issuedata";
    }

    @PostMapping("/save")
    public String saveIssueData(@ModelAttribute IssueDatadto issuedata) {
        issueDataService.addissuedata(issuedata);
        return "redirect:/books"; // Redirect to book list or another page
    }
}

