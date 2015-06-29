// Reducing Lists

def boolReduce(l: List[Int], start: Boolean)(f: (Boolean, Int) => Boolean): Boolean = {
  var a = start
  for(i <- l) a = f(a, i)
  a
}
val included = boolReduce(List(46, 19, 92), false){(a, i) =>
  if (a) a else (i == 19)
}

// generalize above function by type parameters A and B
def reduceOp[A, B](l: List[A], start: B)(f: (B, A) => B): B = {
  var a = start
  for (i <- l) a = f(a, i)
  a
}

val new_included = reduceOp(List(46, 19, 92), false){ (a, i) =>
  if(a) a else (i == 19)
}

val answer = reduceOp(List(11.3, 23.5, 7.2), 0.0)(_ + _)
// (_ + _) 의 경우 reduceOp 내부에서 호출 시 f(a, i) = (_ + _)와 같은 형태로 호출되며,
// f의 매개변수는 한번씩만 호출되기 때문에 placeholder syntax(_)를 사용해도 문제가 없다.


