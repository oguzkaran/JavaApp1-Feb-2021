/*----------------------------------------------------------------------------------------------------------------------
    Lotto sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.simulation.lotto;

import org.csystem.util.NumberUtil;

import java.util.Random;

public class Lotto {
	private final Random m_random;
	private boolean m_firstGameWinFlag;
	private boolean m_secondGameWinFlag;
	private boolean m_thirdGameWinFlag;

	private int getFirst()
	{
		return m_random.nextInt(99) + 1;
	}

	private int getSecond(int first)
	{
		int second;

		while ((second = m_random.nextInt(99) + 1) == first)
			;

		return second;
	}

	private int getThird(int first, int second)
	{
		int third;

		while ((third =  m_random.nextInt(99) + 1) == first || third == second)
			;

		return third;
	}

	private void playFirstGame(int first, int second, int third)
	{
		m_firstGameWinFlag = first + second + third < 150;
	}

	private void playSecondGame(int first, int second, int third)
	{
		m_secondGameWinFlag = NumberUtil.isPrime(first + second + third);
	}

	private void playThirdGame(int first, int second, int third)
	{
		int min = Math.min(first, Math.min(second,  third));
		int mid = NumberUtil.mid(first, second, third);
		int max = Math.max(first, Math.max(second,  third));

		m_thirdGameWinFlag = max - min > mid;
	}

	public Lotto()
	{
		m_random = new Random();
	}
	
	public Lotto(Random r)
	{
		m_random = r;
	}

	public boolean isFirstGameWin()
	{
		return m_firstGameWinFlag;
	}

	public boolean isSecondGameWin()
	{
		return m_secondGameWinFlag;
	}

	public boolean isThirdGameWin()
	{
		return m_thirdGameWinFlag;
	}

	public void playFirstGame()
	{
		int first = getFirst();
		int second = getSecond(first);
		int third = getThird(first, second);

		playFirstGame(first, second, third);
	}

	public void playSecondGame()
	{
		int first = getFirst();
		int second = getSecond(first);
		int third = getThird(first, second);

		playSecondGame(first, second, third);
	}

	public void playThirdGame()
	{
		int first = getFirst();
		int second = getSecond(first);
		int third = getThird(first, second);

		playThirdGame(first, second, third);
	}

	public void play()
	{
		int first = getFirst();
		int second = getSecond(first);
		int third = getThird(first, second);
		
		playFirstGame(first, second, third);
		playSecondGame(first, second, third);
		playThirdGame(first, second, third);
	}
}
