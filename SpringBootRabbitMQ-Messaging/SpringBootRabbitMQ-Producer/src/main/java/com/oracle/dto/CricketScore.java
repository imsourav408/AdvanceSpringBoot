package com.oracle.dto;

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
public class CricketScore implements Serializable {
	private static final long serialVersionUID = 1L;
	private String team;
	private Integer run;
	private Integer wicket;
}
