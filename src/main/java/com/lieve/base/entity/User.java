package com.lieve.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private int id;

    private String name;

    private int age;

    private Instant createTime;

    private Instant updateTime;
}
