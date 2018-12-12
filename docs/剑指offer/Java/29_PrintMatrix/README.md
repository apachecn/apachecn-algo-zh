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
由外往里，一圈圈打印矩阵即可。

```java
import java.util.ArrayList;

/**
 * @author bingo
 * @since 2018/11/22
 */

public class Solution {
    /**
     * 转圈打印矩阵
     * @param matrix 矩阵
     * @return 存放结果的list
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int i = 0, j = 0;
        while (i <= m && j <= n) {
            circlePrint(list, matrix, i++, j++, m--, n--);
        }
        return list;
    }

    private void circlePrint(ArrayList<Integer> list, int[][] matrix, int i, int j, int m, int n) {
        if (i == m) {
            for (int p = j; p <= n; ++p) {
                list.add(matrix[i][p]);
            }
        } else if (j == n) {
            for (int p = i; p <= m; ++p) {
                list.add(matrix[p][j]);
            }
        } else {
            for (int p = j; p < n; ++p) {
                list.add(matrix[i][p]);
            }
            for (int p = i; p < m; ++p ) {
                list.add(matrix[p][n]);
            }
            for (int p = n; p > j; --p) {
                list.add(matrix[m][p]);
            }
            for (int p = m; p > i; --p) {
                list.add(matrix[p][j]);
            }
        }
    }
}
```

### 测试用例
1. 数组中有多行多列；数组中只有一行；数组中只有一列；数组中只有一行一列。