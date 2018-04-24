package com.graph.src

var graph = Array(5,{IntArray(5)})
var visited : BooleanArray = booleanArrayOf(false,  false, false, false, false)

fun dfs(from : Int, to : Int){
    if( visited[to] || to == -1)
        return
    visited[to] = true
    if ( from != -1)
        println("Node from : " + from.toString() + " to : " + to.toString() + " = " + graph[from][to].toString())
    for(i in 0..4){
        if( to != i && graph[to][i] > 0){
            dfs(to, i)
        }
    }
    return
}
fun initGraph(){
    graph[0][0] = 0
    graph[0][1] = 22
    graph[0][2] = 9
    graph[0][3] = 12
    graph[0][4] = -1

    graph[1][0] = 22
    graph[1][1] = 0
    graph[1][2] = 35
    graph[1][3] = -1
    graph[1][4] = -1

    graph[2][0] = 9
    graph[2][1] = 35
    graph[2][2] = 0
    graph[2][3] = 4
    graph[2][4] = 65

    graph[3][0] = 12
    graph[3][1] = -1
    graph[3][2] = 4
    graph[3][3] = 0
    graph[3][4] = 33

    graph[4][0] = -1
    graph[4][1] = -1
    graph[4][2] = 65
    graph[4][3] = 33
    graph[4][4] = 0

}
fun main(args: Array<String>){
    initGraph()
    dfs(-1,0)


}