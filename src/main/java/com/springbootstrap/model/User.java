package com.springbootstrap.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class User {

    @ApiModelProperty(notes = "Id of the user")
    private String id;
    @ApiModelProperty(notes = "Name of the user")
    private String name;
}
