package br.com.mateus.shoppingcart.api.exceptionhandlers;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Builder
@Getter
@Schema(name = "Problem")
public class Problem {

	@Schema(example = "400")
	private Integer status;

	@Schema(example = "https://matheusplus.com.br/invalid-data")
	private String type;

	@Schema(example = "Invalid Id")
	private String title;

	@Schema(example = "One or more fields are invalid. Please fill in correctly and try again.")
	private String detail;

	@Schema(example = "One or more fields are invalid. Please fill in correctly and try again..")
	private String userMessage;

	@Schema(example = "2022-07-15T11:21:50.902245498Z")
	private OffsetDateTime timestamp;

	@Schema(description = "List of objects or fields that generated the error")
	private List<Object> objects;

	@Builder
	@Getter
	@Schema(name = "ProblemObject")
	public static class Object {

		@Schema(example = "Id")
		private String name;

		@Schema(example = "The id is invalid")
		private String userMessage;

	}

}