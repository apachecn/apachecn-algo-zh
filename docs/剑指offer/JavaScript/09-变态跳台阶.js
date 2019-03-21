function sumArr(arr) {
  return arr.reduce((pre, next) => pre+next)
}

function jumpFloorII(number)
{
  // write code here
  if(number===0) return 0;
  if(number==1)return 1;
  if(number===2) return 2;
  let ans = [1,2];
  for(let i=3;i<=number;i++) {
      // 额外加一是可以直接跳到第n级台阶
      ans.push(sumArr(ans)+1);
  }
  return ans[ans.length -1];
}
module.exports = {
  jumpFloorII : jumpFloorII
};
