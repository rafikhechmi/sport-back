package com.project.sport.models;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String teamTwo;
	private String teamOne;
	private String scoreOne;
	private String scoreTwo;

	public Game() {
		super();
	}

	public Game(Long id, String teamTwo, String teamOne, String scoreOne, String scoreTwo) {
		super();
		this.id = id;
		this.teamTwo = teamTwo;
		this.teamOne = teamOne;
		this.scoreOne = scoreOne;
		this.scoreTwo = scoreTwo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	public String getScoreOne() {
		return scoreOne;
	}

	public void setScoreOne(String scoreOne) {
		this.scoreOne = scoreOne;
	}

	public String getScoreTwo() {
		return scoreTwo;
	}

	public void setScoreTwo(String scoreTwo) {
		this.scoreTwo = scoreTwo;
	}

	@Override
	public String toString() {
		return "Matche [id=" + id + ", teamTwo=" + teamTwo + ", teamOne=" + teamOne + ", scoreOne=" + scoreOne
				+ ", scoreTwo=" + scoreTwo + "]";
	}

}
