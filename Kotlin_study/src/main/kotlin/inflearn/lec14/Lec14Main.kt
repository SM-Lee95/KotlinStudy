package inflearn.lec14

fun main() {
    val objectDto = ObjectDto("이성무", 200)
    val objectDto2 = ObjectDto("이성무", 200)
    println(objectDto === objectDto2)
}

data class ObjectDto(val name: String, val age: Int)

fun handleCountry(country: Country){
    when(country){
        Country.KOREA -> println("한국")
        else -> println("미국")
    }
}

enum class Country(private val code: String){
    KOREA("ko"),
    AMERICA("us"),
}