package inflearn.lec03

import com.lannstark.lec03.Person

fun main() {
    val number1: Int? = 4
    val number2: Long = number1?.toLong() ?: 0
    println(number1?:0 + number2)
    printAgeIfPerson(Person("",100))
    println("""
        ABC
        EFG
        $number2
    """.trimIndent())
    val str = "ABC"
    println(str[0])
    println(str[1])
    println(str[2])
}

fun printAgeIfPerson(obj: Any?){
    val person = obj as? Person
    println(person?.age)
    if(obj is Person){ // context 분석해서 smart cast
        val person = obj as Person //cast
        println(person.age)
    }
    if(obj !is Person){
        println("Not Person")
    }
}