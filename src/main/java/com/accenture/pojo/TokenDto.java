package com.accenture.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto implements Serializable {

  private String token;

  @JsonProperty(value = "refresh_token")
  private String refreshToken;
}
