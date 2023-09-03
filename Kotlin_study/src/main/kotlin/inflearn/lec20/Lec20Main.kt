package inflearn.lec20

import inflearn.lec09.Person

fun main() {
    printPerson(Person("이성무"))
}

fun printPerson(person: Person?){
    person?.let {
        println(it.age)
        println(it.isAdult)
    }
}