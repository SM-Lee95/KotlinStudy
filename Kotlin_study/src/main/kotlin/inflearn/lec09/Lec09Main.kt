package inflearn.lec09

class Person(name: String, var age: Int){
    val name = name
        get() = field.uppercase()
    init{
        if(age <= 0) throw IllegalArgumentException("$age 는 들어올 수 없습니다.")
    }
    constructor(name: String): this(name, 1)
    fun isAdult(): Boolean{
        return this.age >= 20
    }
    val isAdult: Boolean get() = this.age >= 20

}

fun main() {
    val person = Person("이성무", 12)
    println(person.name)
    person.age = person.age +1
    println(person.age)

}
