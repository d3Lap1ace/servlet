package com.javaSE.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @classname Exer
 * @description
 * @Auther d3Lap1ace
 * @Time 2024/04/22  12:下午12:46
 * @Version 1.0
 * From the Laplace Demon
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
