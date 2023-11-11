package io.dave.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMesage {

	private String dateTime;
	private String message;
	private int status;
	private String code;
}
