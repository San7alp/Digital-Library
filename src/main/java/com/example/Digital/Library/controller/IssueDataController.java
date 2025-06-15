package com.example.Digital.Library.controller;
import com.example.Digital.Library.dto.IssueDatadto;
import com.example.Digital.Library.entity.IssueData;
import com.example.Digital.Library.service.IssueDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue_data")
public class IssueDataController {
    private final IssueDataService ids;

    @Autowired
    public IssueDataController(IssueDataService ids) {
        this.ids = ids;
    }
    @PostMapping("/add")
    public ResponseEntity<IssueData> addissuedata(@RequestBody IssueDatadto i){
        IssueData issue=this.ids.addissuedata(i);
        return new ResponseEntity<>(issue,HttpStatus.OK);
    }
}
