package inflearn.lec02

import com.lannstark.lec02.Person

fun main() {
    val str: String? = null
    //str.length //불가
    println(str?.length) //safe call(? 선언해준 곳이 널이면 뒤 함수 실행안하고 null 반환)
    println(str?.length ?: 0) //Elvis 연산자 (null이면 디폴트 값 설정)
    println(str!!.length) //Null 아님 단언
    val person = Person("공부하는 개발자")
    startsWithA(person.name)

}
fun startsWithA(str: String): Boolean{
    return str.startsWith("A")
}
fun startsWithA1(str: String?): Boolean{
    return str?.startsWith("A") ?: throw IllegalArgumentException("NPE")
}
fun startsWithA2(str: String?): Boolean?{
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean{
    return str?.startsWith("A") ?: false
}