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
- Always use `a % 2 != 0` to find odd numbers - `a % 2 == 1` won't work for negative numbers.

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

-----

# Design patterns
## Creational
### Singleton
One object common for all

### Factory
Generate objects depending on the requirement  
Eg: DC/MDM API Factory Provider

### AbstractFactory
???

### Builder
Add props as needed.  
Eg: Streams where you can call `.map()` `.filter()` etc repeatedly.

### Prototype
Avoids the overhead of object creation and initialization by cloning a common object for new requests.  
Eg: `User` object creation involves getting roles, personalization settings etc. We can create one per user and keep it.  
If a new `DCUser` is needed, we clone `User` and add whatever extra needs to be added to make it `DCUser`.


## Structural
### Adapter
Change object of one type to another.  
Eg: Convert array into `List`, `Set` etc

### Composite
Treat all child objects the same as parent  
Eg: Flutter components or HTML structure, like nodes in a tree.  
Ever node is a part of the tree but can be considered a tree in itself too individually.

### Proxy
Provides a surrogate or placeholder for a real image.  
Eg: Like we do for Cached objects, checking DB only if the cached image is `null`.

### Flyweight
Like a factory for objects when storing them separately each time might be expensive.  
Eg: Fonts where we need to store data for each character.  
We generate an object for each letter and store it. The class will then return a cached object instead.  

### Decorator
Takes an object and adds more data to that object.  
Eg: `BufferedReader(new FileReader(filePath)))` where `BufferedReader` "decorates" `FileReader`

## Behavioral
### Template
Abstract class provides a skeleton, concrete class provides an implemetation.  
Eg: Interfaces

### Mediator
Sits in the middle of communication, encapsulating objects.

### Chain of responsibility
Decouples sender from receiver. A handler holds references to the order of concrete handlers to be invoked, someone handles it in the end.  
Eg: Tomcat filters

### Observer
Similar to chain of responsibility, but many listeners do their own changes.  
There's one main object and observers are notified when changes happen.  
Eg: Listeners

### Strategy
An interface or abstract class defines a set of methods indicating algorithmic flows.  
During runtime, the optimal implementation is chosen.  
Eg: Maybe hashing algo when FIPS is enabled vs disabled

### Command
Encapsulates the request with an object that has necessary actions.  
Consumer doesn't need to know actions, they can just call `execute()` or something.

### State
Allows behavior to change dynamically based on state.

### Memento
Allows objects to capture and rollback to different states.

-----
# DB normalization forms:  
Why?  
- Prevent read anomalies (due to lack of a single source of truth)
- Prevent update anomalies (same as above)
- Prevent delete anomalies (same as above)
- Accuracy
- Reduce storage space
- Run queries fast

## 1NF
There shouldn't be duplicate rows.  
There should be a primary key.

## 2NF
Value of each column should be dependent on the PK.  
Eg: in `user_id, user_name, user_location, user_location_address`, location and address don't depend directly on the PK.  
Make it a separate table and use FKs or a mapping table.

## 3NF
Has no transitive functional dependency. ie., everything should depend directly on the PK.  
Eg: `user_id, user_name, user_location, user_zip` - `user_zip` depends on `user_location` which depends on `user_id`.    
So `user_zip` can be moved to a separate table.  

## 4NF
There should be no multi-valued dependency.  
Eg: `Restaurant 	Pizza Variety 	Delivery Area` - Variety doesn't depend on Area. Store them separately.















