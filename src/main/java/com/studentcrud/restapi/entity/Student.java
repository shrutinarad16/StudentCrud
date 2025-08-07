package com.studentcrud.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int rollNo;
    private String name;
    private float percentage;
    private String branch;
}
