class Base { var i = 10 }; class Sub extends Base

def increment[B <: Base](b: Base) = {b.i += 1; b}
