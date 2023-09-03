package inflearn.lec17

import com.lannstark.lec17.Fruit

fun main() {
 val isApple = fun(fruit: Fruit): Boolean{
     return fruit.name == "사과"
 }
    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }
    val isApple3: (Fruit)->Boolean = { fruit: Fruit -> fruit.name == "사과" }

    println(isApple.invoke(Fruit("사과",12)))
    println(isApple2(Fruit("사과",10)))

    filterFruits(fruits = listOf(Fruit("사과",12),Fruit("오렌지",13)), filter = isApple2)
}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit)->Boolean): List<Fruit>{
    val results = mutableListOf<Fruit>()
    for(fruit in fruits){
        if(filter(fruit))
            results.add(fruit)
    }
    return results
}