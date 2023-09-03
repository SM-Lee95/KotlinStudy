package inflearn.lec06

fun main() {
    val list = listOf(1L, 3L, 4L)
    for (number in list){
        println(number)
    }
    for (i in 1..10)
        println(i)
    for (i in 10 downTo 1)
        println(i)
    for (i in 10 downTo 1 step 2)
        println(i)
    for(i in 'a'..'z' step 2)
        println(i)
    for(i in 'z'..'a')
        println(i)
}