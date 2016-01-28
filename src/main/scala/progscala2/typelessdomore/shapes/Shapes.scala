package progscala2.typelessdomore.shapes

case class Point(x: Double = 0.0, y: Double = 0.0){
    def shift(deltax: Double = 0.0, deltay: Double = 0.0) = copy(x + deltax, y + deltay)
}