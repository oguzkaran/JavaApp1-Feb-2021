/*----------------------------------------------------------------------------------------------------------------------
    CommandPrompt sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.commandpromptapp;

import org.csystem.util.StringUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandPrompt {
    private static final String [] COMMAND_STR = {"length", "reverse", "upper", "lower", "change", "clear", "get", "join"};
    private String m_prompt;
    private final Scanner m_kb;
    private final ArrayList m_list = new ArrayList();

    private static void lengthCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 2) {
            System.out.println("length bir tane argüman almalıdır");
            return;
        }

        System.out.println(cmdInfo[1].length());
    }

    private static void reverseCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 2) {
            System.out.println("reverse bir tane argüman almalıdır");
            return;
        }

        System.out.println(StringUtil.reverse(cmdInfo[1]));
    }

    private static void upperCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 2) {
            System.out.println("upper bir tane argüman almalıdır");
            return;
        }

        System.out.println(cmdInfo[1].toUpperCase());
    }

    private static void lowerCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 2) {
            System.out.println("lower bir tane argüman almalıdır");
            return;
        }

        System.out.println(cmdInfo[1].toLowerCase());
    }

    private void changeCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 2) {
            System.out.println("change bir tane argüman almalıdır");
            return;
        }

        m_prompt = cmdInfo[1];
    }

    private static void clearCommandProc(String [] cmdInfo)
    {
        for (int i = 0; i < 70; ++i)
            System.out.println();
    }

    private void doWorkForGetCommand()
    {
        for (;;) {
            System.out.print("Yazıyı giriniz:");
            String s = m_kb.nextLine();

            if ("exit".equals(s))
                break;

            m_list.add(s);
        }
    }

    private void getCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 1) {
            System.out.println("get argüman almamalıdır");
            return;
        }
        doWorkForGetCommand();
    }

    private void joinCommandProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 1 && cmdInfo.length != 2) {
            System.out.println("join için geçersiz argümanlar");
            return;
        }

        if (m_list.isEmpty()) {
            System.out.println("Liste boş");
            return;
        }

        String delimiter = cmdInfo.length == 1 ? " " : cmdInfo[1];
        String str = StringUtil.join(m_list, delimiter);
        System.out.println(str);
    }

    private static String getCommandByText(String text)
    {
        if (text.length() < 3)
            return "";

        for (int i = 0; i < COMMAND_STR.length; ++i)
            if (COMMAND_STR[i].startsWith(text))
                return COMMAND_STR[i];

        return "";
    }

    private void doWorkForCommand(String [] cmdInfo)
    {
        switch (cmdInfo[0]) {
            case "length":
                lengthCommandProc(cmdInfo);
                break;
            case "reverse":
                reverseCommandProc(cmdInfo);
                break;
            case "upper":
                upperCommandProc(cmdInfo);
                break;
            case "lower":
                lowerCommandProc(cmdInfo);
                break;
            case "change":
                changeCommandProc(cmdInfo);
                break;
            case "clear":
                clearCommandProc(cmdInfo);
                break;
            case "get":
                getCommandProc(cmdInfo);
                break;
            case "join":
                joinCommandProc(cmdInfo);
                break;
        }
    }

    private void parseCommand(String [] cmdInfo)
    {
        String cmdText = getCommandByText(cmdInfo[0]);

        if (!cmdText.isEmpty()) {
            cmdInfo[0] = cmdText;
            doWorkForCommand(cmdInfo);
        }
        else
            System.out.println("Geçersiz komut");
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
        m_kb = new Scanner(System.in);
    }

    public void run()
    {
        System.out.println("C ve Sistem Programcıları Derneği");

        for (;;) {
            System.out.print(m_prompt + ">");
            String cmd = m_kb.nextLine().trim();

            String [] cmdInfo = cmd.split("[ \t]+");

            if ("quit".equals(cmdInfo[0]))
                break;

            parseCommand(cmdInfo);
        }

        System.out.println("Tekrar yapıyor musunuz?");
        System.out.println("C ve Sistem Programcıları Derneği");
    }
}
