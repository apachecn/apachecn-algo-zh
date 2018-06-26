#************************基数排序****************************
#确定排序的次数
#排序的顺序跟序列中最大数的位数相关
def radix_sort_nums(L):
    maxNum = L[0]
#寻找序列中的最大数
    for x in L:
        if maxNum < x:
            maxNum = x
#确定序列中的最大元素的位数
    times = 0
    while (maxNum > 0):
        maxNum = int((maxNum/10))
        times += 1
    return times
#找到num从低到高第pos位的数据
def get_num_pos(num, pos):
    return (int((num/(10**(pos-1))))) % 10
#基数排序
def radix_sort(L):
    count = 10 * [None]       #存放各个桶的数据统计个数
    bucket = len(L) * [None]  #暂时存放排序结果
#从低位到高位依次执行循环
    for pos in range(1, radix_sort_nums(L)+1):
        #置空各个桶的数据统计
        for x in range(0, 10):
            count[x] = 0
        #统计当前该位(个位，十位，百位....)的元素数目
        for x in range(0, len(L)):
            #统计各个桶将要装进去的元素个数
            j = get_num_pos(int(L[x]), pos)
            count[j] += 1
        #count[i]表示第i个桶的右边界索引
        for x in range(1,10):
            count[x] += count[x-1]
        #将数据依次装入桶中
        for x in range(len(L)-1, -1, -1):
            #求出元素第K位的数字
            j = get_num_pos(L[x], pos)
            #放入对应的桶中，count[j]-1是第j个桶的右边界索引
            bucket[count[j]-1] = L[x]
            #对应桶的装入数据索引-1
            count[j] -= 1
        # 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
        for x in range(0, len(L)):
            L[x] = bucket[x]
