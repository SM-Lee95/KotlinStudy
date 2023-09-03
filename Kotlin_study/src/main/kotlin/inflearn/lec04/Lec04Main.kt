package inflearn.lec04

import com.lannstark.lec04.JavaMoney

fun main() {
    val money1 = JavaMoney(1000L)
    val money2 = money1
    val money3 = JavaMoney(1000L)

    if(money1 > money2) // compareTo를 호출해준다.
        println("금액이 더 큽니다.")

    println(money1 === money2)
    println(money2 == money3)
    println(money2.plus(money3))

}
