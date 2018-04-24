package com.graph.src

import java.util.*

var queue: ArrayDeque<Int> = ArrayDeque<Int>()

fun bfs(){
    queue.addLast(0)
    while( !queue.isEmpty()){
        var current = queue.removeFirst()
        if( !visited[current]){
            visited[current] = true
            println("Visited Node : " + current.toString())
            for(neighbour in 0..4){
                if( current != neighbour && graph[current][neighbour] > 0){
                    queue.addLast(neighbour)
                }
            }
        }
    }
    return
}

fun main(args: Array<String>){
    initGraph()
    bfs()


}