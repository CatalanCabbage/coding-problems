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