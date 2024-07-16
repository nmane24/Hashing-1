/*


Leetcode : https://leetcode.com/problems/group-anagrams/
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]


Example 3:
Input: strs = ["a"]
Output: [["a"]]


Code Explanation:
For Solution we have three methods 
1. Sort the string and see if they are equal or not. 
Maintain a map with key as sorted string and value will be array of strings which give the same sorting as key and thus are anagrams
Example : aarray = [ate, eat, tan, tea, nat]

{
aet : [ate, eat, tea]
ant: [tan, nat]
}

Time Complexity : O(n * k * log k)
  O(n) because we are iterating through each element
  k = average length of each string within array, 
  n : length of the array,
 logk is for sorting the strings and as we are sorting all the strings we have klogk.

 Space Complexity: n * k;
 n is number of elements and k is average size of string
// We should consider character length for string problems.

2. Getting a frequency map
3. Checking for the prime factor of the characters and calculating their product. 

We have taken product and not sum as summ can result into two string which are not anagram.

We do this using hashmap
Each string element is sorted using in built sort function for string.
This sorted string is used as a key and string element is stored as a value in hashmap.

Everytime, there is collision i.e. multiple values present for same key; we will push the
element in the vector which is maintained as a value.

Example : aarray = [ate, eat, tan, tea, nat]

{
200: [eat, ate, tea]
500 : [tan, nat]
}

/ Time Complexity : O(n * k)
//                   ... O(n) because we are iterating through each element
//                   ... O(k) as we are ierating through each character on each string element; avg k is lenght of each string
// Space Complexity : n * k

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class group_anagrams {
    //Using sorting of string
    // public List<List<String>> groupAnagrams(String[] strs){

    //     List<List<String>>result = new ArrayList<>();
    //     if(strs == null || strs.length == 0) return result;
    //     HashMap<String, List<String>>map = new HashMap<>();  //key is sorted string , and values are list of strings
    //     for(int i = 0; i< strs.length; i++){ //n
    //         String s = strs[i];
    //         char[] charArr = s.toCharArray(); // converting it to first character array to be able to sort later
    //         Arrays.sort(charArr);         //klogk    // now sort the char Array
    //         String sorted = String.valueOf(charArr); // convert char array back to string after sorting
    //         if(! map.containsKey(sorted)){ //O(k)
    //             map.put(sorted, new ArrayList<>());
    //         }
    //         map.get(sorted).add(s); // Data structure in a data structyre is always a refrence
    //     }

    //     return new ArrayList<>(map.values()); //O(n)
    // }

    //using prime factor as key
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();

        if(strs == null || strs.length ==0 )return  result;
        HashMap<Double,List<String>> hMap = new HashMap<>();
        for(int i = 0; i<strs.length; i++){ //n
            String s = strs[i];
            double primeProduct =  primeProduct(s);
            if(!hMap.containsKey(primeProduct)){ //O(k)
                hMap.put(primeProduct, new ArrayList<>());
            }
            hMap.get(primeProduct).add(s);
        }
        return new ArrayList<>(hMap.values()); //O(n)
    }

    private double  primeProduct(String s){
        int primes[]={ 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109};
        double result = 1;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            result =  result * primes[c -'a'];
        }
        return result;
    }





}
