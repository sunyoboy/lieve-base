package com.lieve.base.common.feature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunlijiang
 * @date 2019/6/5
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {

    private int age;

    private String name;
}
