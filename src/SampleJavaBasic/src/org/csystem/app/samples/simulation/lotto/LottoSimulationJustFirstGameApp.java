package org.csystem.app.samples.simulation.lotto;

public class LottoSimulationJustFirstGameApp {
	public static void displayProbabilities(int firstGameWinCount, int n)
	{
		System.out.printf("p1=%f%n", (double) firstGameWinCount / n);
	}
	
	public static void playGames(int n)
	{
		int firstGameWinCount = 0;		

		Lotto lotto = new Lotto();
		
		for (int i = 0; i < n; ++i) {
			lotto.playFirstGame();
			
			if (lotto.isFirstGameWin())
				++firstGameWinCount;
		}		
		
		displayProbabilities(firstGameWinCount, n);
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Kaç kez oynatmak istiyorsunuz?");
		int n = Integer.parseInt(kb.nextLine());
		
		playGames(n);
	}
}