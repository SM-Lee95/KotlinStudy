package inflearn.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {

}

fun parseIntOrThrow(str: String): Int{
    try {
        return str.toInt()
    }catch(e: NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }
}
fun parseIntOrNull(str: String): Int?{
    return try {
        str.toInt()
    }catch(e: NumberFormatException){
        null
    }
}

fun readFile(){
    val current = File(".");
    val file = File(current.absolutePath+ "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
}
class FilePrinter{
    fun readFile(path: String){
        BufferedReader(FileReader(path)).use{
            println(it.readLine())
        }
    }
}

