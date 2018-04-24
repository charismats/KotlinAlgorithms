package com.dijkstra

import java.util.*

var graph = Array(6,{IntArray(6)})
var visited : BooleanArray = booleanArrayOf(false,  false, false, false, false, false)
var cities : ArrayList<City> = ArrayList<City>()

fun initGraph(){
    graph[0][0] = 0
    graph[0][1] = 22
    graph[0][2] = 9
    graph[0][3] = 12
    graph[0][4] = -1
    graph[0][5] = -1

    graph[1][0] = 22
    graph[1][1] = 0
    graph[1][2] = 35
    graph[1][3] = -1
    graph[1][4] = -1
    graph[1][5] = 36

    graph[2][0] = 9
    graph[2][1] = 35
    graph[2][2] = 0
    graph[2][3] = 4
    graph[2][4] = 65
    graph[2][5] = 42

    graph[3][0] = 12
    graph[3][1] = -1
    graph[3][2] = 4
    graph[3][3] = 0
    graph[3][4] = 33
    graph[3][5] = -1

    graph[4][0] = -1
    graph[4][1] = -1
    graph[4][2] = 65
    graph[4][3] = 33
    graph[4][4] = 0
    graph[4][5] = 18

    graph[5][0] = -1
    graph[5][1] = 36
    graph[5][2] = 42
    graph[5][3] = -1
    graph[5][4] = 18
    graph[5][5] = 0

}

fun printShortestPath(){
    for(city in cities){
        var path : String = printPath(0, city.id)
        print(city )
        println("Path : " + path)
    }
}
fun printPath(from : Int, to : Int ) : String{
    var path = "" + to.toString()
    var frm = to
    while(frm != from){
        frm = cities[frm].from
        path = frm.toString() + " -> " + path
    }
    return path
}
fun main(args: Array<String>){
    initGraph()
    for(i in 0..5){
        var c = City(i, 1000, -1)
        cities.add(c)
    }
    var myQueue: ArrayDeque<City> = ArrayDeque()
    //1. set start node to 0
    cities[0].cost = 0
    myQueue.addLast(cities[0])


    while( !myQueue.isEmpty()){
        var currentCity = myQueue.removeFirst()
        if( !visited[currentCity.id]){
            visited[currentCity.id] = true
            for( neighbour in 0..5){
                if( currentCity.id != neighbour &&
                        graph[currentCity.id][neighbour] > 0 &&
                        ( currentCity.cost + graph[currentCity.id][neighbour] < cities[neighbour].cost)){
                    cities[neighbour].from = currentCity.id
                    cities[neighbour].cost = currentCity.cost + graph[currentCity.id][neighbour]
                    myQueue.addLast(cities[neighbour])

                }
            }
            myQueue.sortedWith(CompareCity)
        }
    }
    printShortestPath()
}