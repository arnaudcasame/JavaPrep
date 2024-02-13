## 2108. Find First Palindromic String in the Array

Given an array of strings `words`, _return the first **palindromic** string in the array._ If there is no such string, _return an empty string `""`_.

A string is **palindromic** if it reads the same forward and backward.

#### Example 1:
```java
Input: words = {"abc","car","ada","racecar","cool"}
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
```
#### Example 2:
```java
Input: words = {"notapalindrome","racecar"}
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".
```
#### Example 3:
```java
Input: words = {"def","ghi"}
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
```

#### Constraints:
- `1 <= words.length <= 100`
- `1 <= words[i].length <= 100`
- `words[i]` consists only of lowercase English letters.
