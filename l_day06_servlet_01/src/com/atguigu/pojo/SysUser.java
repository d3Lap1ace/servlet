package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;





@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser  implements Serializable {

    private Integer uid;
    private String username;
    private String userPwd;

}