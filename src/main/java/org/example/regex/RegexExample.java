package org.example.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {
        System.out.println("Create a regular expression that accepts 10 digit numeric characters starting with 1, 2 or 3 only.");
        System.out.println("Regex Using character classes and quantifiers");

        System.out.println(Pattern.matches("[123]{1}[0-9]{9}", "1953038949"));
        System.out.println(Pattern.matches("[123][0-9]{9}", "1993038949"));

        System.out.println(Pattern.matches("[123][0-9]{9}", "9950389490"));
        System.out.println(Pattern.matches("[123][0-9]{9}", "695338949"));
        System.out.println(Pattern.matches("[123][0-9]{9}", "885338949"));

        System.out.println("Regex Using Metacharacters");
        System.out.println(Pattern.matches("[123]{1}\\d{9}", "2885338949"));
        System.out.println(Pattern.matches("[123]{1}\\d{9}", "685308949"));

        String[] lines = "Write a regex to split String by new line?".split("\\r?\\n");
        System.out.println(Arrays.asList(lines));

        //How to extract a substring using regex ?
        String data = "This is a test String and 'This is data we want'";
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        Pattern pattern1 = Pattern.compile("\\d");
        String test = "JavaInUse123";
        Matcher m = pattern1.matcher(test);

        System.out.println(m.find());
        System.out.println(m.matches());

        String s = "sadda23243523dfadwfdfasd %^32434 32fggefv".replaceAll("[^A-Za-z0-9]", "");
        System.out.println(s);


    }
}
