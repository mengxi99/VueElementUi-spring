package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 木木
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private long tatol;
    private List rows;
}
