package com.nbb.template.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DateTestDTO implements Serializable {

    private LocalDateTime localDateTime;

    private LocalDate localDate;

    private Date date;

    private Boolean flag;

    private Long age;

}
