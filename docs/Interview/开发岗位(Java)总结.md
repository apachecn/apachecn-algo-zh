最近正在面试，最开始因为没有这样准备过，所以总是被问的一脸懵逼，相信很多人跟我有过一样的经历，时间长就是忘了嘛，对不对，无奈。
怒🔥一上来打算好好整理下，面试前过一遍，岂不是美滋滋！

# Java基础
## 1. 面向对象和面向过程的区别
- 面向过程强调动作，物体本身只是一个属性或者参数，具体为一件事该怎么做。   ```吃.(狗，屎)  吃.(🐶, 💩)```
    - 优点：性能比面向对象高，因为类调用时需要实例化，比较消耗资源;较底层的东西比如单片机、嵌入式开发、Linux/Unix等一般采用面向过程开发，性能是最重要的因素。
    - 缺点：没有面向对象易维护、易复用、易扩展
- 面向对象强调object，动作只是一个函数，具体为一件事该让谁去做。         ```狗.吃(屎)  🐶.吃(💩)```
    - 优点：易维护、易复用、易扩展，由于面向对象有封装、继承、多态性的特性，可以设计出低耦合的系统，使系统更加灵活、更加易于维护
    - 缺点：性能比面向过程低

## 2. Java的四个基本特性（抽象、封装、继承，多态）
- ***抽象***：就是把现实生活中的某一类东西提取出来，用类或者接口表示。抽象包括两个方面：一个是数据抽象，一个是过程抽象。数据抽象也就是对象的属性。过程抽象是对象的行为特征。
- ***封装***：把客观事物封装成抽象的类，并且类可以把自己的数据和方法只让可信的类或者对象操作，对不可信的进行封装隐藏。封装分为属性的封装和方法的封装。
    - 1. 安全
    - 2. 将内外隔离
    - 3. 便于使用
    - 4. 提供重复性，具有模块化
- ***继承***：父类抽取多类事物的共性，不同子类继承父类根据自身条件不同对父类方法进行重载或重写。
- ***多态***：从某种角度上来说，封装和继承就是为了多态而做准备的。多态采用的方法是动态绑定（dynamic binding），是指在执行期间判断所引用对象的实际类型，根据其实际的类型调用其相应的方法。多态必须同时满足三个条件：
    - 1. 要有继承
    - 2. 要有重写
    - 3. 父类引用指向子类对象

    多态其实就是父类提供一个接口，基于同一个接口，使用不同的实例就可以使用不同的功能
    ```java
    Father f = new Son();
    ```
## 3. 重载和重写的区别
- 重载：发生在同一个类中，方法名必须相同，参数类型、个数或者顺序不同，方法返回值和访问修饰符可以不同，发生在编译时。
- 重写：发生在父子类中，方法名、参数列表必须相同，返回值小于等于父类，抛出的异常小于等于父类，访问修饰符大于等于父类；如果父类方法访问修饰符为private则子类中就不是重写。

## 4. 构造器Constructor是否可被override
构造器不能被重写，不能用static修饰构造器，只能用public，private，protected这三个权限修饰符，且不能有返回语句。
1. 构造器与类同名 （构造函数，initilize 函数）
2. 每个类可以有一个以上的构造器
3. 构造器可以有0个，1个以及多个参数 （无参构造函数，有参构造函数）
4. 构造器没有返回值（与void明显不同，构造器不会返回任何东西，你别无选择。）
5. 构造器总是伴随着new操作符一起调用
6. 构造器不可被继承

## 5. 访问控制符public,protected,private,以及默认的区别

|                    |   任意地方   | 同一个包 |  子类  | 同一个类 |
| :----------------: | :------: | :--: | :--: | :--: |
|  Public (接口访问权限)   |    🌈    |  🌈  |  🌈  |  🌈  |
| Protected (继承访问权限) | 🌈(需要继承) |  🌈  |  🌈  |  🌈  |
|  Default (包访问权限)   |          |  🌈  |  🌈  |  🌈  |
|  Private (类访问权限)   |          |      |      |  🌈  |


- public（接口访问权限）：任何地方都能访问；
- protected（继承访问权限）: 介于public 和 private 之间的一种访问修饰符，一般称之为“保护形”。被其修饰的类、属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。在同包内的类及包外的子类能访问；
- default（包访问权限）：即不加任何访问修饰符，通常称为“默认访问模式“。该模式下，只允许在同一个包中进行访问。 
- private（类访问权限）: 只有在本类中才能访问；
（只限在Java语言中……）

