package com.project.askdoctor.entity;

import com.project.askdoctor.entity.ERole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer _id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  public Integer getId() {
    return _id;
  }

  public void setId(Integer id) {
    this._id = id;
  }

  public ERole getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + _id +
            ", name=" + name +
            '}';
  }

  public void setName(ERole name) {
    this.name = name;
  }
}