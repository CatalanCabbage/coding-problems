# Patterns
## Sliding window
> Find or calculate something among all the contiguous subarrays (or sublists) of a given size  
Keep increasing/decreasing window, while checking if the window passes requirements

Eg: Given an array/linkedList, find the average of all contiguous subarrays of size ‘K’ in it.  
Soln: Instead of calculating average of all elements each time, use the previous sum; just subtract the leftmost and add the new element.  

```
Basic algorithm:
- Add needed chars to a DS, say a Map or array
- Set counter = number of chars that need to match
- Keep incrementing right end, decreasing counter if it's something we need
- If counter == 0, it's a solution.
- Keep incrementing left end, increasing counter if it's something we need
   (because this is going out of our window)
```

---

## Two pointer
> Given an array of sorted numbers and a target sum,  
> find a pair in the array whose sum is equal to the given target.

```
Basic algorithm:
- Generally - sort the array
- Start a pointer from the left, another from the right
- Increase/decrease based on some condition
```

---

## Merge intervals
> Given an array of intervals where intervals[i] = [starti, endi], 
> merge all overlapping intervals and return an array of the non-overlapping intervals 
> that cover all the intervals in the input.

```
Basic algorithm:
- Sort by start or end time
- Loop through windows, performing operations
- Operations include comparing end of current with start of next, merging, etc
```

---

## Cyclic sort
> Given an unsorted integer array nums, return the smallest missing positive integer.
> Should run in O(n) time and use constant extra space.

```
Basic algorithm:
- Put each value in its index
- Iterate through to find mismatches
```

---

## Linked List
```
Basically know to:
- Use fast/slow pointer
- Find cyclic list
- Find point where cycle starts
```

## Tree DFS
>...tree has a root-to-leaf path...

```
Basic algorithm:
- Recursively call left and right children
- If needed, pass values up the nodes (bubbling)
```

## Two Heaps
> Given a list, find median
> Or a problem where max of an object is related to min of that object
```
Basic algorithm:
- Maintain 2 heaps, one maxHeap and one minHeap
- maxHeap contains first half of list, minHeap contains second half
- Insert elements while maintaining invariant
- Once done, compute median from top of heaps
```

## Subsets
> Permutations, combinations, subsets, knock yourself out  
```
Basic methods:
#1: Death by recursion
- Sort the incoming array in case it has duplicates
- For each entry: 
    - Add element to a temp list 
    - Add that list to solutions 
    - Recurse
    - Remove last element (so that alternate paths can be explored)

#2: Clone (for subsets)
- Add empty list to solution
- Clone all entries in solution, add current element to clones
- Do this for all entries
```

## Binary search
```
Base rules:
- Condition: while(lo <= hi)
- Calc mid:  mid = lo + (hi - lo) / 2
- if (target > nums[mid]) lo = mid + 1
- if (target < nums[mid]) hi = mid - 1

Changing any of the above must be double-checked, or might end up in an infinite-loop.
```

## Bitwise XOR
`n ^ n = 0`

## DP - Unbounded Knapsack
Given values of `n` items, put these items in a knapsack with a capacity `c`.  
Goal can be to get the max values, use minimum items, etc.  
We are allowed to use an infinite number of each item.  
```
- Decide base cases
- One recursion path taking current element into account
- One recursion path without taking current element into account
- Memoize return values of recursive function 
```

# ...Stuff
- Counter can be used to keep track of final result array size, etc.
- Don't forget Math.max() or Math.min() for results where needed
- Check base cases! 
- For each constraint (`if (a < x && b > y)`), check in which cases those constraints will be applicable to avoid redundancy.  
- Memoize when possible. Eg: If we need to find the max on the right side of an array, don't calculate everytime. (Ref: BestTimeToBuyAndSellStock)

## Finding palindromes
To check if a given sequence can be rearranged into a palindrome:  
Check if there are 2x of every char. If total length is odd, there can be 1 unique char.  
To make this easier:  
```java
Set<Character> charsSet = new HashSet<>();
//As we encounter each element
for (char c : characters) {
    //If already present in set, remove it since it forms a pair.
    //If not, it's unique, add it to the set.
    if (charsSet.contains(c)) {
        charsSet.remove(c);
    } else {
        charsSet.add(c);
    }
}

//Case 1: total size is odd, there needs to be a unique element.
//In this case, set will contain only 1 element.
//Case 2: total size is even, no unique elements.
return characters.length % 2 == charsSet.size();
```
Reference: `PseudoPalindromicPathsInABinaryTree.java`