package com.sunmkim.app.part2.fastcampustandroidbasic.Kotlin

// 1) 사칙 연산을 수행할 수 있는 클래스


fun main(args: Array<String>){

    val calculator1 = Calculator()
    println(calculator1.plus(4, 5))
    println(calculator1.minus(4, 5))
    println(calculator1.multiply(4, 5))
    println(calculator1.divide(4, 5))

    println()

    val calculator2 = Calculator2()
    println(calculator2.plus(1,2,3,4,5))
    println(calculator2.minus(10,1,2,3))
    println(calculator2.multiply(1,2,3))
    println(calculator2.divide(10,2,3))



}

class Calculator(){
    fun plus(a: Int, b: Int): Int {
        return a + b
    }
    fun minus(a:Int,b:Int):Int{
        return a - b
    }
    fun multiply(a:Int,b:Int):Int{
        return a * b
    }
    fun divide(a:Int,b:Int): Double{
        return (a / b).toDouble()
    }
}

class Calculator2(){
    fun plus(vararg numbers:Int): Int{
        var sum = 0
        numbers.forEach{ value ->
            sum += value
        }
        return sum
    }
    fun minus(vararg numbers:Int):Int{
        var sum = numbers[0] * 2
        numbers.forEach{ value ->
            sum -= value
        }
        return sum

    }
    fun multiply(vararg numbers:Int):Int{
        var sum = 1
        numbers.forEach{ value ->
            sum *= value
        }
        return sum

    }
    fun divide(vararg numbers:Int):Int{
        var sum = numbers[0]
        numbers.forEach{ value ->
            sum /= value
        }
        return sum

    }
}

