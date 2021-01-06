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
public class City implements BaseEntity {

    private int id;

    private String name;

    private String state;

    private Instant createTime;

    private Instant updateTime;

}
