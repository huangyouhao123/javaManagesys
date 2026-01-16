package com.freshfish.telisawebmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private String name;
    Integer degree;
    Integer clazzId;

    private Integer page=1;
    private Integer pageSize=10;

    private Integer start;
}
