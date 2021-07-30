package com.sunmkim.app.part2.fastcampustandroidbasic.Kotlin

// 2) 은행 계좌 만들기
//    - 계좌 생성 기능 (이름, 생년 월일)
//    - 잔고를 확인 하는 기능
//    - 출금 기능
//    - 예금 기능

fun main(args: Array<String>){

    val account1 = Account("김선명","1992.02.17",10000,"0000")
    account1.checkBalance()
    account1.withDraw("0000",20000) // 잔액부족
    account1.withDraw("0001",10000) // 비밀번호 에러
    account1.withDraw("0000",5000) // 출금
    account1.deposit("0000",20000)
    account1.checkBalance()

}

class Account(var name:String,var date:String,var balance:Int,var password:String){
    fun checkBalance(){
        println("현재 잔고는 $balance 입니다 ")
    }

    fun withDraw(inputPassword:String,money:Int){
        if (inputPassword == password) {
            if (balance >= money) {
                val temp = balance - money
                this.balance = temp
                println("${money}원 출금되었습니다. 잔고 $balance")
            }
            else {
                println("잔액이부족합니다.")
            }
        }
        else {
            println("비밀번호가 다릅니다.")
        }

    }

    fun deposit(inputPassword:String,money:Int){
        if (inputPassword == password) {
            this.balance = balance + money
            println("잔고 $balance ")
        }
        else {
            println("비밀번호가 다릅니다.")
        }
    }

}

