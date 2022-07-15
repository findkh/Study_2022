package com.hyuncode.cafe24.controller;

public class Code {
  String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "Code [code=" + code + ", getCode()=" + getCode() + ", getClass()=" + getClass()
    + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
  }


}
