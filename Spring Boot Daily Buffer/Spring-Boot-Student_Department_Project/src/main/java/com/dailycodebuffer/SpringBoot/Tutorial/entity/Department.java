package com.dailycodebuffer.SpringBoot.Tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

//    @NotBlank(message = "Please Add Department Name")
//    @Length(max = 7, min = 5)
//    @Size(max = 10, min = 0)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
