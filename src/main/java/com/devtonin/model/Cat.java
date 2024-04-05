package com.devtonin.model;

import java.util.Objects;

/*
@AllArgsConstructor
@NoArgsConstructor
@Data
@Value
@Builder
 */
public record Cat (String name, String age, BreedEnum breed, Boolean isFurry) {

	public Cat {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("We must know the cat's name!");
		}
		if (Objects.isNull(age)) {
			age = "Unknown age";
		}
		if (Objects.isNull(breed)) {
			breed = BreedEnum.valueOf("Unknown or NBD");
		}
		if (isFurry == null) {
			throw new IllegalArgumentException("We need to know if the cat is furry or not!");
		}
	}

	public static class Builder {
		private String name;
		private String age;
		private BreedEnum breed;
		private Boolean isFurry;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder age(String age) {
			this.age = age;
			return this;
		}

		public Builder breed(BreedEnum breed) {
			this.breed = breed;
			return this;
		}

		public Builder isFurry(Boolean isFurry) {
			this.isFurry = isFurry;
			return this;
		}

		public Cat build() {
			return new Cat(name, age, breed, isFurry);
		}
	}
}
