package inflearn.lec12

import com.lannstark.lec12.Movable
import inflearn.lec10.Flyable

fun main() {
    println(Singleton.a)
    Singleton.a++
    println(Singleton.a)

    moveSomeThing(object : Movable{
        override fun move() {
            print("익명 클래스")
        }
        override fun fly() {
            print("익명 클래스")
        }
    })
}

class Person private constructor(var name: String, var age: Int){
    companion object Factory : Flyable{
        private const val MIN_AGE = 1
        fun newBaby(name: String){
            Person(name, MIN_AGE)
        }

        override fun act() {
            println(MIN_AGE)
        }
    }
}
object Singleton{
    var a: Int = 0;
}

private fun moveSomeThing(movable: Movable){
    movable.move()
    movable.fly()
}