## 6. 是否可以继承String类
String类是final类故不可以继承，一切由final修饰过的都不能继承。

## 7. String和StringBuffer、StringBuilder的区别
- 可变性

String类中使用字符数组保存字符串，private final char value[]，所以string对象是不可变的。
StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，char[] value，
这两种对象都是可变的。
- 线程安全性

String中的对象是不可变的，也就可以理解为常量，线程安全。
AbstractStringBuilder是StringBuilder与StringBuffer的公共父类，定义了一些字符串的基本操作，如expandCapacity、append、insert、indexOf等公共方法。
StringBuffer对方法加了同步锁或者对调用的方法加了同步锁，所以是**线程安全**的。
StringBuilder并没有对方法进行加同步锁，所以是**非线程安全**的。
- 性能

每次对 String 类型进行改变的时候，都会生成一个新的String 对象，然后将指针指向新的String 对象。StringBuffer每次都会对
StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用StirngBuilder 相比使用
StringBuffer 仅能获得10%~15% 左右的性能提升，但却要冒多线程不安全的风险。大多数情况下建议使用StirngBuilder。
综合速度```String < StringBuffer < StirngBuilder```

## 8. hashCode和equals方法的关系

Java对象的eqauls方法和hashCode方法是这样规定的：

1. 相等（相同）的对象必须具有相等的哈希码（或者散列码）。
2. 如果两个对象的hashCode相同，它们并不一定相同。

- 关于第一点，相等（相同）的对象必须具有相等的哈希码（或者散列码），为什么？

 想象一下，假如两个Java对象A和B，A和B相等（eqauls结果为true），但A和B的哈希码不同，则A和B存入HashMap时的哈希码计算得到的HashMap内部数组位置索引可能不同，那么A和B很有可能允许同时存入HashMap，显然相等/相同的元素是不允许同时存入HashMap，HashMap不允许存放重复元素。

- 关于第二点，两个对象的hashCode相同，它们并不一定相同

 也就是说，不同对象的hashCode可能相同；假如两个Java对象A和B，A和B不相等（eqauls结果为false），但A和B的哈希码相等，将A和B都存入HashMap时会发生哈希冲突，也就是A和B存放在HashMap内部数组的位置索引相同这时HashMap会在该位置建立一个链接表，将A和B串起来放在该位置，显然，该情况不违反HashMap的使用原则，是允许的。当然，哈希冲突越少越好，尽量采用好的哈希算法以避免哈希冲突。
 
 **注意⚠️**：在object类中，hashcode()方法是本地方法，返回的是对象的地址值，而object类中的equals()方法比较的也是两个对象的地址值，如果equals()相等，说明两个对象地址值也相等，当然hashcode()也就相等了；在String类中，equals()返回的是两个对象内容的比较，当两个对象内容相等时，Hashcode()方法根据String类的重写代码的分析，也可知道hashcode()返回结果也会相等。以此类推，可以知道Integer、Double等封装类中经过重写的equals()和hashcode()方法也同样适合于这个原则。当然没有经过重写的类，在继承了object类的equals()和hashcode()方法后，也会遵守这个原则。
 
 当集合要添加新的元素时，如果每增加一个元素就检查一次equals方法，那么当元素很多时，后添加到集合中的元素比较的次数就非常多了。也就是说，如果集合中现在已经有1000个元素，那么第1001个元素加入集合时，它就要调用1000次equals方法。这显然会大大降低效率。正确的做法是先调用这个元素的hashCode方法，就一下子能定位到它应该放置的物理位置上。如果这个位置上没有元素，它就可以直接存储在这个位置上，不用再进行任何比较了；如果这个位置上已经有元素了，就调用它的equals方法与新元素进行比较，相同的话就不存了，不相同就散列其它的地址。所以这里存在一个冲突解决的问题。这样一来实际调用equals方法的次数就大大降低了，几乎只需要一两次。 
 
 ## 9. 抽象类和接口的区别
- 语法层次

抽象类和接口分别给出了不同的语法定义。
- 设计层次

抽象层次不同，抽象类是对类抽象，而接口是对行为的抽象。抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。抽象类是自底向上抽象而来的，接口是自顶向下设计出来的。
- 跨域不同

