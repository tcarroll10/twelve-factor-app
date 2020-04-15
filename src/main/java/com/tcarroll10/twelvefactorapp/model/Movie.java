package com.tcarroll10.twelvefactorapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Movie.Builder.class)
@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	private String id;
	private String title;
	private String year;
	private String rating;

	public Movie() {

	}

	private Movie(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.year = builder.year;
		this.rating = builder.rating;
	}

	/**
	 * Creates builder to build {@link Movie}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Creates a builder to build {@link Movie} and initialize it with the given
	 * object.
	 * 
	 * @param movie to initialize the builder with
	 * @return created builder
	 */
	public static Builder builder(Movie movie) {
		return new Builder(movie);
	}

	/**
	 * Builder to build {@link Movie}.
	 */
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static final class Builder {
		private String id;
		private String title;
		private String year;
		private String rating;

		private Builder() {
		}

		private Builder(Movie movie) {
			this.id = movie.id;
			this.title = movie.title;
			this.year = movie.year;
			this.rating = movie.rating;
		}

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder year(String year) {
			this.year = year;
			return this;
		}

		public Builder rating(String rating) {
			this.rating = rating;
			return this;
		}

		public Movie build() {
			return new Movie(this);
		}
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rating=" + rating + "]";
	}

}
