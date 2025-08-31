package com.example.Digital.Library.dto;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
@With
public class AuthDTO {
    private String username;
    private String password;
}
