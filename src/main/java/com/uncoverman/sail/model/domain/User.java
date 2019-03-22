package com.uncoverman.sail.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	@Id
	@GeneratedValue
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 头像
	 */
	private String userAvatar;

	/**
	 * 说明
	 */
	private String userDesc;

	/**
	 * 是否禁用登录
	 */
	@JsonIgnore
	private String loginEnable = "true";

	/**
	 * 最后一次登录时间
	 */
	@JsonIgnore
	private Date loginLast;

	/**
	 * 登录错误次数记录
	 */
	@JsonIgnore
	private Integer loginError = 0;


}
