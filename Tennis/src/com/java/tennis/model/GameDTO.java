package com.java.tennis.model;

public class GameDTO {
	
	private int no;					//일련번호
	private int setNum;				//세트번호
	private int gameNum;			//게임번호
	private int mePt;				//유저포인트
	private int cpuPt;				//컴퓨터포인트
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getSetNum() {
		return setNum;
	}
	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}
	public int getGameNum() {
		return gameNum;
	}
	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}
	public int getMePt() {
		return mePt;
	}
	public void setMePt(int mePt) {
		this.mePt = mePt;
	}
	public int getCpuPt() {
		return cpuPt;
	}
	public void setCpuPt(int cpuPt) {
		this.cpuPt = cpuPt;
	}
	
	@Override
	public String toString() {
		return "GameDTO [no=" + no + ", setNum=" + setNum + ", gameNum=" + gameNum + ", mePt=" + mePt + ", cpuPt="
				+ cpuPt + "]";
	}
	
}






