抽象类所体现的是一种继承关系，要想使得继承关系合理，父类和派生类之间必须存在"is-a"
关系，即父类和派生类在概念本质上应该是相同的。对于接口则不然，并不要求接口的实现者和接口定义在概念本质上是一致的，仅仅是实现了接口定义的契约而已，"like-a" 或者 "can do a"的关系。

## 10. 自动装箱与拆箱
- 装箱：将基本类型用它们对应的引用类型包装起来；
- 拆箱：将包装类型转换为基本数据类型；

Java使用自动装箱和拆箱机制，节省了常用数值的内存开销和创建对象的开销，提高了效率，由编译器来完成，编译器会在编译期根据语法决定是否进行装箱和拆箱动作。

## 11. 什么是泛型、为什么要使用以及类型擦除
泛型，即“参数化类型”。
创建集合时就指定集合元素的类型，该集合只能保存其指定类型的元素，避免使用强制类型转换。
Java中的泛型基本上都是在编译器这个层次来实现的。在生成的Java字节码中是不包含泛型中的类型信息的。使用泛型的时候加上的类型参数，会在编译器在编译的时候去掉。这个过程就称为类型擦除。
类型擦除的主要过程如下：
- 1. 将所有的泛型参数用其最左边界（最顶级的父类型）类型替换。
- 2. 移除所有的类型参数。

```java
public class Test4 {
	public static void main(String[] args) {
		ArrayList<String> arrayList1=new ArrayList<String>();
		arrayList1.add("abc");
		ArrayList<Integer> arrayList2=new ArrayList<Integer>();
		arrayList2.add(123);
		System.out.println(arrayList1.getClass()==arrayList2.getClass());
	}
}
```

在这个例子中，我们定义了两个ArrayList数组，不过一个是ArrayList<String>泛型类型，只能存储字符串。一个是ArrayList<Integer>泛型类型，只能存储整形。最后，我们通过arrayList1对象和arrayList2对象的getClass方法获取它们的类的信息，最后发现结果为true。说明泛型类型String和Integer都被擦除掉了，只剩下了**原始类型**。
    
```java
public class Test4 {  
    public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        ArrayList<Integer> arrayList3=new ArrayList<Integer>();  
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer  
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");  
        for (int i=0;i<arrayList3.size();i++) {  
            System.out.println(arrayList3.get(i));  
        }  
    }  
```

在程序中定义了一个ArrayList泛型类型实例化为Integer的对象，如果直接调用add方法，那么只能存储整形的数据。不过当我们利用反射调用add方法的时候，却可以存储字符串。这说明了Integer泛型实例在编译之后被擦除了，只保留了**原始类型**。                                             

## 12. Java中的集合类及关系图
- List和Set继承自Collection接口。
- Set无序不允许元素重复。HashSet和TreeSet是两个主要的实现类。
- List有序且允许元素重复。ArrayList、LinkedList和Vector是三个主要的实现类。
- Map也属于集合系统，但和Collection接口没关系。Map是key对value的映射集合，其中key列就是一个集合。key不能重复，但是value可以重复。HashMap、TreeMap和Hashtable是三个主要的实现类。
- SortedSet和SortedMap接口对元素按指定规则排序，SortedMap是对key列进行排序。

## 13. HashMap实现原理
具体原理参考文章：
- http://zhangshixi.iteye.com/blog/672697 
经典文章！！！
- http://www.admin10000.com/document/3322.html 
经典文章！！！


## 14. HashTable实现原理
具体原理参考文章：
- http://www.cnblogs.com/skywang12345/p/3310887.html
- http://blog.csdn.net/chdjj/article/details/38581035

## 15. HashMap和HashTable区别
1. HashTable的方法前面都有synchronized来同步，是线程安全的；HashMap未经同步，是非线程安全的。
2. HashTable不允许null值(key和value都不可以) ；HashMap允许null值(key和value都可以)。
3. HashTable有一个contains(Object value)功能和containsValue(Object value)功能一样。
4. HashTable使用Enumeration进行遍历；HashMap使用Iterator进行遍历。
5. Hashtable的容量为任意正数（最小为1），而HashMap的容量始终为2的n次方。HashTable中hash数组默认大小是11，增加的方式是old*2+1；HashMap中hash数组的默认大小是16，而且一定是2的指数。
6. 哈希值的使用不同，HashTable直接使用对象的hashCode； HashMap重新计算hash值，而且用 ```&``` 代替求模 ```%```。
7. HashMap计算索引的方式是h&(length-1),而Hashtable用的是模运算，效率上是低于HashMap的。另外Hashtable计算索引时将hash值先与上0x7FFFFFFF,这是为了保证hash值始终为正数。

