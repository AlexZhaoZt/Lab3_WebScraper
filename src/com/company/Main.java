package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Main {


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
            } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }


    public static int wordCount(String content) {
        int word = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == ' ' || content.charAt(i) == '.' || content.charAt(i) == '\n') {
                word++;
            }
        }
        return word;
    }

    public static int specialWordCount(String content, String speWord) {
        int word = 0;
        int k;
        for (int i = 0; i < content.length(); i++) {
            for (k = i; k < content.length(); k++) {
                if (content.substring(i, k).contains(speWord)) {
                    word++;
                    i = k;
                    break;
                }
            }

        }
        return word;
    }

    public static void main(String[] args) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Please enter the URL you want me to scan:");
        String input = lineScanner.nextLine();
        System.out.println(urlToString(input));
        System.out.println("Total number of words is: " + wordCount(urlToString(input)));
        System.out.println("Please enter the word you want me to scan:");
        String theWord = lineScanner.nextLine();
        System.out.println("Number of that word is: " + specialWordCount(input, theWord));
    }


}
