# Python tips
```python
# sort string
sorted("cba") # gives ["a", "b", "c"]
str(sorted("cba")) # "abc"

# can be used for dict too, will take and return keys
# lambda to define sort property
freq_dict = {"a": 4, "b": 3, "c": 5}
sorted(freq_dict, key:lambda num: freq_dict[num], reverse=True) # [c, a, b]
```