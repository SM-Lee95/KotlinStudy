fun main(args: Array<String>) {
    println("Hello World!")
    println(3)
    // 주석 테스트
    /* 주석 테스트 */
    val this_value: Int = 3
    var this_variable: Int = 4
    this_variable = 3
    println(this_value)
    println(this_variable)
    var this_var: String = "333"
    var this_var2: String
    this_var2 = "243"
    println("$this_var >> $this_var2")
    var int: Int = 30
    var double: Double = 3.0
    var char: Char = 'k'
    var string: String = "String"
    var boolean: Boolean = true
    var long: Long = int.toLong()
    println(char);
    println(int.toChar())
    char = int.toChar()
    println(char);
    int++
    println(int)
    println(++int)
    println(true || int++ == 33)
    println(int)
    println(string.length)
    println(string.plus(string.plus(string.uppercase())))
    println("$string >>>> ${string.plus(string.lowercase())}")
    string = if(true) "true"
            else "false"
    println("$string")
    var intk = if(false) 2 else if(false) 3 else 4
    println("$intk")
    intk = when(intk){
        1 -> 2
        3 -> 4
        4 -> 5
        else -> 0
    }
    println("$intk")
    var bool: Boolean=true
    while(bool){
        println("$bool <<<< boolean value")
        bool = false
        println("$bool <<<< boolean value")
    }
    do{
        println("$bool <<<< boolean value")
    }while(bool)
    bool = true
    while(bool){
        println("$bool <<<< boolean value")
        if(bool){
            bool = false
            continue
        }
        //break;
       println("$bool <<<< boolean value")
    }
    var array = arrayOf("1","2",3,"4")
    println(array[2])
    println(array.size)
    println("3" in array)
    for(value in array){
        println(value)
    }
    for(value in 1..100){
        print("$value ,")
        printText("printText : ",value)
    }
    println()
    println(getText())
    println(getText(string))
    var card = Card()
    card.name = "naver pay"
    card.price = 3000
    var card2 = card
    println(card2.name)
    card.name = "never"
    println(card2.name)
    var car = Car("Hyundae", "sonata",2023)
    println(car.price)
    var brand = car.brand
    println(brand)
    car.price = 3
    println(car.price)
    var car2: CreditCard = CreditCard()
    println(car2.price2)
}
fun printText(str:String, ink:Int){
    print(str)
    print(ink)
}
fun getText(): String{
return "your text"
}
fun getText(k: String)= "$k <<<< this Text"

open class Card{
    var price: Int = 0
    var name: String = ""
}
class Car(var brand: String, var model: String, var year: Int){
    var price = 0
    var name = ""
}

class CreditCard: Card(){
    var price2: Int = 3
    var name2: String = ""
}