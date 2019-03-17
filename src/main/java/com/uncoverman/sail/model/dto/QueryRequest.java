package com.uncoverman.sail.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryRequest implements Serializable {

	private int pageSize;
	private int pageNum;

}
