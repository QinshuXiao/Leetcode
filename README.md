# Leetcode
## Some nonsense
~~Well, It's May 2018, I graduated last week, but I'm still seeking a job. I'm jobless right now .....~~

WOW, time is flying! It's May 2019, I have worked as a software engineer for Gemalto for around 1 year. Most of my work is to implement UI components for desktop App in Windows using WPF. I don't have lots of chances to touch data structure and algorithm .... I come back because I find out I have to keep familiar with data structures and algorithms and make sure I still have ability to solve algorithm problem quickly, because I never know when the next interview will come... I don't want to pass any opportunities. All I can do is to make sure I am fully prepared when the next chance is coming. 
  
**Trust The Process**

## Top interview problem
Question | Done Date | Code | Note |
----|----|-----|----|
[1. Two Sum](https://leetcode.com/problems/two-sum/description/) | 2018/5/28 | [Here](src/TwoSum.java) | Two ways: 1. sorting + two pointers; 2. HashMap |
[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/) | 2018/6/1 | [Here](src/AddTwoNumbers.java) | two pointers, advacend bit |
[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) | 2018/6/4 | [Here](src/LongestSubstringWithoutRepeatingCharacters.java) | Two pointers + Boolean array recording character appearing in s[slow:fast] |
[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/) | 2018/6/6 | [Here](src/LongestPalindromicSubstring.java) | Two pointers |
[6. ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/) | 2019/6/3 | [Java](src/ZigZagConversion.java) | generate result strings level by level |
[8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/description/) | 2018/6/6 | [Here](src/StringtoInteger.java) | Edge cases: 1. leading blanks; 2. '+' or '-'; 3. Integer overflow |
[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/description/) | 2018/6/7 | [Here](src/RegularExpressionMatching.java) | DP |
[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/) | 2018/5/21 | [Here](src/containerWithMostWater.java) | Two Pointer |
[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/description/) | 2018/6/4 | [Here](src/RomantoInteger.java) | Math logic |
[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/) | 2018/6/5 | [Here](src/LongestCommonPrefix.java) | Pointer to specify index we're at + vertical iteration and comparation |
[15. 3Sum](https://leetcode.com/problems/3sum/description/) | 2018/5/28 | [Here](src/ThreeSum.java) | Classical Sorting + two pointers |
[17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/) | 2018/6/6 | [Here](src/LetterCombinationsofaPhoneNumber.java) | Backtracking |
[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/) | 2018/6/1 | [Here](src/RemoveNthNodeFromEndofList.java) | two pointers |
[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/) | 2018/6/6 | <ul><li>[java](src/ValidParentheses.java)</li><li>[javascript](src/JavaScript/ValidParentheses.js)</li></ul> | Stack |
[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/) | 2018/5/22 | [Here](src/MergeTwoSortedLists.java) | Two Pointer, Merge sort |
[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/description/) | 2018/6/6 | [Here](src/GenerateParentheses.java) | Backtracking |
[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/description/) | 2018/6/2 | [Here](src/MergekSortedLists.java) | Priority Queue |
[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/) | 2018/5/25 | [Here](src/RemoveDuplicatesfromSortedArray.java) | Two pointers |
[28. Implement strStr()](https://leetcode.com/problems/implement-strstr/description/) | 2018/6/5 | [Here](src/ImplementstrStr.java) | Using java built-in substring() and equals() |
[31. Next Permutation](https://leetcode.com/problems/next-permutation/) | 2019/5/27 | [Java](src/NextPermutation.java) | find the element which is left of the last peak idx, then find the first element which is larger than nums[left] from the end. Swap them then reverse the array from the last peak to the end |
[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/) | 2018/5/22 | [Here](src/SearchinRotatedSortedArray.java) | Binary Search |
[34. Search for a Range](https://leetcode.com/problems/search-for-a-range/description/) | 2018/5/26 | [Here](src/SearchRange.java) | Binary search |
[38. Count and Say](https://leetcode.com/problems/count-and-say/description/) | 2018/6/6 | [Here](src/CountandSay.java) | Operation of StringBuilder |
[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/description/) | 2018/5/21 | [Here](src/firstMissingPositive.java) | Using Index space |
[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | 2019/6/6 | [Java](src/TrappingRainWater.java) | 2-way iteration:the first round is from left to right; the second round is from right to left |
[44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/description/) | 2018/6/7 | [Here](src/WildcardMatching.java) | DP |
[46. Permutations](https://leetcode.com/problems/permutations/) | 2019/5/27 | [Java](src/Permutations.java) | Backtracking: enumerate every possibilities at each index |
[48. Rotate Image](https://leetcode.com/problems/rotate-image/description/) | 2018/5/27 | [Here](src/RotateImage.java) | Four pointer to denote four points on which we need to operate |
[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/) | 2018/6/5 | [Here](src/GroupAnagrams.java) | HashMap; Firstly sort the string |
[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/) | 2018/5/22 | [Here](src/MaximumSubarray.java) | DP |
[54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/description/) | 2018/5/26 | [Here](src/SpiralMatrix.java) | Four pointers to denote boundaries |
[55. Jump Game](https://leetcode.com/problems/jump-game/description/) | 2018/5/21 | [Here](src/JumpGame.java) | DP |
[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/description/) | 2018/5/21 | [Here](src/MergeIntervals.java) | Sorting + Greedy |
[60. Permutation Sequence](https://leetcode.com/problems/permutation-sequence/) | 2019/5/27 | [Java](src/PermutationSequence.java) | given an array with 1 to n. After idx i, there are (n-i-1)! permutations. Then we can compute the number at idx i one by one ( k / (n-i-1)! ) |
[62. Unique Paths](https://leetcode.com/problems/unique-paths/description/) | 2018/5/28 | [Here](src/UniquePaths.java) | Classical DP |
[66. Plus One](https://leetcode.com/problems/plus-one/description/) | 2018/5/28 | [Here](src/PlusOne.java) | Advanced bit |
[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/description/) | 2018/6/30 | [Here](src/Sqrtx.java) | Binary Search |
[72. Edit Distance](https://leetcode.com/problems/edit-distance/) | 2019/5/18 | [Here](src/EditDistance.java) | Classical DP |
[73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/) | 2018/5/25 | [Here](src/SetMatrixZeroes.java) | Take use of original matrix space |
[75. Sort Colors](https://leetcode.com/problems/sort-colors/description/) | 2018/5/26 | [Here](src/SortColors.java) | Two pointer |
[76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/) | 2018/6/4 | [Here](src/MinimumWindowSubstring.java) | Same as above |
[78. Subsets](https://leetcode.com/problems/subsets/description/) | 2018/5/25 | [Here](src/Subsets.java) | Backtracking (general way to solve subsets problem) |
[79. Word Search](https://leetcode.com/problems/word-search/description/) | 2018/5/22 | [Here](src/WordSearch.java) | DFS |
[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/description/) | 2018/5/26 | [Here](src/LargestRectangleinHistogram.java) | For each number, find longest range in which it's the minimum with the help of **stack** |
[87. Scramble String](https://leetcode.com/problems/scramble-string/) | 2018/5/14 | [Java](src/ScrambleString.java) | DFS: Suppose we are standing at index i. string A is scramble string of string B if:<ul> <li>isScramble(A[0,i], B[0,i]) && isScramble(A[i, end], B[i, end]</li></ul> Or:<ul><li>  isScramble(A[0,i], B[end-i, end]) && isScramble(A[i, end], B[0, end-i]</li> </ul> |
[90. Subsets II](https://leetcode.com/problems/subsets-ii/description/) | 2018/5/25 | [Here](src/SubsetII.java) | Sort + Backtracking |
[91. Decode Ways](https://leetcode.com/problems/decode-ways/description/) | 2018/6/4 | [Here](src/DecodeWays.java) | DP, edge cases, care about '0' |
[94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/) | 2018/6/10 | [Here](src/BinaryTreeInorderTraversal.java) | Do DFS on Binary Tree. Visit left subtree firstly, then visit root, finally visit right subtree |
[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/) | 2018/6/10 | [Here](src/ValidateBinarySearchTree.java) | From bottom to top. Firstly check left subtree, then check right subtree, finally check root. |
[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/) | 2018/6/11 | [Here](src/SymmetricTree.java) | <ul><li>Recursion.</li> <li>isMirror(left.right, right.left) && isMirror(left.left, right.right) && left.val == right.val</li></ul> |
[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/) | 2018/6/10 | [Here](src/BinaryTreeLevelOrderTraversal.java) | Using Queue to do BFS |
[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/) | 2018/6/8 | [Here](src/BinaryTreeZigzagLevelOrderTraversal.java) | Queue + boolean flag |
[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/) | 2018/6/11 | [Here](src/MaximumDepthofBinaryTree.java) | BFS using Queue |
[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/) | 2018/5/28 | [Here](src/ConstructBinaryTreefromPreorderandInorderTraversal.java) | logic behind preorder and inorder |
[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/) | 2018/6/11 | [Here](src/ConvertSortedArraytoBinarySearchTree.java) | Recursion + Property of **BALANCED** BST |
[116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/) | 2018/6/11 | [Here](src/PopulatingNextRightPointersinEachNode.java) | <ul><li>Iteration. Do BFS</li><li>Recursion. connect Left Subtree, then connect right subtree, finally connect right boundary of left subtree with left boundary of right subtree.</li></ul> |
[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/) | 2018/5/29 | [Here](src/BestTimetoBuyandSellStock.java) | DP |
[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/) | 2018/5/29 | [Here](src/BestTimetoBuyandSellStockII.java) | DP |
[123. Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/) | 2018/5/31 | [Here](src/BestTimetoBuyandSellStockIII.java) | DP |
[124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/) | 2018/6/11 | [Here](src/BinaryTreeMaximumPathSum.java) | <ul><li>DP on Tree.</li> <li>Recursive function returns local maximum of path sum which passed through root.</li> <li>We passed a global variable in recursive function, where we possibly update global maximum.</li></ul> |
[125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/) | 2018/6/4 | [Here](src/ValidPalindrome.java) | Two pointers, one is moving forward while the other is moving backward |
[127. Word Ladder](https://leetcode.com/problems/word-ladder/description/) | 2018/6/14 | [Here](src/WordLadder.java) | Change one character in string to build a new string. BFS |
[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/) | 2018/5/21 | [Here](src/LongestConsecutiveSequence.java) | HashMap |
[130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/description/) | 2018/6/13 | [Here](src/SurroundedRegions.java) | DFS + Mark out node which's not killed |
[131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/description/) | 2018/6/12 | [Here](src/PalindromePartitioning.java) | DP for checking and finding Palindrome string. Backtracking for partitioning palindrome string. |
[134. Gas Station](https://leetcode.com/problems/gas-station/description/) | 2018/7/12 | [Here](src/GasStation.java) | Greedy. We need to find the peak of fuel "need" (the need of i is cost[i]-gas[i]). If we can run around a circuit successfully, the start point should be the next index of "need" peek. But if at the end the accumulated need is larger than 0, we cannot complete a circuit. |
[136. Single Number](https://leetcode.com/problems/single-number/description/) | 2018/7/11 | [Here](src/SingleNumber.java) | XOR |
[137. Single Number II](https://leetcode.com/problems/single-number-ii/description/) | 2018/7/12 | [Here](src/SingleNumberII.java) | Bitwise + State Machine |
[138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/description/) | 2018/6/2 | [Here](src/CopyListwithRandomPointer.java) | Firstly, copy label and put new generated node right behind original node; Then copy random pointer; Finally, extract copied nodes and reset original list |
[139. Word Break](https://leetcode.com/problems/word-break/description/) | 2018/7/12 | [Here](src/WordBreak.java) | DP: DP[i] denotes whether we can break s[0:i-1] |
[140. Word Break II](https://leetcode.com/problems/word-break-ii/) | 2019/6/6 | [Java](src/WordBreakII.java) | <ul><li>Used DP to find if we can break words. DP[i] stores all index j such that s.substring(j,i) exists in wordDict</li><li>Generated result strings using DFS</li></ul> |
[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/) | 2018/6/1 | [Here](src/LinkedListCycle.java) | Two pointers, one moves forward by 2 steps while the other moves forward by 1 step. |
[146. LRU Cache](https://leetcode.com/problems/lru-cache/) | 2019/5/15 | [Java](src/LRUCache.java) | <ul><li>Bidirection linked list as container</li> <li>Using hashMap to store key : node of linked list </li> <li>the tail of linked list will be removed when cache is full</li> <li> new coming value will go into the head of the list</li> <li>The most recent visit value will be extracted from the list and put to the head of the list</li> </ul>  |
[148. Sort List](https://leetcode.com/problems/sort-list/description/) | 2018/6/2 | [Here](src/SortList.java) | Merge Sort |
[149. Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/description/) | 2018/7/8 | [Here](src/MaxPointsonaLine.java) | <ul><li>1. Use HashMap to store "slope"</li><li>2. Normalized diffY and diffX based on their GCD. And generated a String as key in the HashMap, inorder to deal with Double's precision problem.</li></ul> |
[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/) | 2018/7/11 | [Here](src/EvaluateReversePolishNotation.java) | Using Stack to store number we met. Each time we meet an operator, We do a computation on the top two numbers, then we push the result back to the top of stack. |
[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/) | 2018/5/21 | [Here](src/MaximumProductSubarray.java) | DP |
[155. Min Stack](https://leetcode.com/problems/min-stack/description/) | 2018/7/9 | [Here](src/MinStack.java) | Each time we push a new item, we need to push current Minimal value alongside. |
[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/description/) | 2018/6/1 | [Here](src/IntersectionofTwoLinkedLists.java) | Two pointers, finding entry point of the circular list |
[162. Find Peak Element](https://leetcode.com/problems/find-peak-element/description/) | 2018/5/24 | [Here](src/FindPeakElement.java) | Binary Search |
[163. Missing Ranges](https://leetcode.com/problems/missing-ranges/description/) | 2018/5/23 | [Here](src/MissingRanges.java) | Iteration, edge cases |
[166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/description/) | 2018/7/6 | [Here](src/FractiontoRecurringDecimal.java) | 1. Using recursion to compute decimal 2. Using hashmap to deal with infinite circulating decimal |
[169. Majority Element](https://leetcode.com/problems/majority-element/description/) | 2018/5/21 | [Here](src/MajorityElement.java) | Candidate + Count |
[188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/) | 2018/5/31 | [Here](src/BestTimetoBuyandSellStockIV.java) | DP |
[189. Rotate Array](https://leetcode.com/problems/rotate-array/description/) | 2018/5/23 | [Here](src/RotateArray.java) | General way to rotate array (3 reverse) |
[190. Reverse Bits](https://leetcode.com/problems/reverse-bits/description/) | 2018/6/18 | [Here](src/ReverseBits.java) | <ul><li>Iteration + Bit Operation</li><li>Divide & Conquer</li></ul> |
[198. House Robber](https://leetcode.com/problems/house-robber/description/) | 2018/7/8 | [Here](src/HouseRobber.java) | Easy DP |
[200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/) | 2018/7/9 | [Here](src/NumberofIslands.java) | Two solutions:<ul><li>1. Using DFS to "clear" a island when we meet an new island. However, this solution requires us to modify the input grid map</li><li>2. If we are not allowed to modify grid map, Get help from Union Find</li></ul> |
[202. Happy Number](https://leetcode.com/problems/happy-number/description/) | 2018/7/12 | [Here](src/HappyNumber.java) | Iteration + Using HashSet to record number we've met. |
[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/) | 2018/6/1 | [Here](src/ReverseLinkedList.java) | Two ways: 1. recursion; 2. pinpoint tail, and then continuously move head to the next of tail, until tail is head. |
[207. Course Schedule](https://leetcode.com/problems/course-schedule/description/) | 2018/6/13 | [Here](src/CourseSchedule.java) | Topo sort |
[208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/description/) | 2018/6/21 | [Here](src/Trie.java) | Fundamental implementation of Trie |
[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/description/) | 2018/6/13 | [Here](src/CourseScheduleII.java) | Topo Sort |
[212. Word Search II](https://leetcode.com/problems/word-search-ii/description/) | 2018/6/19 | [Here](src/WordSearchII.java) | Trie Tree stores dictionary, DFS searches words in mtx |
[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/) | 2018/6/21 | [Here](src/KthLargestElementinanArray.java) | <ul><li>Priority Queue</li><li>Quick select (partition in QuickSort)</li></ul> |
[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/) | 2018/5/29 | [Here](src/ContainsDuplicate.java) | 1. Sorting; 2. HashSet |
[224. Basic Calculator](https://leetcode.com/problems/basic-calculator/description/) | 2018/6/7 | [Here](src/BasicCalculator.java) | <ul><li>Recursion</li><li>Or using math logics</li></ul> |
[227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/description/) | 2018/6/7 | [Here](src/BasicCalculatorII.java) | Stack, reverse polish expression |
[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/) | 2018/6/10 | [Here](src/KthSmallestElementinaBST.java) | Do Binary Search on BST. It's just like do DFS on BST, so that we can visit nodes in order. And we record how many nodes we have visited, and once we visited Kth node, we return it. |
[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/) | 2018/5/22 | [Here](src/PalindromeLinkedList.java) | Two Pointer, find half point in Linkedlist |
[236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/) | 2018/6/11 | [Here](src/LowestCommonAncestorofaBinaryTree.java) | Recursion + From Bottom to top |
[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/description/) | 2018/6/1 | [Here](src/DeleteNodeinaLinkedList.java) | Set node's value to next node's value. Like the way we use to delete a value in the array |
[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | 2019/5/20 | [Java](src/SlidingWindowMaximum.java) | <ul><li>Using **PriorityQueue** to store the elements with its idx within the window [O(nlogk)]</li><li>Using **Deque** to store the idx of elements within the window [O(n)]</li></ul> |
[242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/) | 2018/7/6 | [Here](src/ValidAnagram.java) | <ul>Two solutions:<li>1. Sort two Strings, and then compare them.</li><li>2. Using Array to store appearances of each character</li></ul> |
[251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/description/) | 2018/6/12 | [Here](src/Flatten2DVector.java) | Index to show we're at the Col-th element in the Row-th list. When moving forward col and row, we need to care about empty list |
[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/description/) | 2018/7/3 | [Here](src/MeetingRoomsII.java) | 1st solution: Using TreeMap; 2nd Solution: using priority queue |
[266. Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation/) | 2019/5/27 | [Java](src/PalindromePermutation.java) | If only one character appears odd times, then the string can be converted to a palindrome. |
[267. Palindrome Permutation II](https://leetcode.com/problems/palindrome-permutation-ii/) | 2019/5/27 | [Java](PalindromePermutationII.java) | Determine if a string can be converted to palindromes + backtracking to generate palindromes |
[268. Missing Number](https://leetcode.com/problems/missing-number/description/) | 2018/5/23 | [Here](src/MissingNumber.java) | Using index space! |
[269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/description/) | 2018/6/18 | [Here](src/AlienDictionary.java) | Topo Sort |
[283. Move Zeroes](https://leetcode.com/problems/move-zeroes/description/) | 2018/5/22 | [Here](src/MoveZeroes.java) | Two Pointer |
[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst/description/) | 2018/6/10 | [Here](src/InorderSuccessorinBST.java) | do recursion along with passing a upperRight node |
[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/description/) | 2018/5/22 | [Here](src/FindDuplicateNumber) | Binary Search (Brilliant!) |
[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/) | 2018/6/22 | [Here](src/MedianFinder.java) | Two PriorityQueues: maxHeap + minHeap |
[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/) | 2018/6/12 | [Here](src/SerializeandDeserializeBinaryTree.java) | Borrow ideas from Heap |
[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/) | 2018/6/14 | [Here](src/LongestIncreasingSubsequence.java) | Build LIS. Use binary search to find the lowerBoundIdx in the LIS when we meet an new number |
[309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/) | 2018/5/31 | [Here](src/BestTimetoBuyandSellStockwithCooldown.java) | DP |
[315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/) | 2018/6/13 | [Here](src/CountofSmallerNumbersAfterSelf.java) | Get helps from Merge Sort |
[322. Coin Change](https://leetcode.com/problems/coin-change/description/) | 2018/6/12 | [Here](src/CoinChange.java) | DP |
[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/description/) | 2018/6/2 | [Here](src/OddEvenLinkedList.java) | put nodes in one list to another list |
[329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/) | 2018/6/18 | [Here](src/LongestIncreasingPathinaMatrix.java) | DFS + Memoization |
[334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/) | 2018/6/20 | [Here](src/IncreasingTripletSubsequence.java) | Borrow Idea from **300. Longest Increasing Subsequence**. If one sequence contains Increasing Triple Subsequence, it means this array contains at least one increasing subsequence with 3 numbers. |
[340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/) | 2018/6/4 | [Here](src/LongestSubstringwithAtMostKDistinctCharacters.java) | <ul><li>Two pointers to delimit substring;</li> <li>HashMap to record how many different character appear in substring, and record number of appearances of each character</li></ul> |
[344. Reverse String](https://leetcode.com/problems/reverse-string/description/) | 2018/6/5 | [Here](src/ReverseString.java) | Easiest |
[378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/) | 2018/6/12 | [Here](src/KthSmallestElementinaSortedMatrix.java) | Two ways: <ul><li>PriorityQueue: Put element into PQ, along with each element, we also record their coordinates(x, y)</li><li>Binary Search: Just like the solution of **41. First Missing Positive**, We do binary search on values space of elements in matrix </li></ul> |
[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/description/) | 2018/5/29 | [Here](src/InsertDeleteGetRandomOone.java) | ArrayList + HashMap + record index in hashmap |
[381. Insert Delete GetRandom O(1) - Duplicates allowed](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/) | 2018/5/30 | [Here](src/InsertDeleteGetRandomDuplicatesOone.java) | ArrayList + HashMap + record indexes using linkedlist |
[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/description/) | 2018/7/1 | [Here](src/ShuffleanArray.java) | How to shuffle an array? For each index i from array.length-1 to 0, you can find an random number j ranged from [0, i], then swap array[i] and array[j] |
[387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/description/) | 2018/6/4 | [Here](src/FirstUniqueCharacterinaString.java) | Using array to store appearance of lowercase character |
[454. 4Sum II](https://leetcode.com/problems/4sum-ii/description/) | 2018/6/13 | [Here](src/FourSumII.java) | Recall HashMap way in 2Sum. Turn 4Sum to 2Sum. See A[i]+B[j] as one, and C[k]+D[l] as the other. |
[526. Beautiful Arrangement](https://leetcode.com/problems/beautiful-arrangement/) | 2019/5/30 | [Java](src/BeautifulArrangement.java) | Classical backtracking solution |
[675. Cut Off Trees for Golf Event](https://leetcode.com/problems/cut-off-trees-for-golf-event/) | 2019/6/2 | [Java](src/CutOffTreesforGolfEvent.java) | <ul><li>Using priorityqueue to sort the trees by their heights.</li><li>Cut the next tree one by one. Computing the distance between the current pos and the next tree's pos using BFS</li></ul> |
[695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | 2019/5/14 | [Java](MaxAreaofIsland.java) | Follow up to [the number of islands](https://leetcode.com/problems/number-of-islands/). Using DFS to find an island and count the area, and **eliminate** it.  |
[712. Minimum ASCII Delete Sum for Two Strings](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/) | 2019/5/18 | [Here](src/MinimumASCIIDeleteSumforTwoStrings.java) | It is very similar to [72. EditDistance](src/EditDistance.java). Classical DP |
[771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/) | 2019/5/20 | [Java](src/JewelsAndStones.java) | Using array to store the existance of characters |
[772. Basic Calculator III](https://leetcode.com/problems/basic-calculator-iii/description/) | 2018/6/7 | [Here](src/BasicCalculatorIII.java) | <ul><li>Recursion to solve embedded expression closed by '()'</li><li>Stack to solve operators with diffrent priority</li></ul> |
[841. Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/) | 2019/5/15 | [Java](src/KeysAndRooms.java) | <ul><li>Firstly convert the input string to a hashMap <room : [keys]>, which represents a graph structure</li><li>Classic DFS, nothing special. Using a boolean array to determine if a room is visiting or not</li></ul> |
[851. Loud and Rich](https://leetcode.com/problems/loud-and-rich/)| 2019/5/16 | [Java](src/LoudAndRich.java)| <ul><li>the richness among people can be converted into a tree(using hashMap)</li><li>Then go through each person, populate the quietist person from top to bottom: If a node is quieter than the value which children nodes has stored, then update the answer for that children node and continue populating the result for the children nodes of that node</li></ul> |
[872. Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/) | 2019/5/16 | <ul><li>[Java](src/LeafSimilarTree.js)</li><li>[JavaScript](JavaScript/LeafSimilarTree.js)</li></ul> | Using **DFS** to generate leaves string, then do comparison. |
[909. Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/) | 2019/6/2 | [Java](src/SnakesAndLadders.java) | BFS variance. Need to jump if a grid touch ladder or snake |
[931. Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/) | 2019/6/3 | [Java](src/MinimumFallingPathSum.java) | Classical DP |
[934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/) | 2019/5/18 | [Java](src/ShortestBridge.java) | Another variance of [Number of islands](https://leetcode.com/problems/number-of-islands/). Still using DFS to find islands. And because there are only 2 islands, we can mark the found island using '1' and '2'. Then using DFS to find the shortest bridge between 2 islands. <li>Small performance improvement tip: if we use a hashset to store the locations of island 2, we can know if a bridge reaches island 2 in O(1) when we are doing DFS</li>|
[937. Reorder Log Files](https://leetcode.com/problems/reorder-log-files/) | 2019/5/21 | [Java](src/ReorderLogFiles.java) | Sorting with customized comparator. |
[957. Prison Cells After N Days](https://leetcode.com/problems/prison-cells-after-n-days/) | 2019/5/23 | [Java](src/PrisonCellsAfterNDays.java) | Math : Find the cycle of states |
[983. Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/) | 2019/5/31 | [Java](src/MinimumCostForTickets.java) | DP: res[i]represents the minimal costs at day i ending with 1-day pass([0]), ending with 7-day pass([1]), ending with 30-day pass([2]). Only update DP matrix for the day we travel, otherwise just directly copy the previous day's result |
[984. String Without AAA or BBB](https://leetcode.com/problems/string-without-aaa-or-bbb/) | 2019/5/30 | [Java](src/StringWithoutAAAorBBB.java) | Greedy algorithm:<ul><li>Always put the character which has left more into the result firstly.</li><li>If we've already put 2 consective identical characters, then put the other one instead.</li></ul> |
[1053. Previous Permutation With One Swap](https://leetcode.com/problems/previous-permutation-with-one-swap/) | 2019/5/27 | [Java](src/PreviousPermutationWithOneSwap.java) | Reversed processing of *Next Permutation*. Find the bottom from the end firstly, the left element of the bottom is the element we need to change (called it bigger element). Then find out the first element which is slower than the bigger element from the end. Then swap them. |


## Array
Question | Done Date | Code | Note |
----|----|-----|-----|
[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/) | 2018/5/21 | [Here](src/containerWithMostWater.java) | Two pointer |
[16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/description/) | 2018/5/21 | [Here](src/threeSumClosest.java) | Sorting |
[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/description/) | 2018/5/21 | [Here](src/firstMissingPositive.java) | Using Index space |
[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/) | 2018/5/21 | [Here](src/ProductExceptSelf.java) | DP |
[169. Majority Element](https://leetcode.com/problems/majority-element/description/) | 2018/5/21 | [Here](src/MajorityElement.java) |Candidate + Count |
[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/) | 2018/5/21 | [Here](src/MaximumProductSubarray.java) | DP |
[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/description/) | 2018/5/21 | [Here](src/MergeIntervals.java) | Sorting + Greedy |
[55. Jump Game](https://leetcode.com/problems/jump-game/description/) | 2018/5/21 | [Here](src/JumpGame.java) | DP |
[153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/) | 2018/5/21 | [Here](src/FindMinimuminRotatedSortedArray.java) | Binary Search |
[154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/) | 2018/5/21 | [Here](src/FindMinimuminRotatedSortedArrayII.java) | Binary Search |
[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/) | 2018/5/21 | [Here](src/LongestConsecutiveSequence.java) | HashMap |
[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/) | 2018/5/22 | [Here](src/SearchinRotatedSortedArray.java) | Binary Search |
[81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/) | 2018/5/22 | [Here](src/SearchinRotatedSortedArrayII.java) | Binary Search |
[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/) | 2018/5/22 | [Here](src/MaximumSubarray.java) | DP |
[283. Move Zeroes](https://leetcode.com/problems/move-zeroes/description/) | 2018/5/22 | [Here](src/MoveZeroes.java) | Two Pointer |
[79. Word Search](https://leetcode.com/problems/word-search/description/) | 2018/5/22 | [Here](src/WordSearch.java) | DFS |
[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/description/) | 2018/5/22 | [Here](src/FindDuplicateNumber) | Binary Search (Brilliant!) |
[268. Missing Number](https://leetcode.com/problems/missing-number/description/) | 2018/5/23 | [Here](src/MissingNumber.java) | Using index space! |
[163. Missing Ranges](https://leetcode.com/problems/missing-ranges/description/) | 2018/5/23 | [Here](src/MissingRanges.java) | Iteration, edge cases |
[189. Rotate Array](https://leetcode.com/problems/rotate-array/description/) | 2018/5/23 | [Here](src/RotateArray.java) | General way to rotate array (3 reverse) |
[162. Find Peak Element](https://leetcode.com/problems/find-peak-element/description/) | 2018/5/24 | [Here](src/FindPeakElement.java) | Binary Search |
[78. Subsets](https://leetcode.com/problems/subsets/description/) | 2018/5/25 | [Here](src/Subsets.java) | Backtracking (general way to solve subsets problem) |
[90. Subsets II](https://leetcode.com/problems/subsets-ii/description/) | 2018/5/25 | [Here](src/SubsetII.java) | Sort + Backtracking |
[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/) | 2018/5/25 | [Here](src/RemoveDuplicatesfromSortedArray.java) | Two pointers |
[73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/) | 2018/5/25 | [Here](src/SetMatrixZeroes.java) | Take use of original matrix space |
[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/description/) | 2018/5/26 | [Here](src/LargestRectangleinHistogram.java) | For each number, find longest range in which it's the minimum with the help of **stack** |
[75. Sort Colors](https://leetcode.com/problems/sort-colors/description/) | 2018/5/26 | [Here](src/SortColors.java) | Two pointer |
[34. Search for a Range](https://leetcode.com/problems/search-for-a-range/description/) | 2018/5/26 | [Here](src/SearchRange.java) | Binary search |
[54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/description/) | 2018/5/26 | [Here](src/SpiralMatrix.java) | Four pointers to denote boundaries |
[48. Rotate Image](https://leetcode.com/problems/rotate-image/description/) | 2018/5/27 | [Here](src/RotateImage.java) | Four pointer to denote four points on which we need to operate |
[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/) | 2018/5/28 | [Here](src/ConstructBinaryTreefromPreorderandInorderTraversal.java) | logic behind preorder and inorder |
[66. Plus One](https://leetcode.com/problems/plus-one/description/) | 2018/5/28 | [Here](src/PlusOne.java) | Advanced bit |
[1. Two Sum](https://leetcode.com/problems/two-sum/description/) | 2018/5/28 | [Here](src/TwoSum.java) | Two ways: 1. sorting + two pointers; 2. HashMap |
[15. 3Sum](https://leetcode.com/problems/3sum/description/) | 2018/5/28 | [Here](src/ThreeSum.java) | Classical Sorting + two pointers |
[62. Unique Paths](https://leetcode.com/problems/unique-paths/description/) | 2018/5/28 | [Here](src/UniquePaths.java) | Classical DP |
[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/) | 2018/5/29 | [Here](src/ContainsDuplicate.java) | 1. Sorting; 2. HashSet |
[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/) | 2018/5/29 | [Here](src/BestTimetoBuyandSellStock.java) | DP |
[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/) | 2018/5/29 | [Here](src/BestTimetoBuyandSellStockII.java) | DP |
[123. Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/) | 2018/5/31 | [Here](src/BestTimetoBuyandSellStockIII.java) | DP |
[188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/) | 2018/5/31 | [Here](src/BestTimetoBuyandSellStockIV.java) | DP |
[309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/) | 2018/5/31 | [Here](src/BestTimetoBuyandSellStockwithCooldown.java) | DP |
[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/description/) | 2018/5/29 | [Here](src/InsertDeleteGetRandomOone.java) | ArrayList + HashMap + record index in hashmap |
[381. Insert Delete GetRandom O(1) - Duplicates allowed](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/) | 2018/5/30 | [Here](src/InsertDeleteGetRandomDuplicatesOone.java) | ArrayList + HashMap + record indexes using linkedlist |
[689. Maximum Sum of 3 Non-Overlapping Subarrays](https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/) | 2018/6/1 | [Here](src/MaximumSumof3NonOverlappingSubarrays.java) | DP, variance of Best Time to Buy and Sell Stocks |
[251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/description/) | 2018/6/12 | [Here](src/Flatten2DVector.java) | Index to show we're at the Col-th element in the Row-th list. When moving forward col and row, we need to care about empty list |
[131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/description/) | 2018/6/12 | [Here](src/PalindromePartitioning.java) | DP for checking and finding Palindrome string. Backtracking for partitioning palindrome string. |
[315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/) | 2018/6/13 | [Here](src/CountofSmallerNumbersAfterSelf.java) | Get helps from Merge Sort |
[454. 4Sum II](https://leetcode.com/problems/4sum-ii/description/) | 2018/6/13 | [Here](src/FourSumII.java) | Recall HashMap way in 2Sum. Turn 4Sum to 2Sum. See A[i]+B[j] as one, and C[k]+D[l] as the other. |
[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/) | 2018/6/14 | [Here](src/LongestIncreasingSubsequence.java) | Build LIS. Use binary search to find the lowerBoundIdx in the LIS when we meet an new number |
[269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/description/) | 2018/6/18 | [Here](src/AlienDictionary.java) | Topo Sort |
[334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/description/) | 2018/6/20 | [Here](src/IncreasingTripletSubsequence.java) | Borrow Idea from **300. Longest Increasing Subsequence**. If one sequence contains Increasing Triple Subsequence, it means this array contains at least one increasing subsequence with 3 numbers. |
[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/) | 2018/6/21 | [Here](src/KthLargestElementinanArray.java) | <ul><li>Priority Queue</li><li>Quick select (partition in QuickSort)</li></ul> |
[845. Longest Mountain in Array](https://leetcode.com/problems/longest-mountain-in-array/description/) | 2018/6/25 | [Here](src/LongestMountaininArray.java) | Two Pointers way: <ul><li>Firstly find the peak (_be careful about the platform, which is not the actual peak_)</li><li>Secondly find the bottom</li></ul>|
[719. Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/) | 2018/6/25 | [Here](src/FindKthSmallestPairDistance.java) | Binary Search on space of possible answers: We can know minimal distance and maximal distance from sorted array, then binary search to find k-th distance. |
[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/description/) | 2018/7/1 | [Here](src/ShuffleanArray.java) | How to shuffle an array? For each index i from array.length-1 to 0, you can find an random number j ranged from [0, i], then swap array[i] and array[j] |
[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/description/) | 2018/7/3 | [Here](src/MeetingRoomsII.java) | 1st solution: Using TreeMap; 2nd Solution: using priority queue |
[198. House Robber](https://leetcode.com/problems/house-robber/description/) | 2018/7/8 | [Here](src/HouseRobber.java) | Easy DP |
[134. Gas Station](https://leetcode.com/problems/gas-station/description/) | 2018/7/12 | [Here](src/GasStation.java) | Greedy. We need to find the peak of fuel "need" (the need of i is cost[i]-gas[i]). If we can run around a circuit successfully, the start point should be the next index of "need" peek. But if at the end the accumulated need is larger than 0, we cannot complete a circuit. |
[771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/) | 2019/5/20 | [Java](src/JewelsAndStones.java) | Using array to store the existance of characters |
[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | 2019/5/20 | [Java](src/SlidingWindowMaximum.java) | <ul><li>Using **PriorityQueue** to store the elements with its idx within the window [O(nlogk)]</li><li>Using **Deque** to store the idx of elements within the window [O(n)]</li></ul> |
[937. Reorder Log Files](https://leetcode.com/problems/reorder-log-files/) | 2019/5/21 | [Java](src/ReorderLogFiles.java) | Sorting with customized comparator. |
[46. Permutations](https://leetcode.com/problems/permutations/) | 2019/5/27 | [Java](src/Permutations.java) | Backtracking: enumerate every possibilities at each index |
[31. Next Permutation](https://leetcode.com/problems/next-permutation/) | 2019/5/27 | [Java](src/NextPermutation.java) | find the element which is left of the last peak idx, then find the first element which is larger than nums[left] from the end. Swap them then reverse the array from the last peak to the end |
[60. Permutation Sequence](https://leetcode.com/problems/permutation-sequence/) | 2019/5/27 | [Java](src/PermutationSequence.java) | given an array with 1 to n. After idx i, there are (n-i-1)! permutations. Then we can compute the number at idx i one by one ( k / (n-i-1)! ) |
[1053. Previous Permutation With One Swap](https://leetcode.com/problems/previous-permutation-with-one-swap/) | 2019/5/27 | [Java](src/PreviousPermutationWithOneSwap.java) | Reversed processing of *Next Permutation*. Find the bottom from the end firstly, the left element of the bottom is the element we need to change (called it bigger element). Then find out the first element which is slower than the bigger element from the end. Then swap them. |
[526. Beautiful Arrangement](https://leetcode.com/problems/beautiful-arrangement/) | 2019/5/30 | [Java](src/BeautifulArrangement.java) | Classical backtracking solution |
[983. Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/) | 2019/5/31 | [Java](src/MinimumCostForTickets.java) | DP: res[i]represents the minimal costs at day i ending with 1-day pass([0]), ending with 7-day pass([1]), ending with 30-day pass([2]). Only update DP matrix for the day we travel, otherwise just directly copy the previous day's result |
[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | 2019/6/6 | [Java](src/TrappingRainWater.java) | 2-way iteration:the first round is from left to right; the second round is from right to left |


## Linked List
Question | Done Date | Code | Note |
----|----|-----|-----|
[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/) | 2018/5/22 | [Here](src/PalindromeLinkedList.java) | Two Pointer, find half point in Linkedlist |
[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/) | 2018/5/22 | [Here](src/MergeTwoSortedLists.java) | Two Pointer, Merge sort |
[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/) | 2018/6/1 | [Here](src/RemoveNthNodeFromEndofList.java) | two pointers |
[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/) | 2018/6/1 | [Here](src/AddTwoNumbers.java) | two pointers, advacend bit |
[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/description/) | 2018/6/1 | [Here](src/IntersectionofTwoLinkedLists.java) | Two pointers, finding entry point of the circular list |
[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/) | 2018/6/1 | [Here](src/LinkedListCycle.java) | Two pointers, one moves forward by 2 steps while the other moves forward by 1 step. |
[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/description/) | 2018/7/3 | [Here](src/LinkedListCycleII.java) | <ul><li>Firstly, use **fast-pointer & slow-pointer** to find whether there are cycle in linkedlist</li><li>Then we find entry of that cycle by:<ul><li>Start by head pointer and current slow pointer, they move forward by one step each time.</li><li>The node where they meet each other is the entry of cycle.</li></ul></li></ul> |
[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/description/) | 2018/6/1 | [Here](src/DeleteNodeinaLinkedList.java) | Set node's value to next node's value. Like the way we use to delete a value in the array |
[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/) | 2018/6/1 | [Here](src/ReverseLinkedList.java) | Two ways: 1. recursion; 2. pinpoint tail, and then continuously move head to the next of tail, until tail is head. |
[148. Sort List](https://leetcode.com/problems/sort-list/description/) | 2018/6/2 | [Here](src/SortList.java) | Merge Sort |
[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/description/) | 2018/6/2 | [Here](src/OddEvenLinkedList.java) | put nodes in one list to another list |
[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/description/) | 2018/6/2 | [Here](src/MergekSortedLists.java) | Priority Queue |
[138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/description/) | 2018/6/2 | [Here](src/CopyListwithRandomPointer.java) | Firstly, copy label and put new generated node right behind original node; Then copy random pointer; Finally, extract copied nodes and reset original list |
[143. Reorder List](https://leetcode.com/problems/reorder-list/description/) | 2018/6/22 | [Here](src/ReorderList.java) | <ul><li>Find middle node and tail node</li><li>Reverse list from middle node to tail</li><li>merge two lists: one is from head to half, the other is leading by tail.</li></ul> |
[147. Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/description/) | 2018/6/23 | [Here](src/InsertionSortList.java) | Insertion Sort |
[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/description/) | 2018/6/23 | [Here](src/SwapNodesinPairs.java) | Operations on Linked List: **Swap two nodes**  |
[92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/description/) | 2018/7/1 | [Here](src/ReverseLinkedListII.java) | Firstly determine start point and end point. Then reverse |


## String

Question | Done Date | Code | Note |
----|----|-----|-----|
[408. Valid Word Abbreviation](https://leetcode.com/problems/valid-word-abbreviation/description/) | 2018/6/3 | [Here](src/ValidWordAbbreviation.java) | convert string to char array; Two pointers; Extract numeric string and convert it to number |
[125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/) | 2018/6/4 | [Here](src/ValidPalindrome.java) | Two pointers, one is moving forward while the other is moving backward |
[91. Decode Ways](https://leetcode.com/problems/decode-ways/description/) | 2018/6/4 | [Here](src/DecodeWays.java) | DP, edge cases, care about '0' |
[387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/description/) | 2018/6/4 | [Here](src/FirstUniqueCharacterinaString.java) | Using array to store appearance of lowercase character |
[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/description/) | 2018/6/4 | [Here](src/RomantoInteger.java) | Math logic |
[340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/) | 2018/6/4 | [Here](src/LongestSubstringwithAtMostKDistinctCharacters.java) | <ul><li>Two pointers to delimit substring;</li> <li>HashMap to record how many different character appear in substring, and record number of appearances of each character</li></ul> |
[76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/) | 2018/6/4 | [Here](src/MinimumWindowSubstring.java) | Same as above |
[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) | 2018/6/4 | [Here](src/LongestSubstringWithoutRepeatingCharacters.java) | Two pointers + Boolean array recording character appearing in s[slow:fast] |
[344. Reverse String](https://leetcode.com/problems/reverse-string/description/) | 2018/6/5 | [Here](src/ReverseString.java) | Easiest |
[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/) | 2018/6/5 | [Here](src/GroupAnagrams.java) | HashMap; Firstly sort the string |
[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/) | 2018/6/5 | [Here](src/LongestCommonPrefix.java) | Pointer to specify index we're at + vertical iteration and comparation |
[28. Implement strStr()](https://leetcode.com/problems/implement-strstr/description/) | 2018/6/5 | [Here](src/ImplementstrStr.java) | Using java built-in substring() and equals() |
[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/) | 2018/6/6 | [Here](src/ValidParentheses.java) | Stack |
[38. Count and Say](https://leetcode.com/problems/count-and-say/description/) | 2018/6/6 | [Here](src/CountandSay.java) | Operation of StringBuilder |
[8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/description/) | 2018/6/6 | [Here](src/StringtoInteger.java) | Edge cases: 1. leading blanks; 2. '+' or '-'; 3. Integer overflow |
[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/) | 2018/6/6 | [Here](src/LongestPalindromicSubstring.java) | Two pointers |
[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/description/) | 2018/6/6 | [Here](src/GenerateParentheses.java) | Backtracking |
[17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/) | 2018/6/6 | [Here](src/LetterCombinationsofaPhoneNumber.java) | Backtracking |
[44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/description/) | 2018/6/7 | [Here](src/WildcardMatching.java) | DP |
[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/description/) | 2018/6/7 | [Here](src/RegularExpressionMatching.java) | DP |
[224. Basic Calculator](https://leetcode.com/problems/basic-calculator/description/) | 2018/6/7 | [Here](src/BasicCalculator.java) | <ul><li>Recursion</li><li>Or using math logics</li></ul> |
[227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/description/) | 2018/6/7 | [Here](src/BasicCalculatorII.java) | Stack, reverse polish expression |
[772. Basic Calculator III](https://leetcode.com/problems/basic-calculator-iii/description/) | 2018/6/7 | [Here](src/BasicCalculatorIII.java) | <ul><li>Recursion to solve embedded expression closed by '()'</li><li>Stack to solve operators with diffrent priority</li></ul> |
[844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/description/) | 2018/6/25 | [Here](src/BackspaceStringCompare.java) | Go from tail to head. If meet '#', then skip previous non-'#' character |
[242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/) | 2018/7/6 | [Here](src/ValidAnagram.java) | <ul>Two solutions:<li>1. Sort two Strings, and then compare them.</li><li>2. Using Array to store appearances of each character</li></ul> |
[139. Word Break](https://leetcode.com/problems/word-break/description/) | 2018/7/12 | [Here](src/WordBreak.java) | DP: DP[i] denotes whether we can break s[0:i-1] |
[87. Scramble String](https://leetcode.com/problems/scramble-string/) | 2018/5/14 | [Java](src/ScrambleString.java) | DFS: Suppose we are standing at index i. string A is scramble string of string B if:<ul> <li>isScramble(A[0,i], B[0,i]) && isScramble(A[i, end], B[i, end]</li></ul> Or:<ul><li>  isScramble(A[0,i], B[end-i, end]) && isScramble(A[i, end], B[0, end-i]</li> </ul> |
[72. Edit Distance](https://leetcode.com/problems/edit-distance/) | 2019/5/18 | [Here](src/EditDistance.java) | Classical DP: DP[i][j] represents the edit distance between word1[0...i) and word2[0...j) |
[712. Minimum ASCII Delete Sum for Two Strings](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/) | 2019/5/18 | [Here](src/MinimumASCIIDeleteSumforTwoStrings.java) | It is very similar to [72. EditDistance](src/EditDistance.java). Classical DP |
[266. Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation/) | 2019/5/27 | [Java](src/PalindromePermutation.java) | If only one character appears odd times, then the string can be converted to a palindrome. |
[267. Palindrome Permutation II](https://leetcode.com/problems/palindrome-permutation-ii/) | 2019/5/27 | [Java](PalindromePermutationII.java) | Determine if a string can be converted to palindromes + backtracking to generate palindromes |
[984. String Without AAA or BBB](https://leetcode.com/problems/string-without-aaa-or-bbb/) | 2019/5/30 | [Java](src/StringWithoutAAAorBBB.java) | Greedy algorithm:<ul><li>Always put the character which has left more into the result firstly.</li><li>If we've already put 2 consective identical characters, then put the other one instead.</li></ul> |
[140. Word Break II](https://leetcode.com/problems/word-break-ii/) | 2019/6/6 | [Java](src/WordBreakII.java) | <ul><li>Used DP to find if we can break words. DP[i] stores all index j such that s.substring(j,i) exists in wordDict</li><li>Generated result strings using DFS</li></ul> |

## Tree
Question | Done Date | Code | Note |
----|----|-----|-----|
[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/) | 2018/5/28 | [Here](src/ConstructBinaryTreefromPreorderandInorderTraversal.java) | logic behind preorder and inorder |
[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/) | 2018/6/8 | [Here](src/BinaryTreeZigzagLevelOrderTraversal.java) | Queue + boolean flag |
[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/) | 2018/6/10 | [Here](src/BinaryTreeLevelOrderTraversal.java) | Using Queue to do BFS |
[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/) | 2018/6/10 | [Here](src/KthSmallestElementinaBST.java) | Do Binary Search on BST. It's just like do DFS on BST, so that we can visit nodes in order. And we record how many nodes we have visited, and once we visited Kth node, we return it. |
[94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/) | 2018/6/10 | [Here](src/BinaryTreeInorderTraversal.java) | Do DFS on Binary Tree. Visit left subtree firstly, then visit root, finally visit right subtree |
[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst/description/) | 2018/6/10 | [Here](src/InorderSuccessorinBST.java) | do recursion along with passing a upperRight node |
[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/) | 2018/6/10 | [Here](src/ValidateBinarySearchTree.java) | From bottom to top. Firstly check left subtree, then check right subtree, finally check root. |
[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/) | 2018/6/11 | [Here](src/SymmetricTree.java) | <ul><li>Recursion.</li> <li>isMirror(left.right, right.left) && isMirror(left.left, right.right) && left.val == right.val</li></ul> |
[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/) | 2018/6/11 | [Here](src/MaximumDepthofBinaryTree.java) | BFS using Queue |
[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/) | 2018/6/11 | [Here](src/ConvertSortedArraytoBinarySearchTree.java) | Recursion + Property of **BALANCED** BST |
[116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/) | 2018/6/11 | [Here](src/PopulatingNextRightPointersinEachNode.java) | <ul><li>Iteration. Do BFS</li><li>Recursion. connect Left Subtree, then connect right subtree, finally connect right boundary of left subtree with left boundary of right subtree.</li></ul> |
[235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/) | 2018/6/11 | [Here](src/LowestCommonAncestorofaBinarySearchTree.java) | Recursion + Property of BST |
[236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/) | 2018/6/11 | [Here](src/LowestCommonAncestorofaBinaryTree.java) | Recursion + From Bottom to top |
[124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/) | 2018/6/11 | [Here](src/BinaryTreeMaximumPathSum.java) | <ul><li>DP on Tree.</li> <li>Recursive function returns local maximum of path sum which passed through root.</li> <li>We passed a global variable in recursive function, where we possibly update global maximum.</li></ul> |
[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/) | 2018/6/12 | [Here](src/SerializeandDeserializeBinaryTree.java) | Borrow ideas from Heap |
[127. Word Ladder](https://leetcode.com/problems/word-ladder/description/) | 2018/6/14 | [Here](src/WordLadder.java) | Change one character in string to build a new string. BFS |
[208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/description/) | 2018/6/21 | [Here](src/Trie.java) | Fundamental implementation of Trie |
[872. Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/) | 2019/5/16 | <ul><li>[Java](src/LeafSimilarTree.js)</li><li>[JavaScript](JavaScript/LeafSimilarTree.js)</li></ul> | Using **DFS** to generate leaves string, then do comparison. |
[851. Loud and Rich](https://leetcode.com/problems/loud-and-rich/)| 2019/5/16 | [Java](src/LoudAndRich.java)| <ul><li>the richness among people can be converted into a tree(using hashMap)</li><li>Then go through each person, populate the quietist person from top to bottom: If a node is quieter than the value which children nodes has stored, then update the answer for that children node and continue populating the result for the children nodes of that node</li></ul> |
[6. ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/) | 2019/6/3 | [Java](src/ZigZagConversion.java) | generate result strings level by level |

## Graph
Question | Done Date | Code | Note |
----|----|-----|-----|
[207. Course Schedule](https://leetcode.com/problems/course-schedule/description/) | 2018/6/13 | [Here](src/CourseSchedule.java) | Topo sort |
[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/description/) | 2018/6/13 | [Here](src/CourseScheduleII.java) | Topo Sort |
[841. Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/) | 2019/5/15 | [Java](src/KeysAndRooms.java) | <ul><li>Firstly convert the input string to a hashMap <room : [keys]>, which represents a graph structure</li><li>Classic DFS, nothing special. Using a boolean array to determine if a room is visiting or not</li></ul> |

## Math
Question | Done Date | Code | Note |
----|----|-----|-----|
[190. Reverse Bits](https://leetcode.com/problems/reverse-bits/description/) | 2018/6/18 | [Here](src/ReverseBits.java) | <ul><li>Iteration + Bit Operation</li><li>Divide & Conquer</li></ul> |
[836. Rectangle Overlap](https://leetcode.com/problems/rectangle-overlap/description/) | 2018/6/25 | [Here](src/RectangleOverlap.java) | Determined by relationship either between rec1's left-bottom and rec2's right-top, or between rec1's right-top and rec2's left-bottom |
[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/description/) | 2018/6/30 | [Here](src/Sqrtx.java) | Binary Search |
[166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/description/) | 2018/7/6 | [Here](src/FractiontoRecurringDecimal.java) | 1. Using recursion to compute decimal 2. Using hashmap to deal with infinite circulating decimal |
[149. Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/description/) | 2018/7/8 | [Here](src/MaxPointsonaLine.java) | <ul><li>1. Use HashMap to store "slope"</li><li>2. Normalized diffY and diffX based on their GCD. And generated a String as key in the HashMap, inorder to deal with Double's precision problem.</li></ul> |
[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/) | 2018/7/11 | [Here](src/EvaluateReversePolishNotation.java) | Using Stack to store number we met. Each time we meet an operator, We do a computation on the top two numbers, then we push the result back to the top of stack. |
[136. Single Number](https://leetcode.com/problems/single-number/description/) | 2018/7/11 | [Here](src/SingleNumber.java) | XOR |
[137. Single Number II](https://leetcode.com/problems/single-number-ii/description/) | 2018/7/12 | [Here](src/SingleNumberII.java) | Bitwise + State Machine |
[202. Happy Number](https://leetcode.com/problems/happy-number/description/) | 2018/7/12 | [Here](src/HappyNumber.java) | Iteration + Using HashSet to record number we've met. |
[957. Prison Cells After N Days](https://leetcode.com/problems/prison-cells-after-n-days/) | 2019/5/23 | [Java](src/PrisonCellsAfterNDays.java) | Math : Find the cycle of states |

## Matrix
Question | Done Date | Code | Note |
----|----|-----|-----|
[378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/) | 2018/6/12 | [Here](src/KthSmallestElementinaSortedMatrix.java) | Two ways: <ul><li>PriorityQueue: Put element into PQ, along with each element, we also record their coordinates(x, y)</li><li>Binary Search: Just like the solution of **41. First Missing Positive**, We do binary search on values space of elements in matrix </li></ul> |
[130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/description/) | 2018/6/13 | [Here](src/SurroundedRegions.java) | DFS + Mark out node which's not killed |
[329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/) | 2018/6/18 | [Here](src/LongestIncreasingPathinaMatrix.java) | DFS + Memoization |
[212. Word Search II](https://leetcode.com/problems/word-search-ii/description/) | 2018/6/19 | [Here](src/WordSearchII.java) | Trie Tree stores dictionary, DFS searches words in mtx |
[200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/) | 2018/7/9 | [Here](src/NumberofIslands.java) | Two solutions:<ul><li>1. Using DFS to "clear" a island when we meet an new island. However, this solution requires us to modify the input grid map</li><li>2. If we are not allowed to modify grid map, Get help from Union Find</li></ul> |
[695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | 2019/5/14 | [Java](MaxAreaofIsland.java) | Follow up to [the number of islands](https://leetcode.com/problems/number-of-islands/). Using DFS to find an island and count the area, and **eliminate** it. Of course, if we are not allowed to modify the input matrix, we can use **union find** |
[934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/) | 2019/5/18 | [Java](src/ShortestBridge.java) | Another variance of [Number of islands](https://leetcode.com/problems/number-of-islands/). Still using DFS to find islands. And because there are only 2 islands, we can mark the found island using '1' and '2'. Then using DFS to find the shortest bridge between 2 islands.|
[675. Cut Off Trees for Golf Event](https://leetcode.com/problems/cut-off-trees-for-golf-event/) | 2019/6/2 | [Java](src/CutOffTreesforGolfEvent.java) | <ul><li>Using priorityqueue to sort the trees by their heights.</li><li>Cut the next tree one by one. Computing the distance between the current pos and the next tree's pos using BFS</li></ul> |
[909. Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/) | 2019/6/2 | [Java](src/SnakesAndLadders.java) | BFS variance. Need to jump if a grid touch ladder or snake |
[931. Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/) | 2019/6/3 | [Java](src/MinimumFallingPathSum.java) | Classical DP |

## Design
Question | Done Date | Code | Note |
----|----|-----|-----|
[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/) | 2018/6/22 | [Here](src/MedianFinder.java) | Two PriorityQueues: maxHeap + minHeap |
[155. Min Stack](https://leetcode.com/problems/min-stack/description/) | 2018/7/9 | [Here](src/MinStack.java) | Each time we push a new item, we need to push current Minimal value alongside. |
[146. LRU Cache](https://leetcode.com/problems/lru-cache/) | 2019/5/15 | [Java](src/LRUCache.java) | <ul><li>Bidirection linked list as container</li> <li>Using hashMap to store key : node of linked list </li> <li>the tail of linked list will be removed when cache is full</li> <li> new coming value will go into the head of the list</li> <li>The most recent visit value will be extracted from the list and put to the head of the list</li> </ul>  |