package com.freshfish.telisawebmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogQueryParam {
    private Integer page=1;
    private Integer pageSize=10;
}
