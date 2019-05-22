# Some algorithm templates for better understanding!


# 八大排序算法集合

![](/images/SortingAlgorithm/八大排序算法性能.png)

## 冒泡排序
### 单向冒泡
通过相邻元素的比较和交换，使得每一趟循环都能找到未有序数组的最大值或最小值。
```
function bubbleSort(nums) {
  for(let i=0, len=nums.length; i<len-1; i++) {
    // 如果一轮比较中没有需要交换的数据，则说明数组已经有序。主要是对[5,1,2,3,4]之类的数组进行优化
    let mark = true;
    for(let j=0; j<len-i-1; j++) {
      if(nums[j] > nums[j+1]) {
        [nums[j], nums[j+1]] = [nums[j+1], nums[j]];
        mark = false;
      }
    }
    if(mark)  return;
  }
}
```

### 双向冒泡
在一趟循环中，既找出最大值也找出最小值。

```
function bubbleSort_twoWays(nums) {
  for(let i=0, len=nums.length; i<len-1; i++) {
    let mark = true;
    // 找到最大值放到右边
    for(let j=0; j<len-i-1; j++) {
      if(nums[j] > nums[j+1]) {
        [nums[j], nums[j+1]] = [nums[j+1], nums[j]];
        mark = false;
      }
    }
    // 找到最小值放到左边
    for(let t=len-i-2; t>0; t--) {
      if(nums[t] < nums[t-1]) {
        [nums[t], nums[t-1]] = [nums[t-1], nums[t]];
        mark = false;
      }
    }
    if(mark)  return;
  }
}
```

## 选择排序
和冒泡排序相似，区别在于选择排序是将每一个元素和它后面的元素进行比较和交换。
```
function selectSort(nums) {
  for(let i=0, len=nums.length; i<len; i++) {
    for(let j=i+1; j<len; j++) {
      if(nums[i] > nums[j]) {
        [nums[i], nums[j]] = [nums[j], nums[i]];
      }
    }
  }
}
```

## 插入排序
以第一个元素作为有序数组，其后的元素通过在这个已有序的数组中找到合适的位置并插入。
```
function insertSort(nums) {
  for(let i=1, len=nums.length; i<len; i++) {
    let temp = nums[i];
    let j = i;
    while(j >= 0 && temp < nums[j-1]) {
      nums[j] = nums[j-1];
      j--;
    }
    nums[j] = temp;
  }
}
```

## 快速排序
选择一个元素作为基数（通常是第一个元素），把比基数小的元素放到它左边，比基数大的元素放到它右边（相当于二分），再不断递归基数左右两边的序列。
### 填坑法
```
function quickSort(nums) {
  // 递归排序基数左右两边的序列
  function recursive(arr, left, right) {
    if(left >= right)  return;
    let index = partition(arr, left, right);
    recursive(arr, left, index - 1);
    recursive(arr, index + 1, right);
    return arr;
  }
  // 将小于基数的数放到基数左边，大于基数的数放到基数右边，并返回基数的位置
  function partition(arr, left, right) {
    // 取第一个数为基数
    let temp = arr[left];
    while(left < right) {
      while(left < right && arr[right] >= temp)  right--;
      arr[left] = arr[right];
      while(left < right && arr[left] < temp)  left++;
      arr[right] = arr[left];
    }
    arr[left] = temp;
    return left;
  }
  recursive(nums, 0, nums.length-1);
}
```

### 交换法
```
function quickSort1(nums) {
  function recursive(arr, left, right) {
    if(left >= right)  return;
    let index = partition(arr, left, right);
    recursive(arr, left, index - 1);
    recursive(arr, index + 1, right);
    return arr;
  }
  function partition(arr, left, right) {
    let temp = arr[left];
    let p = left + 1;
    let q = right;
    while(p <= q) {
      while(p <= q && arr[p] < temp)  p++;
      while(p <= q && arr[q] > temp)  q--;
      if(p <= q) {
        [arr[p], arr[q]] = [arr[q], arr[p]];
        p++;
        q--;
      }
    }
    [arr[left], arr[q]] = [arr[q], arr[left]];
    return q;
  }
  recursive(nums, 0, nums.length-1);
}
```

## 归并排序
递归将数组分为两个序列，有序合并这两个序列。
```
function mergeSort(nums) {
  // 有序合并两个数组
  function merge(l1, r1, l2, r2) {
    let arr = [];
    let index = 0;
    let i = l1, j = l2;
    while(i <= r1 && j <= r2) {
      arr[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
    }
    while(i <= r1)  arr[index++] = nums[i++];
    while(j <= r2)  arr[index++] = nums[j++];
    for(let t=0; t<index; t++) {
      nums[l1 + t] = arr[t];
    }
  }
  // 递归将数组一分为二
  function recursive(left, right) {
    if(left >= right)  return;
    let mid = parseInt((right - left) / 2) + left;
    recursive(left, mid);
    recursive(mid+1, right);
    merge(left, mid, mid+1, right);
    return nums;
  }
  recursive(0, nums.length-1);
}
```