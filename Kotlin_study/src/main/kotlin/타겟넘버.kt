fun main() {
    val solution = Solution();
    solution.solution(intArrayOf(1, 1, 1, 1, 1),	3)
}
/**
 * fold -> reduce의 초기값 지정 함수
 * run -> 본인을 파라미터로 마지막을 리턴
 * map -> 다른 객체로 리턴
 * */
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }
}