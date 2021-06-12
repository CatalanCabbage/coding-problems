# Patterns
## Sliding window
> Find or calculate something among all the contiguous subarrays (or sublists) of a given size  

Eg: Given an array/linkedList, find the average of all contiguous subarrays of size ‘K’ in it.  
Soln: Instead of calculating average of all elements each time, use the previous sum; just subtract the leftmost and add the new element.  
