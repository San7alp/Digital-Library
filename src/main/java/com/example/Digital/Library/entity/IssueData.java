package com.example.Digital.Library.entity;

import com.example.Digital.Library.enums.IssueStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Entity
public class IssueData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @NotNull
    @JsonIgnore
    private Member member;
    @OneToOne
    @NotNull
    @JsonIgnore
    private Book book;

    @Builder.Default
    private Instant createdAt=Instant.now();

    private Instant expiryDate;
    @NotNull
    private double amtpaid;

    @NotNull
    @Builder.Default
    private IssueStatus issue=IssueStatus.ISSUED;

    @JsonProperty(value="memberID")
    public UUID memberId(){
        return this.member.getId();
    }
    @JsonProperty(value="bookId")
    public UUID bookId(){
        return this.book.getId();
    }


    public Instant calExpiry(){
        this.expiryDate=this.createdAt.plus(15, ChronoUnit.DAYS);
        return expiryDate;
    }
    public double calAmount(){
        this.amtpaid=this.book.getPrice()*0.05D;
        return this.amtpaid;
    }
}
