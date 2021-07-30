package com.sunmkim.app.part2.fastcampustandroidbasic.Kotlin


fun main(args: Array<String>){

    first()
    println(second(84))
    println(third(39))
    println(third(1000))
    fourth()



    // 1번 문제
    // List를 두개 만든다
    // 첫번째 List에는 0 부터 9까지 값을 넣는다 (반복문 사용)
    // 두번째 List에는 첫번째 List의 값을 하나씩 확인한후
    // 짝수면 True 홀수면 False를 넣어 준다

    // 2번 문제
    // 학점을 구하자
    // 80 - 90 -> A
    // 70 - 79 -> B
    // 60 - 69 -> C
    // 나머지 F

    // 3번 문제
    // 전달 받은 숫자의 각 자리 숫의 합을 구하자
    // 조건 : 전달 받은 숫자는 무조건 두자리 숫자이다
    // 4번 문제
    // 구구단을 출력하자



}

fun first(): Unit{
    var list = mutableListOf<Int>()
    var listTwo = mutableListOf<Boolean>()
    for (i in 0..9) {
        list.add(i)
    }
    for (i in list) {
        if (i%2==0) {
            listTwo.add(true)
        } else {
            listTwo.add(false)
        }
    }

    println(list)
    println(listTwo)
}

fun second(grade:Int): Char {
    var result = ' '
    when (grade){
        in 80..90 -> result = 'A'
        in 70..79 -> result = 'B'
        in 60..69 -> result = 'C'
        else -> result = 'F'
    }
    return result
}

fun third(number:Int):Int{
    var sum = 0
    var n = number
    if (number < 10 || number > 99) {
        println("두자리숫자만가능합니다.")
        return number
    }
    else {
        sum += n / 10
        n %= 10
        sum += n
    }

    return sum
}

fun fourth(){
    for (i in 2..9){
        for (j in 1..9){
            print("$i * $j = ${i*j}  ")
        }
        println()
    }
}