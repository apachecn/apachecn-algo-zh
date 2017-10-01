#Recusrion & BackTracking

##Recusrion

### DrawFractal

```
void DrawFractal(double x, double y, double w, double h)
{
  DrawTriangel(x, y, w, h);
  if(w < .2 || h < .2) return ;
  double halfH = h/2;
  double halfw = w/2;
  DrawFractal(x, y, halfW, halfH);
  DrawFractal(x + halfW/2, y + halfH, halfW, halfH);
  DrawFractal(x + halfW, y, halfW, halfH);
}
```


Sierpinski triangle更伪码的写法：

```
void DrawFractal (x, y, w, h){
	if (too small) return ;
	DrawTriangle(x, y, w, h);
	DrawFractal(.left);
	DrawFractal(.top);
	DrawFractal(.right);
}
```

实际上老师故意调了里面几句代码的顺序，让来看到虽然结果相同，但是画的过程是不一样的。

然后老师还在黑板上画了过程树，分枝是怎样的，实际上当学到DFS的preOrder， inOrder 和 postOrder的时候会更印象深刻。

一个分支走完之后再回去走另一些。


### DrawMondrian


 
```
void DrawMondrian(double x, double y, double w, double h){
  
  if(w < 1 || h < 1) return ;// base case
  
  FillRectangle(x,y,w,h,RandomColor()); // fill background

  switch(RandomInteger(0, 2)){
    case 0:  // do nothing
      break; 
    case 1:  // bisect vertically
      double midX = RandomReal(0,w);
      DrawBlackLine( x + midX, y, h);
      DrawMondrian(x, y, midX, h);
      DrawMondrian(x + midx, y, w- midX, h);
      break;
    case 2:  // bisect horizontally
      double midY = RandomReal(0,h);
      DrawBlackLine( x, y+ midY, h);
      DrawMondrian(x, y, w, midY);
      DrawMondrian(x, y+midY,w, midY);
      break;
      }
}
```


### The tower of Hanoi


```
void MoveTower(int n, char src, char dst, char tmp){
  if (n > 0){
    MoveTower(n - 1, src, tmp, dst );
    MoveSingleDisk(src, dst);
    MoveTower(n -1, tmp, dst, src);
  }
}

```


### Permutation

老师说permutation 和 subset 是 mother problems of all recursion.


given a string， print out its all permutations

思路如下：

- 使用了的string sofar，以及还未使用的string rest
- 一开始rest就是给的string本身，然后sofar是空
- 每次挑一个rest里面的char，然后递归的再把rest剩下的拿来permutation,这样每次都会有一个char从rest shuffle到sofar
- n 次之后 rest为空，制造了一个permutation 


```
void RecPermute(string sofar, string rest){
  if(rest = ""){
    cout << soFar << endl;
  } else {
     for(int i = 0 ; i < rest.length(); i++){
     string next = soFar + rest[i];
     string remaining = rest.substr(0,i) + rest.substr(i+1);
     RecPermute(next, remaining);
    }
  }
}


// "wrapper" function
void ListPermutations(string s)
{
  RecPermute("",s);
}
```


老师的黑板图真的是击中要害。

因为老师强调的是，也要用mind来trace它是如何操作的。



### Subsets 


```
void RecSubsets(string soFar, string rest)
{
  if(rest = "")
    cout << soFar << endl;
  else {
    // add to subset, remove from rest, recur
    RecSubsets(soFar + rest[0],rest.substr(1));
    //don't add to substr, remove from rest, recur
    RecSubsets(soFar, rest.substr(1));
  }
}


void ListSubsets(string str)
{
  RecSubsets("",str);
}

```

代码非常容易理解


比较一下：两个都是有关选择，permutation是每次选哪一个char，而subsets是选择这个char 是否in.

两个recursion tree都是有branching 和 depth的， depth都是n，每次选一个，知道n个选完.

branching是how many recusive calls 每次made，subset每次都是两个，in/out，而permutation则是n，n-1.......grows very quickly.

因为permutation是n！，subsets是2^n，跟树对应。这些都是比较intractable的问题，并不是因为recursion，而是问题本身的复杂度。


这两个问题都是exhaustive的，然而，我们会更多碰到一些问题，有着

similar exhaustive structure，但是遇到'satisfactory' outcome就会stop的 -> 也就是backtracking了.

##BackTracking



### pseudocode

把问题转成decision problem，然后开始make choice.

```
bool Solve(configuration conf)
{
  if (no more choices) // BASE CASE
    return (conf is goal state);

  for (all available choices){
    try one choice c;
    // sove from here, it works out. you're done.
    if (Solve(conf with choice c made))  return true;
    unmake choice c;
  } 
  return false;  //tried all choices, no soln found
}
```


###IsAnagram


```
bool IsAnagram(string soFar, string rest, Lexicon & lex)
{
  if(rest == ""){
      if(lex.contains(soFar)){
          cout << soFar << endl;
          return true;
      }
  } else {
      for(int i = 0; i < rest.length() ; i++ ){
          string next = soFar + rest[i];
          string remaining = rest.substr(0,i) + rest.substr(i+1);
          if(IsAnagram(next, remaining, lex)) return true;
      }
  }
  return false;
}
```


### 8 Queens 


```

bool Solve(Grid<bool> &board, int col)
{
  if(col > = board.numCols()) return true;
  
  for(int rowToTry = 0; rowToTry < board.numRows(); rowToTry++){
   if (IsSafe(board,rowToTry, col)){
        PlaceQueen(board,rowToTry,col);
	if (Solve(board,col+1)) return true;
	RemoveQueen(board,rowToTry, col);
     }
  }
  return false;
}

```

