//CREATED: ALEXANDER LEE 05/14/2018

import java.io.*;
import java.util.*;
import java.util.Scanner.*;
import java.util.List.*;
import java.util.Hashtable.*;

class Anagram 
{
    String word;
    
    //Char array constructor
    public Anagram(char[] word) 
    {
        String str = String.valueOf(word);
        init(str);
    }
    
    //String constructor
    public Anagram(String word)
    {
        init(word);
    }
    
    //Initializes anagram type
    public void init(String word) 
    {
        this.word = word;
    }
    
    //Prints anagram
    public void print() 
    {
        for (int i = 0; i < word.length(); i++) 
        {
            System.out.print(word.charAt(i));
        }    
    }
    
    //Compares two words to see if they are anagrams
    public boolean compare(Anagram word2, Hashtable <Character, Integer> h)
    {
        char c1;
        char c2;
        int charVal1;
        int charVal2;
        int wordVal1 = 1;
        int wordVal2 = 1;
        
        //Don't need to go through hashtable if string length not equal
        if (word.length() != word2.word.length()) 
        {
            print();
            System.out.print(" & ");
            word2.print();
            System.out.print(" are not anagrams");
            return false;
        }
        
        //Map hashtable if word lengths equal
        for (int i = 0; i < word.length(); i++) 
        {
            c1 = word.charAt(i);
            c2 = word2.word.charAt(i);
            charVal1 = h.get(c1);
            charVal2 = h.get(c2);
            wordVal1 = wordVal1 * charVal1;
            wordVal2 = wordVal2 * charVal2;
        }
        //Print if anagram
        if (wordVal1 == wordVal2) 
        {
            print();
            System.out.print(" & ");
            word2.print();
            System.out.print(" are anagrams");
            return true;
        }
        //Print if not anagram
        print();
        System.out.print(" & ");
        word2.print();
        System.out.print(" are not anagrams");
        return false;
    }
    
    //Returns anagram word
    public String returnWord() 
    {
        return word;
    }    
}

