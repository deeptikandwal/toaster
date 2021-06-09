package com.example.mykotlinapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapp.Person
import com.example.mykotlinapp.R
import com.example.mykotlinapp.SealedRunner
import java.math.BigInteger
import java.util.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    var name: String? = ""
    var num1: Int = 4
    var num2: Int = 7
    var r: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = "Deepti"

        println("Myname is : ${name?.length}")//safe call ?.
        println("The addition of $num1 and $num2 is ${num1.plus(num2)}")


        r = if (num1 < num2)//if else is an expression
            0
        else 1

        var log = Logger.getLogger(MainActivity::class.java.name);
        log.info("Logger info")

        /* Ranges example*/
        var nums = 1.until(16)//
//        var nums=16 downTo  1
//        var nums=16.downTo(1)
        for (a in nums step 2)
            print(a)

        println(nums.count())

        /* Ranges example*/


        /* Collection example*/

        var list = listOf(8, 9, 6, 0, 8)
        var lists = List<String>(2) {
            "dipi";
            "preetam"
        }
        for ((i, e) in list.withIndex())
            println("$i : $e")

        val map = TreeMap<String, Int>()
        map["Deepti"] = 24
        map["preeti"] = 21

        for ((name, age) in map)
            println("$name : $age")


        /* Collection example*/

        /* Function expression example*/
        println(max(7, 58))
        /* Function expression example*/

        var seconActivity1: SeconActivity = SeconActivity()
        seconActivity1.skills = "Java"

        var seconActivity2: SeconActivity = SeconActivity()
        seconActivity2.skills = " World"

        var seconActivity3: SeconActivity = SeconActivity(25, "Preeti")
        seconActivity3.skills = seconActivity1 plus seconActivity2
        println(seconActivity3.skills)


        var result: BigInteger
        result = fact(BigInteger("70"), BigInteger.ONE)
        println(result)

        val employee: SealedRunner = SealedRunner.Manager(13, "Divyank")
        when (employee) {
            is SealedRunner.Manager -> println("The name of employee is ${employee.name}")
            is SealedRunner.RegularEmployee -> println("The salary of employee is ${employee.salary}")
            is SealedRunner.Single -> println("hEY i AM sINGLE")
            //no else case required
        }


        val thread = Thread(object :Runnable{
            override fun run() {
                TODO("Not yet implemented")
            }
        })
        thread.start()
        doAction()

        getWebsite()


        val person = Person("Deepti", 11).apply {
            name.length
            standard = 6
        }

    }


    fun getWebsite() {

        ///Pair and triple in kotlin can be used to store and return multiple values

        val variable1 = "Declaring String variable"
        val variable2 = 1 // declaring integer value

        val variableName =
            Triple(variable1, variable2, "hello madam") // using declared variable in Pair class
        val list = variableName.toList()

        println(list[0]) // this will print the value of variable1
        println(list[1]) //
        println(variableName.third) //
    }

    fun doAction() {

//        labels it breaks the loop entirely not just the nearest loop
        loopi@ for (i in 1..3) {
            for (j in 5..7) {
                if (i == 2 && j == 6) break@loopi
                print((i * 100) + j)
                print(" ")
            }
            println(i.toString() + " loop ends")
        }

        println("We are done")
    }

    fun max(a: Int, b: Int): Int = if (a > b) a else b

    infix fun SeconActivity.plus(seconActivity: SeconActivity): String {

        return this.skills + seconActivity.skills

    }

    tailrec fun fact(num: BigInteger, res: BigInteger): BigInteger {
        if (num == BigInteger.ZERO)
            return res
        else
            return fact(num - BigInteger.ONE, num * res)
    }

}