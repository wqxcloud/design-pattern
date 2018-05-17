package com.xiaoxin.validator.model;

import com.xiaoxin.validator.annotation.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午10:14
 */
@Getter
@Setter
@ToString
public class Student {
    @NotNull(message = "姓名不能为空")
    private String name;
    //自定义注解限制为 枚举类型 0、1
    @Gender
    private int gender;
    @Length(min=19,max=19,message = "身份证号只能为19位")
    private String identityId;
    @Pattern(regexp="^(1)\\d{10}$", message="请输入正确的手机号")
    private String phoneNumber;
    @Email(message = "请输入正确的email地址")
    private String email;
    @Past(message = "生日不能大于当前时间")
    @DateTimeFormat(pattern = "yyyMMdd")
    private Date birthDay;
    @Max(value = 130,message = "年龄不能超过130岁")
    private int age;
}
