package com.example.model;

public class VoteModel {
	
	private String showId;
	
	private String showName;
	
	private String categoryId;
	
	private String categoryName;
	
	private String contestantId;
	
	private String contestantName;
	
	private String cycleId;
	
	private String userId;
	
	private String userName;
	
	private String userEmail;
	
	private String region;
	
	private String ip;
	
	private String loginProvider;

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getContestantId() {
		return contestantId;
	}

	public void setContestantId(String contestantId) {
		this.contestantId = contestantId;
	}

	public String getContestantName() {
		return contestantName;
	}

	public void setContestantName(String contestantName) {
		this.contestantName = contestantName;
	}

	public String getCycleId() {
		return cycleId;
	}

	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLoginProvider() {
		return loginProvider;
	}

	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}

	@Override
	public String toString() {
		return "VoteModel [showId=" + showId + ", showName=" + showName + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", contestantId=" + contestantId + ", contestantName="
				+ contestantName + ", cycleId=" + cycleId + ", userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", region=" + region + ", ip=" + ip + ", loginProvider=" + loginProvider
				+ "]";
	}

}
