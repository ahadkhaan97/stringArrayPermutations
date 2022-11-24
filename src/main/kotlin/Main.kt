import java.util.*

fun main() {
    permutations(
        mutableListOf(
            "abc",
            "abx",
            "axx",
            "abc"
        )
    ).forEach {
        println(it.joinToString { it })
    }
}

fun permutations(input: MutableList<String>): MutableList<MutableList<String>> {
    val solutions = mutableListOf<MutableList<String>>()
    permutationsRecursive(input, 0, solutions)
    return solutions
}

fun permutationsRecursive(input: MutableList<String>, index: Int, answers: MutableList<MutableList<String>>) {
    if (index == input.lastIndex) answers.add(input.toMutableList())
    for (i in index..input.lastIndex) {
        Collections.swap(input, index, i)
        permutationsRecursive(input, index + 1, answers)
        Collections.swap(input, i, index)
    }
}