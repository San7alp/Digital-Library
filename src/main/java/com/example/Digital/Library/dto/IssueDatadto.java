package com.example.Digital.Library.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class IssueDatadto {
    private UUID bookId;
    private UUID memberId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private double amtpaid;
}
