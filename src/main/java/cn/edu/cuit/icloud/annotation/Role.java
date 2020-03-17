package cn.edu.cuit.icloud.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.edu.cuit.icloud.constant.RoleEnum;

/**
 * 角色注解
 * @date: 2020年3月10日
 * @author: flfan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Role {
	RoleEnum type();
}
