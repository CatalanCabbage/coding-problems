# Patterns
## Sliding window
> Find or calculate something among all the contiguous subarrays (or sublists) of a given size  
Keep increasing/decreasing window, while checking if the window passes requirements

Eg: Given an array/linkedList, find the average of all contiguous subarrays of size ‘K’ in it.  
Soln: Instead of calculating average of all elements each time, use the previous sum; just subtract the leftmost and add the new element.  

```
Basic algorithm:
- Add needed chars to a DC, say a Map or array
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

