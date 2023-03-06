package com.example.demo.pojo;

import com.example.demo.entity.Remark;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private @Id
    @GeneratedValue Long cId;
    private String name;
    private String pan;
    private LocalDate onboardingDate;
    private LocalDate followUpDate;
    private List<Remark> remarks;
}
