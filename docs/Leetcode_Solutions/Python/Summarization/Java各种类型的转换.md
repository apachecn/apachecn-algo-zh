之前在写java程序的时候，经常会遇到很多的需要需要转换基础数据类型的情况，然后我就一直去记录这些情况，今天做了一下总结，当然转换的方法肯定不止我写的这些，有的我可能只会写其中的一种，以后再遇到其他的情况的话，我会慢慢来补充，希望这篇文章会对大家能有所帮助。

------

# String的转换

首先介绍一下String类型的转换，一般遇到的情况可能会有以下几种：Strng转int，String转long，String转byte数组，String转float，下面主要介绍这四种情况。

## String转int

把String类型转换为int类型，常用的有以下三种方法：

```
public class StringToInt {
	public static void main(String[] args) {
		String number = "123456";
		int num1 = Integer.parseInt(number);//使用Integer的parseInt方法
		int num2 = new Integer(number);//强制转换
		int num3 = Integer.valueOf(number).intValue();//先转Integer类型，再调用intValue()转为int
	}
}
```

## String转long

把String类型转换为long类型的方法跟上面的方法类似。

```
public class StringToLong {
	public static void main(String[] args) {
		String number = "1234567890";
		long num1 = Long.parseLong(number);//调用Long类型的parseLong方法
		long num2 = new Long(number);//强制转换
		long num3 = Long.valueOf(number).longValue();//先转换Long类型，再使用longValue方法转为long
	}
}
```

## String转float

把String类型转换为float类型的方法也跟上面的类似。

```
public class StringToFloat {
	public static void main(String[] args) {
		String number = "1234.202";
		float num1 = Float.parseFloat(number);//调用Float的parseFloat方法
		float num2 = new Float(number);//强制转换
		float num3 = Float.valueOf(number).floatValue();//先转为Float类型再使用floatValue转为float
	}
}
```

## String转byte[]

String类型转byte数组方法一般使用String类自带的`getBytes()`方法。

```
public class StringToByte {
	public static void main(String[] args) {
		byte[] num = new byte[200];
		String number = "1234567890";
		num = number.getBytes();
	}
}
```

这里补充一个path类型转换为String类型的方法：

```
String fileName=path.getFileName().toString();
```

------

# long类型转换

long类型的转换，这一部分用的情况也很多，下面介绍几种常见的情况。

## long转String

long类型转String类型，这里主要介绍三种方法：

```
public class LongToString {
	public static void main(String[] args) {
		long number = 1234567890l;
		String num1 = Long.toString(number);//Long的tostring方法
		String num2 = String.valueOf(number);//使用String的valueOf方法
		String num3 = "" + number;//这个应该属于强制转换吧
	}
}
```

## long转int

long类型转换为int类型，这里也主要介绍三种方法：

```
public class LongToInt {
	public static void main(String[] args) {
		long number = 121121121l;
		int num1 = (int) number;// 强制类型转换
		int num2 = new Long(number).intValue();// 调用intValue方法
		int num3 = Integer.parseInt(String.valueOf(number));// 先把long转换位字符串String，然后转换为Integer
	}
}
```

## long与byte数组的相互转换

一直都感觉byte数组转换比较繁琐，这里也不再叙述，我就给出一篇别人的博客让大家作为参考吧，这里面byte数组与多种数据类型的转换——[ java Byte和各数据类型(short,int,long,float,double)之间的转换](http://blog.csdn.net/cshichao/article/details/9813973)

------

# int类型的转换

int类型的转换也是我们经常使用的情况，下面也主要介绍几种常见的情况。

## int转String

int类型转换为String类型与long转String的类似，一般也有以下三种方法。

```
public class IntToString {
	public static void main(String[] args) {
		int number = 121121;
		String num1 = Integer.toString(number);//使用Integer的toString方法
		String num2 = String.valueOf(number);//使用String的valueOf方法
		String num3 = "" + number;//也是强制转换吧
	}
}
```

## int与Byte的相互转换

关于int类型与byte[]数组的转换，一般情况下，我们使用条件都是在这里转换过来，在另外一个地方就要转换回来，这里介绍两种int与byte数组互相转换的方式。

```
//int类型转换为byte[]数组
public static byte[] intToByteArray(int i) {
	byte[] result = new byte[4];
	// 由高位到低位
	result[0] = (byte) ((i >> 24) & 0xFF);
	result[1] = (byte) ((i >> 16) & 0xFF);
	result[2] = (byte) ((i >> 8) & 0xFF);
	result[3] = (byte) (i & 0xFF);
	return result;
}

//byte数组转换为int类型
public static int byteArrayToInt(byte[] bytes) {
	int value = 0;
	// 由高位到低位
	for (int i = 0; i < 4; i++) {
		int shift = (4 - 1 - i) * 8;
		value += (bytes[i] & 0x000000FF) << shift;// 往高位游
	}
	return value;
}
```

还有一种为：

```
//int类型转换为byte[]数组
public static byte[] intToByteArray(int x) {
	byte[] bb = new byte[4];
	bb[3] = (byte) (x >> 24);
	bb[2] = (byte) (x >> 16);
	bb[1] = (byte) (x >> 8);
	bb[0] = (byte) (x >> 0);
	return bb;
}

//byte数组转换为int类型
public static int byteArrayToInt(byte[] bb) {
	return (int) ((((bb[3] & 0xff) << 24) | ((bb[2] & 0xff) << 16) | ((bb[1] & 0xff) << 8) | ((bb[0] & 0xff) << 0)));
}
```

## int转long

int类型转换为long类型的情况并不是大多，这里主要接收几种转换方法：

```
public class IntToLong {
	public static void main(String[] args) {
		int number = 123111;
		long num1 = (long) number;//强制
		long num2 = Long.parseLong(new Integer(number).toString());//先转String再进行转换
		long num3 = Long.valueOf(number);
	}
}
```

## int转Interger

int类型转换为Interger类型的情况，我是基本上每怎么遇到过，在这里也上网查询一些资料找到了两种方法。

```
public class IntToInterge {
	public static void main(String[] args) {
		int number = 123456;
		Integer num1 = Integer.valueOf(number);
		Integer num2 = new Integer(number);
	}
}
```

------

# byte数组的转换

关于byte数组的转换，上面有几个都是它们只见相互转换的，所以这里就不再介绍那么多，只介绍一个byte数组转换String类型的方法，其他的类型可以通过String类型再进行转换。

byte数组转String类型的方法经常用的可能就是下面这种方法。

```
public class ByteToString {
	public static void main(String[] args) {
		byte[] number = "121121".getBytes();
		String num1 = new String(number);
	}
}
```

------

最后简单补充以下Java基本数据类型的一些知识：

| 类型     | 字节数  | 类名称      | 范围                                       |
| ------ | ---- | -------- | ---------------------------------------- |
| int    | 4字节  | Interger | -2147483648 ~ 2147483647                 |
| short  | 2字节  | Short    | -32768 ～ 32767                           |
| long   | 8字节  | Long     | -9223372036854775808 ～ 9223372036854775807 |
| byte   | 1字节  | Byte     | -128 ～ 127                               |
| float  | 4字节  | Float    |                                          |
| double | 8字节  | Double   |                                          |