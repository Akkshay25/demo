package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemarkDto {
    private Long rId;
    private String remark;
    private Long cId;
    private LocalDate remarkDate;
    private Long id;
}
