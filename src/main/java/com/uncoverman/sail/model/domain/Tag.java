package com.uncoverman.sail.model.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "t_tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable{

	@Id
	@GeneratedValue
	private Long tagId;

	@NotEmpty(message = "标签不能为空")
	private String tagName;

}
