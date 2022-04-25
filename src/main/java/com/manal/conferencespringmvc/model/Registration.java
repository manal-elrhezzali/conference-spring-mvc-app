package com.manal.conferencespringmvc.model;

import javax.validation.constraints.NotEmpty;

public class Registration {
  // this annotation will guarantee that when we ask
  // for validation on it, it doesn't allow an empty,
  // blank or spaces
  @NotEmpty
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
