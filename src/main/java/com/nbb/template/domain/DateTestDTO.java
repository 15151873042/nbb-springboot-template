package com.nbb.template.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DateTestDTO {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
