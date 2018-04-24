package com.dijkstra

class City(var id: Int, var cost: Int, var from: Int){
    override fun toString(): String {
        return "City : " + (id + 'A'.toInt()).toChar() + " Cost : " + cost.toString() + " From : " + from.toString() + " "
    }
}

class CompareCity{
    companion object : Comparator<City> {
        override fun compare(o1: City, o2: City): Int {
            return o1.cost - o2.cost
        }
    }
}