## 16. ArrayList和vector区别
1. ArrayList和Vector都实现了List接口，都是通过数组实现的。
2. Vector是线程安全的，而ArrayList是非线程安全的。
3. List第一次创建的时候，会有一个初始大小，随着不断向List中增加元素，当List 认为容量不够的时候就会进行扩容。Vector缺省情况下自动增长原来一倍的数组长度，ArrayList增长原来的50%。

## 17. ArrayList和LinkedList区别及使用场景
1. 区别

    - ArrayList底层是用数组实现的，可以认为ArrayList是一个可改变大小的数组。随着越来越多的元素被添加到ArrayList中，其规模是动态增加的。
    - LinkedList底层是通过双向链表实现的， LinkedList和ArrayList相比，增删的速度较快。但是查询和修改值的速度较慢。同时，LinkedList还实现了Queue接口，所以他还提供了offer(), peek(), poll()等方法。
2. 使用场景

    - LinkedList更适合从中间插入或者删除（链表的特性）。
    - ArrayList更适合检索和在末尾插入或删除（数组的特性）。

## 18. Collection和Collections的区别
- java.util.Collection 是一个集合接口。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式。
- java.util.Collections 是一个包装类。它包含有各种有关集合操作的静态多态方法。此类不能实例化，就像一个工具类，服务于Java的Collection框架。

## 19. Concurrenthashmap实现原理
具体原理参考文章：
- http://www.cnblogs.com/ITtangtang/p/3948786.html
- http://ifeve.com/concurrenthashmap/

## 20. Error、Exception区别
Error类和Exception类的父类都是throwable类，他们的区别是：

- Error类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢出等。对于这类错误的导致的应用程序中断，仅靠程序本身无法恢复和和预防，遇到这样的错误，建议让程序终止。
- Exception类表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，使程序恢复运行，而不应该随意终止异常。

总结下来：Error类一般不能通过改代码处理，而Exception就是程序员改完代码基本就好了。

## 21. Unchecked Exception 和 Checked Exception，各列举几个
1. Unchecked Exception:

	- 指的是程序的瑕疵或逻辑错误，并且在运行时无法恢复。
	- Unchecked异常继承自java.lang.RuntimeException类, 包括Error与RuntimeException及其子类，如：OutOfMemoryError, UndeclaredThrowableException, IllegalArgumentException, IllegalMonitorStateException, NullPointerException, IllegalStateException, IndexOutOfBoundsException等。
	- unchecked异常则可以不必捕获或抛出, 语法上不需要声明抛出异常。

2. Checked Exception:

    - 代表程序不能直接控制的无效外界情况（如用户输入，数据库问题，网络异常，文件丢失等）
    - Checked异常继承java.lang.Exception类, 除了Error和RuntimeException及其子类之外，如：ClassNotFoundException, NamingException, ServletException, SQLException, IOException等。
    - Checked异常必须被显式地捕获或者传递, 需要try catch处理或throws声明抛出异常。

## 22. Java中如何实现代理机制(JDK、CGLIB)
- JDK动态代理：代理类和目标类实现了共同的接口，用到InvocationHandler接口。
- CGLIB动态代理：代理类是目标类的子类，用到MethodInterceptor接口。

## 23. 多线程的实现方式
继承Thread类、实现Runnable接口、使用ExecutorService、Callable、Future实现有返回结果的多线程。

