| 作用                                         | Basic Regx | Extenheh Regx | Python Regx | Perl Regx  |
| -------------------------------------------- | ---------- | ------------- | ----------- | ---------- |
| 转义                                         | \          | \             | \           | \          |
| 任意单个字符                                 | .          | .             | .           | .          |
| 行首                                         | ^          | ^             | ^           | ^          |
| 行尾                                         | $          | $             | $           | $          |
| 表达式                                       | \(\)       | ()            | ()          | ()         |
| x 或 y                                       | \|         | \|            | \|          | \|         |
| 其中的一个字符                               | [xyz]      | [xyz]         | [xyz]       | [xyz]      |
| 非其中的字符                                 | [^xyz]     | [^xyz]        | [^xyz]      | [^xyz]     |
| 捕获匹配的引用                               | 不支持     | \num          | \num        | 不支持     |
| 单词边界                                     | \b         | \b            | \b          | \b         |
| 非单词边界                                   | \B         | \B            | \B          | \B         |
| 单词边界（起始）                             | \<         | \<            | 不支持      | 不支持     |
| 单词边界（结束）                             | \>         | \>            | 不支持      | 不支持     |
| 任何单词字符[A-Za-z0-9_]                     | \w         | \w            | \w          | \w         |
| 任何非单词字符                               | \W         | \W            | \W          | \W         |
| 任意一个数字字符                             | 不支持     | 不支持        | \d          | \d         |
| 非数字字符                                   | 不支持     | 不支持        | \D          | \D         |
| 任何空白字符[\f\n\r\t\v]                     | 不支持     | 不支持        | \s          | \s         |
| 任何非空白字符[^\f\n\r\t\v]                  | 不支持     | 不支持        | \S          | \S         |
| 换行符                                       | 不支持     | 不支持        | \n          | \n         |
| 回车符                                       | 不支持     | 不支持        | \r          | \r         |
| 换页符                                       | 不支持     | 不支持        | \f          | \f         |
| 横向制表符                                   | 不支持     | 不支持        | \t          | \t         |
| 垂直制表符                                   | 不支持     | 不支持        | \v          | \v         |
| Ctrl-x(x是任意字母)                          | 不支持     | 不支持        | 不支持      | \cx        |
| 0xdd对应的字符                               | 不支持     | 不支持        | 不支持      | \xdd       |
| .                                      |            |               |             |            |
| ***POSIX字符集***                               |            |               |             |            |
| 任何字母或数字                               | [:alnum:]  | [:alnum:]     | [:alnum:]   | [:alnum:]  |
| 任何字母                                     | [:alpha:]  | [:alpha:]     | [:alpha:]   | [:alpha:]  |
| 任何数字                                     | [:digit:]  | [:digit:]     | [:digit:]   | [:digit:]  |
| 任何小写字母                                 | [:lower:]  | [:lower:]     | [:lower:]   | [:lower:]  |
| 任何大写字母                                 | [:upper:]  | [:upper:]     | [:upper:]   | [:upper:]  |
| 任何空白字符                                 | [:space:]  | [:space:]     | [:space:]   | [:space:]  |
| 空格和制表符（横向和纵向）                   | [:blank:]  | [:blank:]     | [:blank:]   | [:blank:]  |
| 任何可以看得见的且可以打印的字符             | [:graph:]  | [:graph:]     | [:graph:]   | [:graph:]  |
| 任何可以打印的字符                           | [:print:]  | [:print:]     | [:print:]   | [:print:]  |
| 任何控制字符                                 | [:cntrl:]  | [:cntrl:]     | [:cntrl:]   | [:cntrl:]  |
| 任何标点符号                                 | [:punct:]  | [:punct:]     | [:punct:]   | [:punct:]  |
| 任何十六进制数[0-9A-Fa-f]                    | [:xdigit:] | [:xdigit:]    | [:xdigit:]  | [:xdigit:] |
|      .                                |            |               |             |            |
| ***量词***                                      |            |               |             |            |
| 非贪婪模式                                   | 不支持     | 不支持        | 不支持      | 不支持     |
| 匹配前面的子表达式 0 次或 1 次               | \?         | ？            | ？          | ？         |
| 匹配前面的子表达式 0 次或多次                | *          | *             | *           | *          |
| 匹配前面的子表达式 1 次或多次                | \+         | +             | +           | +          |
| n 必须是一个 0 或者正整数，匹配子表达式 n 次 | \{n\}      | {n}           | {n}         | {n}        |
| 匹配子表达式大于等于 n次                     | \{n,\}     | {n,}          | {n,}        | {n,}       |
| 最少匹配 n 次且最多匹配 m 次                 | \{n,m\}    | {n,m}         | {n,m}       | {n,m}      |



### Reference
1. [正则表达式CheetSheet](http://zonxin.github.io/post/2015/08/regular-expression-cheetsheet)
2. [Quick-Start: Regex Cheat Sheet](https://www.rexegg.com/regex-quickstart.html)
3. [Specifying Modes Inside The Regular Expression](https://www.regular-expressions.info/modifiers.html)
