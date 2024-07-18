package com.java.tennis.model;

public class SkillDTO {
	
	private double serve;			//서브	
	private double forehand;		//포핸드
	private double backhand;		//백핸드
	private double volly;			//발리
	
	
	public int[] getSkill(int i) {
		
		int[] stats = new int[4];

		double serve = 0.0;
		double forehand = 0.0;
		double backhand = 0.0;
		double volly = 0.0;
		
		stats[0] = (int)serve;
		stats[1] = (int)forehand;
		stats[2] = (int)backhand;
		stats[3] = (int)volly;
		
		switch (i) { //각 캐릭터별 능력치 저장하는 곳
		case 1:
			this.serve = serve = 100;
			this.forehand = forehand = 10;
			this.backhand = backhand = 10;
			this.volly = volly = -100;
			return stats;
			
		case 2:
			this.serve = serve = 10;
			this.forehand = forehand = 10;
			this.backhand = backhand = 10;
			this.volly = volly = 10;
			return stats;
			
		case 3:
			this.serve = serve = 10;
			this.forehand = forehand = 10;
			this.backhand = backhand = 10;
			this.volly = volly = 10;
			return stats;
			
		case 4:
			this.serve = serve = 10;
			this.forehand = forehand = 10;
			this.backhand = backhand = 10;
			this.volly = volly = 10;
			return stats;
		}
		return null;
		

		
	}

	
}
