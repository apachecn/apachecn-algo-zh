/**
 * 
 * @param {number}  number 
 * 思路: n级台阶只能由第n-1和第n-2级台阶跳上来，得到动态规划方程
 */

function jumpFloor(number)
{
    // write code here
    if(number===0) return 0;
    if(number==1)return 1;
    if(number===2) return 2;
    let a=1, b=2, sum=0;
    for(let i=3; i<= number; i++) {
        sum=a+b;
        a=b;
        b=sum;
    }
    return sum;
}
module.exports = {
    jumpFloor : jumpFloor
};
