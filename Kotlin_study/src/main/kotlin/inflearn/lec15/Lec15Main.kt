package inflearn.lec15

fun main() {
    var array= arrayOf(100, 200)
    for(value in array)
        println(value)
    array = array.plus(300)
    println(array.size)
    for(i in array.indices)
        println("$i ${array[i]}")
    array.plus(400)
    for((idx, value) in array.withIndex()){
        println("$idx : $value")
    }
    // List
    val numbers = listOf(100, 200)
    val numbersMutable = mutableListOf(100,200,300)
    numbersMutable.add(400)
    // numbers.add(400) -> 불가
    val emptyList = emptyList<Int>()
    println(numbers[0])
    println(numbers.get(0))
    for( number in numbers){
        println(number)
    }
    for(idx in numbers.indices){
        println(numbers[idx])
    }
    val numberSet= mutableSetOf(100, 200)
    for((idx,value) in numberSet.withIndex())
        println("$idx : $value")

    val map= mutableMapOf<Int, String>()
    map[1] = "이성무"
    map[2] = "김진현"
    mapOf(1 to "이성무", 2 to "김진현")

    for(key in map.keys)
        println(map[key])
    for((key, value) in map.entries)
        println("$key : $value")

}
