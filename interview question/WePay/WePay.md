

就是一个slide windows 的题目

```python
inputs = [5,1,2,100,2,2]
def alert(inputs, windowSize, allowedIncrease):
    b = []
    tmp = {}
    for i in range(len(inputs) - windowSize):
        for j in range(i, i+windowSize+1):
            if j in tmp.keys():
                if j > len(inputs) - windowSize-1:
                    tmp.get(j).append(inputs[i+1:i + windowSize+1])
                else:
                    tmp.get(j).append(inputs[i:i+windowSize])
            else:
                print(j,j, i, i+ windowSize)
                if j > len(inputs) - windowSize -1:
                    tmp[j] = [inputs[i+1:i + windowSize+1]]
                else:
                    tmp[j] = [inputs[i:i+windowSize]]
    b = [inputs[i:i+windowSize] for i in range(len(inputs)-windowSize)]
    print(tmp)
    for num in tmp.keys():
        if all(inputs[num] > sum(lis)/windowSize*allowedIncrease for lis in tmp.get(num)):
            return True
    b = [sum(i)/windowSize for i in b]
    for i in range(len(b)):
        if any(b[i] > b[j]*allowedIncrease for j in range(i)):
            return True
    return False
print(alert(inputs,3,1.5))
```
