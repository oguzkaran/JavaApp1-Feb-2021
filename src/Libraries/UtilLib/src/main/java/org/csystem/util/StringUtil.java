/*----------------------------------------------------------------------------------------------------------------------	
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Character.*;

public class StringUtil {
    private StringUtil()
    {
    }

    public static String capitalize(String s)
    {
        if (s.isBlank())
            return s;

        return toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String changeCase(String s)
    {
        var sb = new StringBuilder(s.length());

        var length = s.length();

        for (var i = 0; i < length; ++i) {
            char ch = s.charAt(i);

            sb.append(Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
        }

        return sb.toString();
    }

    public static int countString(String s1, String s2)
    {
        var count = 0;

        for (int index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
            ;

        return count;
    }

    public static String getLongestPalindrome(String s)
    {
        var result = "";

        var endIndex = s.length();

        while (endIndex != 0) {
            var beginIndex = 0;

            while (beginIndex != endIndex) {
                var str = s.substring(beginIndex++, endIndex);

                if (str.length() > 1 && isPalindrome(str) && str.length() > result.length())
                    result = str;
            }

            --endIndex;
        }

        return result;
    }

    public static String getRandomText(Random r, int n, String sourceText)
    {
        var length = sourceText.length();
        var chars = new char[n];

        for (var i = 0; i < n; ++i)
            chars[i] = sourceText.charAt(r.nextInt(length));

        return String.valueOf(chars);
    }

    public static String getRandomTextTR(Random r, int n)
    {
        return getRandomText(r, n, "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static String getRandomTextTR(int n)
    {
        return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n)
    {
        return getRandomText(r, n, "ABCDEFGHIJKLMNOPQRSTUWXVYZabcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextsTR(Random r, int n, int minLength, int maxLength)
    {
        StringBuilder sb = new StringBuilder();

        while (n-- > 0)
            sb.append(getRandomTextTR(r, r.nextInt(maxLength - minLength) + minLength));

        return sb.toString();
    }

    public static boolean isAllLetter(String s)
    {
        var length = s.length();

        for (var i = 0; i < length; ++i)
            if (!isLetter(s.charAt(i)))
                return false;

        return true;
    }

    public static boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char chLeft = toLowerCase(s.charAt(left));

            if (!isLetter(chLeft)) {
                ++left;
                continue;
            }

            char chRight = toLowerCase(s.charAt(right));

            if (!isLetter(chRight)) {
                --right;
                continue;
            }

            if (chLeft != chRight)
                return false;

            ++left;
            --right;
        }

        return true;
    }

    public static boolean isPangramTR(String text)
    {
        return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static boolean isPangramEN(String text)
    {
        return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangram(String text, String alphabet)
    {
        int length = alphabet.length();

        for (int i = 0; i < length; ++i)
            if (!text.contains(alphabet.charAt(i) + ""))
                return false;

        return true;
    }

    public static String join(String [] str, char delimiter)
    {
        return  join(str, delimiter + "");
    }

    public static String join(String [] str, String delimiter)
    {
        var result = new StringBuilder();

        for (var s : str)
            result.append(s).append(delimiter);

        return result.substring(0, result.length() - delimiter.length());
    }

    public static String join(ArrayList list, char delimiter)
    {
        return join(list, delimiter + "");
    }

    public static String join(ArrayList list, String delimiter)
    {
        String result = "";

        for (Object obj : list)
            result += (String)obj + delimiter;

        return result.substring(0, result.length() - delimiter.length());
    }

    public static String padLeading(String s, int length, char ch)
    {
        if (length <= s.length())
            return s;

        return (ch + "").repeat(length - s.length()) + s;
    }

    public static String padLeading(String s, int length)
    {
        return padLeading(s, length, ' ');
    }

    public static String padTrailing(String s, int length, char ch)
    {
        if (length <= s.length())
            return s;

        return s + (ch + "").repeat(length - s.length());
    }

    public static String padTrailing(String s, int length)
    {
        return padTrailing(s, length, ' ');
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String squeeze(String s1, String s2)
    {
        int length = s1.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            char ch = s1.charAt(i);

            if (s2.indexOf(ch) == -1)
                sb.append(ch);
        }

        return sb.toString();
    }

    public static String [] split(String str, String delimiters, StringSplitOptions stringSplitOptions)
    {
        StringBuilder pattern = new StringBuilder("[");

        int length = delimiters.length();

        for (int i = 0; i < length; ++i) {
            char delim = delimiters.charAt(i);

            pattern.append(delim == '[' || delim == ']' ? "\\" + delim : delim);
        }

        pattern.append(stringSplitOptions == StringSplitOptions.REMOVE_EMPTY_ENTRIES ? "]+" : "]");

        return str.split(pattern.toString());
    }

    public static String trimLeading(String s)
    {
        int i;
        int length = s.length();

        for (i = 0; i < length && isWhitespace(s.charAt(i)); ++i)
            ;

        return s.substring(i);
    }

    public static String trimTrailing(String s)
    {
        int i;

        for (i = s.length() - 1; i >= 0 && isWhitespace(s.charAt(i)); --i)
            ;

        return s.substring(0, i + 1);
    }
}