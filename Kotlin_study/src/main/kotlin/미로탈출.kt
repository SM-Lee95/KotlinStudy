import java.util.*

fun main() {
    val solution = 미로탈출
    println(solution.solution(arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE")))
    println(solution.solution(arrayOf("LOOXS","OOOOX","OOOOO","OOOOO","EOOOO")))
}

object 미로탈출 {
    class Xy(val x: Int, val y: Int)
    private val dx = arrayOf(-1, 1, 0, 0)
    private val dy = arrayOf(0, 0, -1, 1)
    fun solution(maps: Array<String>): Int {
        lateinit var start: Xy
        lateinit var end: Xy
        lateinit var lever: Xy
        maps.forEachIndexed { index, s ->
            if (s.indexOf('S') > -1)
                start = Xy(index, s.indexOf('S'))
            if (s.indexOf('E') > -1)
                end = Xy(index, s.indexOf('E'))
            if (s.indexOf('L') > -1)
                lever = Xy(index, s.indexOf('L'))
        }
        val findLever =  find(lever, start, maps)
        val findEnd = find(end, lever, maps)
        return if(findLever == -1||findEnd == -1) -1 else findEnd + findLever
    }

    fun find(target: Xy, start: Xy, map: Array<String>): Int {
        var cnt: Int = 0;
        val queue: Queue<Xy> = LinkedList();
        val boolean = Array(map.size) { BooleanArray(map[0].length) }
        queue.add(start);
        while (!queue.isEmpty()) {
            val size = queue.size;
            for (sizeIndex in 1..size) {
                val xy: Xy = queue.poll();
                for (index in dx.indices) {
                    with(xy) {
                        val lx = x + dx[index]
                        val ly = y + dy[index]
                        if(lx == target.x && ly == target.y) return cnt + 1;
                        if (lx>-1&&ly>-1&&lx<map.size&&ly<map[0].length&&!boolean[lx][ly] && map[lx][ly] != 'X') {
                            boolean[lx][ly] = true;
                            queue.add(Xy(lx,ly))
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}