package inflearn.lec05

fun main() {
    when (val number = 3) {
        3 -> println("주어진 숫자는 3입니다.")
        in 1..10 -> println("주어진 숫자는 $number")
        else -> println("주어진 숫자는 모르겠습니다.")
    }
}