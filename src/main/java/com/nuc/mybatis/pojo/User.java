package com.nuc.mybatis.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;


/**
 * @author 86186
 * @createDate:2022/11/1
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private Integer id;
    private String user_name;
    private String birthday;
    private String sex;
    private String address;
}
