package com.oracle.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer runs;
	private Integer wickeds;
	private Double overs;
}
