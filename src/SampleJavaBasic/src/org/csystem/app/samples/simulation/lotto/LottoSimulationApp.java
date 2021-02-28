package org.csystem.app.samples.simulation.lotto;

public class LottoSimulationApp {
	public static void displayProbabilities(int firstGameWinCount, int secondGameWinCount, int thirdGameWinCount, int n)
	{
		System.out.printf("p1=%f%n", (double) firstGameWinCount / n);
		System.out.printf("p2=%f%n", (double) secondGameWinCount / n);
		System.out.printf("p3=%f%n", (double) thirdGameWinCount / n);
	}
	
	public static void playGames(int n)
	{
		int firstGameWinCount = 0;		
		int secondGameWinCount = 0;
		int thirdGameWinCount = 0;
		
		Lotto lotto = new Lotto();
		
		for (int i = 0; i < n; ++i) {
			lotto.play();
			
			if (lotto.isFirstGameWin())
				++firstGameWinCount;
			
			if (lotto.isSecondGameWin())
				++secondGameWinCount;
			
			if (lotto.isThirdGameWin())
				++thirdGameWinCount;
		}		
		
		displayProbabilities(firstGameWinCount, secondGameWinCount, thirdGameWinCount, n);
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Kaç kez oynatmak istiyorsunuz?");
		int n = Integer.parseInt(kb.nextLine());
		
		playGames(n);
	}
}