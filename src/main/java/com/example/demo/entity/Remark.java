package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Remark {
    private @Id
    @GeneratedValue Long rId;
    private String remark;
    private Long cId;
    private LocalDate remarkDate;
    private Long id;

    public Remark(Long rId, String remark, Long cId, LocalDate remarkDate, Long id) {
        this.rId = rId;
        this.remark = remark;
        this.cId = cId;
        this.remarkDate = remarkDate;
        this.id = id;
    }
}
