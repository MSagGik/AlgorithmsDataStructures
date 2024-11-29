package com.msaggik.algorithmsdatastructures

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    var isCapital = true
    var endPoints = HashMap<Int, MutableSet<Int>>()

    if (n in 2..100000 && m in 1..200000) {
        for (i in 0..<m) {
            val route = reader.readLine().split(" ")
            val start = route[0].toInt()
            val end = route[1].toInt()
            if (endPoints.containsKey(end)) {
                endPoints[end]?.add(start)
                endPoints[end] = endPoints[end]!!
            } else {
                val listValue = HashSet<Int>()
                listValue.add(start)
                endPoints[end] = listValue
            }
        }
    } else {
        isCapital = false
    }

    var result = 0

    val filterEndPoints = endPoints.filter { (k, v) -> (v.size >= (n-1)) }
    result = when {
        (endPoints.size == 1 && filterEndPoints.size == 1 && isCapital) -> {
            filterEndPoints.keys.elementAt(0)
        }

        (endPoints.size > 1 && filterEndPoints.size == 1 && isCapital) -> {
            val keyFilter = filterEndPoints.keys.elementAt(0)
            var buffer = keyFilter
            endPoints.map { (k, v) ->
                {
                    if (k != keyFilter && v.contains(keyFilter)) {
                        buffer = -1
                    }
                }
            }
            buffer
        }

        else -> -1
    }

    writer.write("$result")

    reader.close()
    writer.close()
}
