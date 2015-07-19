def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
  if (cond) onTrue else onFalse

def maybeTwice(b: Boolean, i: => Int) = if (b) i+i else 0

val x = maybeTwice(true, {println("hi"); 1+42})

def maybeTwice2(b: Boolean, i: => Int) = {
  lazy val j = i
  if (b) j+j else 0
}

val x2 = maybeTwice2(true, {println("hi"); 1+41})

def constant[A](a: A): Stream[A] = {
  Stream.cons(a, constant(a))
}

def from(n: Int): Stream[Int] = {
  Stream.cons(n, from(n+1))
}

def fibs(n: Int): Stream[Int] = ???

