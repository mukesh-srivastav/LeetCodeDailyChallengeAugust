/**
 * Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

 */
public class Day26_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        
        for (int i = 1; i<=n; i++) {
            String item = ""; 
            if (i%3 == 0)
                item = "Fizz";
            if (i%5 == 0)
                item = item + "Buzz";
            
            if (item.length() == 0)
                item = String.valueOf(i);
            
            res.add(item);
        }
        
        return res;
    } 
}