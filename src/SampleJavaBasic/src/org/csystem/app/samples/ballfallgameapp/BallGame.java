package org.csystem.app.samples.ballfallgameapp;

public class BallGame {
    private static boolean updateFlag(int ballIndex, boolean flag, int width)
    {
        if (ballIndex == 0)
            flag = true;
        else if (ballIndex == width - 1)
            flag = false;

        return flag;
    }

    private static int updateBallIndex(boolean flag, int ballIndex)
    {
        if (flag)
            return ballIndex + 1;

        return ballIndex - 1;
    }

    private String m_result;

    private void fillSpace(int begin, int end)
    {
        for (int i = begin; i < end; ++i)
            m_result += ' ';
    }

    private void fillBall(int ballIndex, int end)
    {
        fillSpace(0, ballIndex);
        m_result += '*';
        fillSpace(ballIndex + 1, end);
    }

    public BallGame()
    {
        m_result = "";
    }

    public String getResult()
    {
        return m_result;
    }

    public void play(int width, int height)
    {
        int ballIndex = 0;
        boolean flag = true;
        m_result = "";

        for (int i = 1; i <= height; ++i) {
            m_result += '|';

            fillBall(ballIndex, width);

            flag = updateFlag(ballIndex, flag, width);

            if (width != 1)
                ballIndex = updateBallIndex(flag, ballIndex);

            m_result += "|\r\n";
        }
    }
}