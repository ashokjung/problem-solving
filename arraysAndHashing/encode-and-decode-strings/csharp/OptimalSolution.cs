using System;
using System.Collections.Generic;
using System.Text;

 public class OptimalSolution{
    public static void Main(string[] args){
        string[] input = new string[] {"neet","code","love","you"};
        string[] input1 = new string[] {"we","say",":","yes"};
        List<string> decodedList = new List<string>();
        OptimalSolution solution = new OptimalSolution();
        List<string> inputList = new List<string>(input);
        List<string> inputList1 = new List<string>(input1);
        string encodedString = solution.encode(inputList);
        Console.WriteLine("Encoded String: " + encodedString);
        decodedList = solution.decode(encodedString);
        Console.WriteLine("Decoded List: " + string.Join(", ", decodedList));
        decodedList.Clear();
        string encodedString1 = solution.encode(inputList1);
        Console.WriteLine("Encoded String: " + encodedString1);
        decodedList = solution.decode(encodedString1);
        Console.WriteLine("Decoded List: " + string.Join(", ", decodedList));
    }

    public string encode(List<string> strs){
        StringBuilder result = new StringBuilder();
        foreach(string s in strs){
            result.Append(s.Length).Append('#').Append(s);
        }
        return result.ToString();
    }

    public List<string> decode(string str){
        List<string> result = new List<string>();
        int i = 0;  
        while(i < str.Length){
            int j = str.IndexOf('#', i);
            int length = int.Parse(str.Substring(i, j - i));
            result.Add(str.Substring(j + 1, length));
            i = j + 1 + length;
        }
        return result;
    }
 }

