package com.accenture.pojo;

import lombok.Getter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
public class UnauthorizedResponseDto implements Serializable {

  private long timestamp;
  private int status;
  private String error;
  private String path;

  public UnauthorizedResponseDto(String path) {
    this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    this.status = 401;
    this.error = "Unauthorized";
    this.path = path;
  }
}
