package org.csystem.app.samples.ballfallgameapp;

public class BallFallGameApp {
	private BallFallGameApp()
	{
	}

	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Width?");
		int width = Integer.parseInt(kb.nextLine());
		
		System.out.print("Height?");
		int height = Integer.parseInt(kb.nextLine());
		
		BallGame ballGame = new BallGame();
		
		ballGame.play(width, height);
		System.out.println(ballGame.getResult());
	}
}
