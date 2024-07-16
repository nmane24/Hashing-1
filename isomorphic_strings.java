


/*
Time Complexity : O(N) ; .... N is nothing but length of the string
Space Complexity :O(256) ~ O(1)  .... character array of size 256 is used, but its constant for all scenarios hence O(1)


Leetcode :  https://leetcode.com/problems/isomorphic-strings/ , https://leetcode.com/problems/word-pattern/description/

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving 
the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true

Code Explanation : We are using hashmap as the search operation in hashmap becomes O(1) compared to iterative seaarch in 
normal array
This solution uses two character HashMap
sMap stores character from s as a key and character from t as a value
tmap stores character from t as a key and character from s as a value.

We will use .get method of HashMap. if Key is not found in map then it is inserted; else if its present then its 
corresponding value is checked with other string character. If it is not matching that means strings are not isomorphic.


Side Note: The .containsv(value) function of hashmap works with O(n) complexity as we have to iterate through the map while 
finding the value ; so never use it. Compared to .get function which has a  time complexity of O(1)

We can implement this using two hashMaps, a hasmap & a hashSet and two arrays
*/

public class isomorphic_strings {

    //using two hashmaps
    // public boolean isIsomorphic(String s, String t){
    //     //check for base case
    //     if(s ==  null && t == null) return true;
    //     if(s == null || t == null) return false;
    //     if(s.length() != t.length()) return false;

    //     //Declare HashMap
    //     HashMap<Character, Character>sMap = new HashMap<>();
    //     HashMap<Character,Character> tMap = new HashMap<>();

    //     for (int i =0; i<s.length(); i++){
    //         char sChar = s.charAt(i);
    //         char tChar = t.charAt(i);

    //         if(sMap.containsKey(sChar)){
    //             if(sMap.get(sChar)!= tChar) return false;
    //         }
    //         else{
    //             sMap.put(sChar,tChar);
    //         }
    //         if(tMap.containsKey(tChar)){
    //             if(tMap.get(tChar)!= sChar) return false;
    //         }
    //         else{
    //             tMap.put(tChar, sChar);
    //         }
    //     }
    //     return true;
    // }


    //using a hashmap and a hashset

    // public boolean isIsomorphic(String s, String t){
    //     if(s == null && t == null) return true;
    //     if(s == null || t == null) return false;
    //     if(s.length() !=  t.length()) return false;

    //     HashMap<Character,Character> sMap =  new HashMap<>();
    //     HashSet<Character> tSet = new HashSet<>();

    //     for(int i = 0; i<s.length(); i ++){
    //         char sChar = s.charAt(i);
    //         char tChar = t.charAt(i);
    //         if(sMap.containsKey(sChar)){
    //             if(sMap.get(sChar)!= tChar) return false;
    //         }
    //         else{
    //             if(tSet.contains(tChar)) return false;
    //             else{
    //                 sMap.put(sChar, tChar);
    //                 tSet.add(tChar);
    //             }
    //         }
    //     }

    //     return true;
    // }



    //using two arrays
    public boolean isIsomorphic(String s, String t){
        if(s == null && t ==  null) return true;
        if(s ==null || t == null) return false;
        if(s.length() !=  t.length()) return false;

        char[] sMap = new char[256];
        char[] tMap = new char[256];

        for (int i = 0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap[sChar - ' ']!=0){  // get the index in the char array, it means we have a value there
                if(sMap[sChar - ' '] != tChar) return false;
            }
            else{
                sMap[sChar - ' '] = tChar;
            }
            if(tMap[tChar-' '] != 0){
                if(tMap[tChar - ' '] != sChar) return false;
            }
            else{
                tMap[tChar - ' '] = sChar;
            }
        }
        return true;

    }

}


