package com.accenture.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CategoryDto implements Serializable {

  @ApiModelProperty(notes = "The category nam,e", name = "name", required = true)
  @NotNull(message = "The category name cannot be missing or empty")
  private String name;
}
