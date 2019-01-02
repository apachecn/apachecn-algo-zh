## 顺时针打印矩阵

### 题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下 `4 X 4` 矩阵： 
```
1   2   3   4
5   6   7   8
9   10  11  12
13  14  15  16
```

则依次打印出数字：
```
1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
```
### 解法
剑指offer上的思路有点复杂，需要考虑坐标变换太多，考虑用另一种思路来解决。

在矩阵中，使用左上角坐标(tR,tC)和右下角的坐标(dR,dC)就可以表示一个矩阵。比如题目中的矩阵，当(tR,tC) = (0,0)和(dR,dC) = (3,3)时，表示的子矩阵就是整个矩阵：

```java
1	2	3	4
5			8
9			12
13	14	15	16    
```

当外层循环遍历后，可以令tR和tC加1，dR和dC减1，执行内层循环。当左上角的坐标跑到右下角坐标的右方或者下方，则整个过程就终止。

```java
/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/2
 */
public class Solution {
    /**
     * 转圈打印矩阵
     * @param matrix 矩阵
     * @return 存放结果的list
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> reList = new ArrayList<>();
        if (matrix == null) {
            return reList;
        }

        int start = 0;
        int rows = matrix.length;
        int colums = matrix[0].length;

        while (rows > start * 2 && colums > start * 2) {
            printMatrix(matrix, rows, colums, start, reList);
            start++;
        }

        return reList;
    }

    private void printMatrix(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> reList) {

        // 相当于坐标轴中的y坐标
        int endX = columns - start - 1;
        // 相当于坐标轴中的x坐标
        int endY = rows - start - 1;

        // 从左到右，x增加y不变
        for (int i = start; i <= endX; i++) {
            reList.add(matrix[start][i]);
        }

        if (start < endY) {
            // 从上到下，x不变y增加
            for (int i = start + 1; i <= endY; i++) {
                reList.add(matrix[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            // 从右到左，x减少y不变
            for (int i = endX - 1; i >= start; i--) {
                reList.add(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            // 从下到上，x不变y减少
            for (int i = endY - 1; i > start; i--) {
                reList.add(matrix[i][start]);
            }
        }
    }
}
```

### 测试用例
1. 数组中有多行多列；数组中只有一行；数组中只有一列；数组中只有一行一列。