package code;
/*
 * 621. Task Scheduler
 * 题意：一系列任务，相同任务之间至少有n个时间间隔，问最少执行时间
 * 难度：Medium
 * 分类：Array, Greedy, Tree
 * 思路：统计出出现次数最多的那个任务的出现次数，再统计下和他相同次数的任务个数，返回 (max-1)*(n+1)+count 即可
 * Tips：
 */
public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int max = 0;
        for (char ch : tasks ) {
            map[ch-'A'] += 1;
            max = Math.max(map[ch-'A'], max);
        }
        int count = 0;
        for(int i: map){
            if(i==max) count++;
        }
        return Math.max(tasks.length, (max-1)*(n+1)+count );    // max-1 不算最后一个周期， 最后一个周期时间是count，间隔为n，周期为n+1
    }
}
