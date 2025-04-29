# Python tips
```python
### sorting
sorted("cba") # ["a", "b", "c"]
str(sorted("cba")) # "abc"

# can be used for dict too, will take and return keys
# lambda to define sort property
freq_dict = {"c": 5, "b": 3, "a": 2}
sorted(freq_dict, key:lambda num: freq_dict[num], reverse=True) # [c, a, b]
sorted(freq_dict) # [a, b, c] - just sorts keys


```