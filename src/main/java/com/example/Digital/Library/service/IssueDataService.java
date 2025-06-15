package com.example.Digital.Library.service;

import com.example.Digital.Library.dto.IssueDatadto;
import com.example.Digital.Library.entity.Book;
import com.example.Digital.Library.entity.IssueData;
import com.example.Digital.Library.entity.Member;
import com.example.Digital.Library.repository.IssueDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@Slf4j
@Service
public class IssueDataService {
    private final IssueDataRepo isr;
    private final BookService bs;
    private final MemberService ms;
    @Autowired
    public IssueDataService(IssueDataRepo isr, BookService bs, MemberService ms) {
        this.isr = isr;
        this.bs = bs;
        this.ms = ms;
    }
    public IssueData addissuedata(IssueData idata){
        log.info("Saving a issue data");
        idata.calExpiry();
        idata.calAmount();
        IssueData saved=this.isr.save(idata);
        log.info("Saved a new issue data with ID: {} for book ID: {} by member ID: {}",
                saved.getId(), saved.getBook().getId(),saved.getMember().getId());
        return saved;
    }
    public IssueData addissuedata(IssueDatadto i){
        Book b=this.bs.getBookById(i.getBookId());
        Member m=this.ms.findById(i.getMemberId());
        if(b== null||m==null){
            throw new RuntimeException();
        }
        IssueData issue=IssueData.builder().
                book(b).member(m).
                build();
        return this.addissuedata(issue);
    }
}
