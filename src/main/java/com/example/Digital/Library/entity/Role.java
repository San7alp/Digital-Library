package com.example.Digital.Library.entity;

import java.util.List;
import java.util.UUID;

public class Role {
    private UUID id;
    private String name;
    private List<Permission> permissionList;
}
