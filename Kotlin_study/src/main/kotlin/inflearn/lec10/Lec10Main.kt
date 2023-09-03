package inflearn.lec10

fun main() {
    Derived(30)
}

interface Flyable{
    fun act(){
        println("파닥파닥")
    }
}
interface Swimable{
    val swimAblility: Int
        get() = 5
    fun act(){
        println("어푸어푸")
    }
}
abstract class Animal(protected val species: String,protected open val legCount: Int){
    abstract fun move()
}
class Cat(species: String) : Animal(species, 4) {
    override fun move() {
        println("고양이가 걸어간다.")
    }
}

class Penguin(species: String, private val wingCount: Int = 2) : Animal(species, 2), Swimable, Flyable{
    override fun move() {
        println("펭귄이 걸어간다.")
    }
    override val legCount: Int
        get() = super.legCount + this.wingCount
    override val swimAblility: Int
        get() = 3

    override fun act() {
        super<Flyable>.act()
        super<Swimable>.act()
    }
}

open class Base(open val number: Int = 100){
    init {
        println("Base Class Init")
        println(this.number) // open
    }
}

class Derived(
    override val number: Int = 10
) : Base(number){
    init{
        println("Derived Class Init")
        println(number)
    }
}