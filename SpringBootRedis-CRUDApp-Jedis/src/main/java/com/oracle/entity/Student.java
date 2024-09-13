package com.oracle.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

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
@RedisHash("Student")
public class Student implements Serializable {

	public enum Gender {
		MALE, FEMALE
	}

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Gender gender;
	private Integer grade;

}
