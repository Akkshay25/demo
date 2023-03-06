package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;
@Data
@Entity
@NoArgsConstructor
public class  Client {

  private @Id @GeneratedValue Long cId;
  private String name;
  private String pan;
  private LocalDate onboardingDate;
  private LocalDate followUpDate;

  Client(String name, String pan, LocalDate onboardingDate, LocalDate followUpDate) {

    this.name = name;
    this.pan = pan;
    this.onboardingDate = onboardingDate;
    this.followUpDate = followUpDate;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Client))
      return false;
    Client employee = (Client) o;
    return Objects.equals(this.cId, employee.cId) && Objects.equals(this.name, employee.name)
        && Objects.equals(this.pan, employee.pan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.cId, this.name, this.pan);
  }


}