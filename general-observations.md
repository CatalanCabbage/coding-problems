# Coding-problems

Coding problems attempted from Leetcode

## Useful snippets:
### General conversions:
`String` to `int` : `Integer.parseInt(str) //Primitive types can't use toString()` 
<br>`char[]` to `String` : `new String(char[])`

`int` to `String` : `String.valueOf(int)`

### General edge-cases:
`int`: 
 * negative numbers
 * `int` limit overflow/underflow (`Integer.MAX_VALUE` == 2,147,483,647)

   ```
   //So if you want to check if a + b > c where a and b are positive, 
   do (a + b > || a + b < 0) to handle overflow
   ```