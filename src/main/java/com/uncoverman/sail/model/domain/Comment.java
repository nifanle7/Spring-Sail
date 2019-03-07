package com.uncoverman.sail.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_comment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable{

	@Id
	@GeneratedValue
	private Long commentId;

	private String commentContent;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

}
