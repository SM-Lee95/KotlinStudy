import kotlin.streams.asSequence

fun main() {
    val solution = 대충만든자판()

    solution.solution(arrayOf("AA"), arrayOf("B")).forEach { println(it) }
}

class 대충만든자판 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = IntArray(targets.size){ -1 }
        val alphabet = IntArray(100) { 101 }
        keymap.forEach {
            it.toCharArray().forEachIndexed { index, c -> alphabet[c-'A'] = if(alphabet[c-'A'] > index+1) index+1 else alphabet[c-'A']  }
        }
        targets.forEachIndexed { index, s -> answer[index] = s.toCharArray().sumOf { c ->  if(alphabet[c-'A']==101)-10001 else alphabet[c-'A'] } }
        answer.forEachIndexed{ index, value -> if(value < 0) answer[index] = -1}
        return answer
    }
}