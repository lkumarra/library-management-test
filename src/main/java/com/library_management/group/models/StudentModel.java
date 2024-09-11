package com.library_management.group.models;

import lombok.Data;

@Data
public class StudentModel {
    public int id;
    public String studentName;
    public int rollNo;
    public String department;
    public boolean status;
    public Long createdAt;
    public Long updatedAt;
}
