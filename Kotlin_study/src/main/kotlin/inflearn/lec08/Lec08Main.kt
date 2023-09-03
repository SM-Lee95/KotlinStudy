package inflearn.lec08

fun main() {
    printAll(*arrayOf("a","B","c"))
}

fun max(a: Int, b: Int)= if(a>b) a else b
fun min(a: Int, b: Int)= if(a<b) a else b
fun printAll(strings: String){
    repeat(str = "hellow world", useNewLine = false)
    printNameAndGender(name = "이성무" , gender="Female")
}

fun repeat(str: String, num: Int = 3 , useNewLine: Boolean= true){
    for( i in 1..num){
        if(useNewLine){
            println(str)
        }else{
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String){
    println(name)
    println(gender)
}

fun printAll(vararg strings: String){
    for(str in strings){
        println(str)
    }
}