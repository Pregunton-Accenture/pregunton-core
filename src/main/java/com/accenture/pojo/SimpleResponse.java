package com.accenture.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SimpleResponse {
  private String message;
  private int status;
}