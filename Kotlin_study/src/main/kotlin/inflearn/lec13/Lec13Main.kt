package inflearn.lec13

fun main() {

}


class JavaHouse(
    private val address: String,
    private val livingRoom: LivingRoom
){

    class LivingRoom(
        private val area: Double
    ){

    }
    inner class LivingRoomInner(
        private val area: Double
    ){
        val address: String
            get() = this@JavaHouse.address
    }
}