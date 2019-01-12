### Binary Search 二分法

#### Recursion VS Nonrecursion <br>
1.是否要求不用Recursion（不确定就问)<br>
2. 不使用 Recursion 是否会使实现变得复杂<br>
3. Recursion 深度是不是会变的很深 <br>
4. 题目考点使 Recursion vs nonrecursion 还是只考是否会Recursion<br>

#### T函数时间复杂度的算法

```
T(n) = T(n/2) + O(1) = O(logn)
T(n) = T(n/2) + O(n) = O(n)
```

#### 二分法模版四要素
```
start + 1 < end
start + (end + start) /2
A[mid] ==,<,>
A[start],A[end] ? target
```

#### 两类二分法
Binary Search in index<br>
Binary Search in Result<br>

#### 二分法的三个层次
1.头尾指针，取中点，判断想哪走<br>
2. 寻找满足某条件的第一或最后一个位置<br>
3.保留生下来一定有用的那一半<br>

###LeetCode
704. Binary Search<br>
