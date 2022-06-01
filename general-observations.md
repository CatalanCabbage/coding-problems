# Coding-problems

Coding problems attempted from Leetcode

## Useful snippets:
### General conversions:
`String` to `int` : `Integer.parseInt(str) //Primitive types can't use toString()` 
<br>`char[]` to `String` : `new String(char[])`

`int` to `String` : `String.valueOf(int)`  
`int` to `BigInteger` : `BigInteger.valueOf(int)`. Cannot be cast directly!

`char` to `int` : `'c' - '0' //'0' to a number gives the ascii digit` 

Sort array with custom comparators: `Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]);`

### General edge-cases:
`int`: 
 * negative numbers
 * `int` limit overflow/underflow (`Integer.MAX_VALUE` == 2,147,483,647)

   ```
   //So if you want to check if a + b > c where a and b are positive, 
   do (a + b > c || a + b < 0) to handle overflow
   ```
   
### Hall of common-bug-fame:
* Remember to declare method arguments with datatype
* `Map` does not have `contains`, use `containsKey`

## Collections
### Queues
