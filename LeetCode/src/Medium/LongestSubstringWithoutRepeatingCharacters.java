package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int maxLength = 0;
        Map<Character, Integer> positionMap = new HashMap<Character, Integer>();
        int trailingIndex = 0;
        Integer oldLocationOfi = null;
        int i;
        for (i = 0; i < s.length(); i++) {
            oldLocationOfi = positionMap.put(s.charAt(i), i);
            //Inserting new Element in Map
            if (oldLocationOfi != null) {
                length = i - trailingIndex;
                //trailing index cannot go back
                trailingIndex = oldLocationOfi + 1 < trailingIndex ? trailingIndex : oldLocationOfi + 1;
                maxLength = Math.max(length, maxLength);
            }

        }
        //Case of no Duplicate chars
        length = i - trailingIndex;
        return max(length, maxLength);

    }

    public static int lengthOfLongestSubstringUsingDirectHash(String s) {
        int length = 0;
        int maxLength = 0;
        int[] array = new int[256];
        Arrays.fill(array,-1);
        int trailingIndex = 0;
        int oldLocationOfi = -1;
        int i;
        for (i = 0; i < s.length(); i++) {
            oldLocationOfi = array[s.charAt(i)];
            //Inserting new Element in Map
            if (oldLocationOfi != -1) {
                length = i - trailingIndex;
                //trailing index cannot go back
                trailingIndex = oldLocationOfi + 1 < trailingIndex ? trailingIndex : oldLocationOfi + 1;
                maxLength = Math.max(length, maxLength);
                //Update new location in Array
                array[s.charAt(i)] =i;
            } else {
                array[s.charAt(i)] =i;
            }

        }
        //Case of no Duplicate chars
        length = i - trailingIndex;
        return max(length, maxLength);

    }
    public static void main(String[] args) {
        String s1 = "abcabcabc"; //3
        String s2 = "abcdefgh"; //8
        String s3 = "abcwabcprstuvwzyz"; //12
        String s4 = "abcwabcyuioplkjhzn"; //15
        String s5 = "cdd"; //2
        System.out.println(lengthOfLongestSubstringUsingDirectHash(s1));
        System.out.println(lengthOfLongestSubstringUsingDirectHash(s2));
        System.out.println(lengthOfLongestSubstringUsingDirectHash(s3));
        System.out.println(lengthOfLongestSubstringUsingDirectHash(s4));
        System.out.println(lengthOfLongestSubstringUsingDirectHash(s5));

    }
}
