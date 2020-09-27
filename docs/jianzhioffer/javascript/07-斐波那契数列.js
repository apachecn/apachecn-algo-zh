function Fibonacci(n)
{
    // write code here
    if (n===0 || n===1) {
        return n;
    }
    let n1 = 0, n2=1, sum=1;
    for(let i=2;i<=n;i++) {
        sum = n1+n2;
        n1=n2;
        n2=sum;
    }
    return sum;
}
module.exports = {
    Fibonacci : Fibonacci
};
