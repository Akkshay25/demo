package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client {

  private @Id @GeneratedValue Long cId;
  private String name;
  private String pan;

  Client() {}

  Client(String name, String pan) {

    this.name = name;
    this.pan = pan;
  }

  public Long getCId() {
    return cId;
  }

  public void setCId(Long cId) {
    this.cId = cId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
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