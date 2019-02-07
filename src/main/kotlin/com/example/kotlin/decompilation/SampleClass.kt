package com.example.kotlin.decompilation

class SampleClass {

    val a = arrayListOf<String>("a", "b", "c", "d", "e", "f", "g")

    fun oneLoop() {
        for (s in a) {
            val message = s.toUpperCase()
            println(message)
        }
    }

    fun oneLoopUsingAnArray() {
        var arrayOf = a.toArray() as Array<String>

        for (i in 0.rangeTo(arrayOf.size)) {
            arrayOf[i] = arrayOf[i].toUpperCase()
            println(arrayOf[i])
        }
    }

    fun twoLoopsUsingAnArray() {
        var arrayOf = a.toArray() as Array<String>

        for (i in 0.rangeTo(arrayOf.size)) {
            arrayOf[i] = arrayOf[i].toUpperCase()
        }

        for (i in 0.rangeTo(arrayOf.size)) {
            println(arrayOf[i])
        }
    }

    fun twoLoopWithIntermediateVariable() { //this is not converted
        val b = mutableListOf<String>()
        for (s in a) {
            b.add(s.toUpperCase())
        }

        for (s in b) {
            println(s)
        }
    }

    fun twoMaps_map_then_foreach() { //this is not converted
        a.map { it.toUpperCase() }.forEach { println(it) }
    }

    fun twoMaps_map_then_map() { //this is not converted
        a.map { it.toUpperCase() }.map { println(it) }
    }

}

data class Group(val arabic: Int, val roman: String)