## 24. 线程的状态转换
![](https://github.com/apachecn/LeetCode/blob/master/images/%E7%BA%BF%E7%A8%8B%E8%BD%AC%E6%8D%A2.jpg)

## 25. 双重检查单例模式
 一些人总结出来用来解决特定问题的固定的解决方案。
 
解决一个类在内存中只存在一个对象，想要保证对象的唯一。
1 为了避免其他程序过多的建立该类对象。禁止其他程序建立该类对象。
2 为了其他程序可以访问该类对象，在本类中自定义一个对象。
3 方便其他程序对自定义类的对象的访问，对外提供一些访问方式。
 
单例设计模式的需求

代码：
1将构造函数私有化
2在类中创建一个私有的本类对象
3提供一个用类名调用的公有方法获取该对象。
```java
class Single {

	private static Single s = new Single(); // 饿汉式

	private Single() {

	}

	public static Single getInstance() {
		return s;
	}
}
```
懒汉模式 – 通常被称为延迟加载。注意存在线程安全问题.
```java
class Single2 {
	private static Single2 s = null; // 懒汉式（线程不安全）

    	private Single2() {

	}

	public static Single2 getInstance() {
		if (s == null) {
			s = new Single2();
		}
		return s;
	}
}
```

//但是懒汉单例模式会有线程安全问题，如果，小明先拿到了cpu的使用权，判断了一下s是null，正准备创建一个新的single对象的时候，大明抢到了cpu使用权，然后大明成功创建了一个新的single对象s1，此时小明重新抢回使用权，他不会再重新判断对象是否存在了，而是直接创建一个新的single对象s2，所以这个时候就会有两个single对象被创建了，就不是单例了，所以这就是懒汉单例模式会出现的线程安全问题。怎么解决呢，加一个锁就可以了。
```java
class Single2 {
	private static Single2 s = null; 
// 改进懒汉式（线程安全，效率不高，两次判断）

    	private Single2() {

	}

	public static Single2 getInstance() {
     synchronized("锁"){
		 if (s == null) {
			 s = new Single2();
		 }
      }
	  return s;
	}
}

//但是加上锁之后，这个时候每次都要判断一次锁的状态和s的状态，两次判断效率不高，所以怎么解决呢，在外层再加上一层判断，可以大大提高效率。
class Single2 {
	private static Single2 s = null; 
// 改进懒汉式（线程安全，效率高，一次判断）

    	private Single2() {

	}

	public static Single2 getInstance() {
        if (s == null) {
             synchronized("锁"){
		         if (s == null) {
			         s = new Single2();
		         }
              }
}
		return s;
	}
}

```

## 26. transient关键字
我们都知道一个对象只要实现了Serilizable接口，这个对象就可以被序列化，java的这种序列化模式为开发者提供了很多便利，我们可以不必关系具体序列化的过程，只要这个类实现了Serilizable接口，这个类的所有属性和方法都会自动序列化。

然而在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化，而其他属性不需要被序列化，打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），为了安全起见，不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）中被传输，这些信息对应的变量就可以加上transient关键字。换句话说，这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。

总之，java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。

1. 一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
2. transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
3. 被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。

第三点确实没错（一个静态变量不管是否被transient修饰，均不能被序列化），反序列化后类中static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的

我们知道在Java中，对象的序列化可以通过实现两种接口来实现，若实现的是Serializable接口，则所有的序列化将会自动进行，若实现的是Externalizable接口，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。

[原文链接](http://www.cnblogs.com/lanxuezaipiao/p/3369962.html)

## 27. volatile关键字

一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：

1. 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
2. 禁止进行指令重排序。

synchronized关键字是防止多个线程同时执行一段代码，那么就会很影响程序执行效率，而volatile关键字在某些情况下性能要优于synchronized，但是要注意volatile关键字是无法替代synchronized关键字的，因为volatile关键字无法保证操作的原子性。通常来说，使用volatile必须具备以下2个条件：

1. 对变量的写操作不依赖于当前值
2. 该变量没有包含在具有其他变量的不变式中

实际上，这些条件表明，可以被写入 volatile 变量的这些有效值独立于任何程序的状态，包括变量的当前状态。
事实上，我的理解就是上面的2个条件需要保证操作是原子性操作，才能保证使用volatile关键字的程序在并发时能够正确执行。
下面列举几个Java中使用volatile的几个场景:
- 状态标记量
- double-check（单例模式）
  
  
[原文链接](https://www.cnblogs.com/dolphin0520/p/3920373.html)


## Todo: Fail-fast
https://www.cnblogs.com/dolphin0520/p/3920373.html

## 



# References

1. https://www.jianshu.com/p/1f1d3193d9e3
2. https://blog.csdn.net/lonelyroamer/article/details/7868820
3. https://blog.csdn.net/rmn190/article/details/1492013
