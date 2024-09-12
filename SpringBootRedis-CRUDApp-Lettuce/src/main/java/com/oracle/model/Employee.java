package com.oracle.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private String empno;
	private String ename;
	private String job;

}
