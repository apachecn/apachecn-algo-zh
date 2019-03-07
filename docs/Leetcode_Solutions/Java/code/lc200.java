package code;
/*
 * 200. Number of Islands
 * 题意：0,1矩阵，求1片区个数
 * 难度：Medium
 * 分类：Depth-first Search, Breadth-first Search, Union Find
 * 思路：两种方法，一种搜索，一种并查集
 * Tips：
 */
public class lc200 {
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if( grid[i][j]=='1' ){
                    count++;
                    grid[i][j] = '0';   //置0， 下次不用考虑
                    search(grid,i,j);
                }
            }
        }
        return count;
    }
    public void search(char[][] grid, int i, int j){
        if( i>0 && grid[i-1][j]=='1') {
            grid[i-1][j] = '0';     //置0， 下次不用考虑
            search(grid, i - 1, j);
        }
        if( j>0 && grid[i][j-1]=='1') {
            grid[i][j-1] = '0';
            search(grid, i, j-1);
        }
        if( i+1<grid.length && grid[i+1][j]=='1') {
            grid[i+1][j] = '0';
            search(grid, i + 1, j);
        }
        if( j+1<grid[0].length && grid[i][j+1]=='1') {
            grid[i][j+1] = '0';
            search(grid, i, j+1);
        }
        return;
    }

    //并查集
    int[] flag;
    int count = 0;

    public int numIslands2(char[][] grid) {
        if(grid.length==0)
            return 0;
        //初始化， 每个1都是一个island
        flag = new int[grid.length*grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j]=='1'){
                    int id = i*grid[0].length+j;
                    flag[id] = id;
                    count++;
                }
            }
        }
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j]=='1'){
                    int id1 = i*grid[0].length+j;
                    if( i>0 && grid[i-1][j]=='1') {     //四个方向都合一下，虽然有些冗余
                        int id2 = (i-1)*grid[0].length+j;
                        union(id1, id2);
                    }
                    if( j>0 && grid[i][j-1]=='1') {
                        int id2 = i*grid[0].length+j-1;
                        union(id1, id2);
                    }
                    if( i+1<grid.length && grid[i+1][j]=='1') {
                        int id2 = (i+1)*grid[0].length+j;
                        union(id1, id2);
                    }
                    if( j+1<grid[0].length && grid[i][j+1]=='1') {
                        int id2 = i*grid[0].length+j+1;
                        union(id1, id2);
                    }
                }
            }
        }
        return count;
    }

    public void union(int id1, int id2){
        int flag_id1 = find(id1);
        int flag_id2 = find(id2);
        if(flag_id1==flag_id2)
            return;
        else{
            flag[flag_id1] = flag[flag_id2];    //把father们的 flag_id 合一起了
            count--;
        }
    }

    public int find(int id){    //找到father的flag_id
        int res = flag[id];
        while(res != id){   //接着往上找father
            id = res;
            res = flag[id];
        }
        return res;
    }
}
