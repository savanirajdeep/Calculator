package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumberEvent(view:View){
        if(isNewOp){
            findViewById<EditText>(R.id.etShowNumber).setText("")
        }
        isNewOp=false
        val buSelect = view as Button
        var buClickValue:String = findViewById<EditText>(R.id.etShowNumber).text.toString()
        when(buSelect.id){
            R.id.bu0->{
                buClickValue+="0"
            }
            R.id.bu1->{
                buClickValue+="1"
            }
            R.id.bu2->{
                buClickValue+="2"
            }
            R.id.bu3->{
                buClickValue+="3"
            }
            R.id.bu4->{
                buClickValue+="4"
            }
            R.id.bu5->{
                buClickValue+="5"
            }
            R.id.bu6->{
                buClickValue+="6"
            }
            R.id.bu7->{
                buClickValue+="7"
            }
            R.id.bu8->{
                buClickValue+="8"
            }
            R.id.bu9->{
                buClickValue+="9"
            }
            R.id.buDot->{
                buClickValue+="."
            }
            R.id.buPlusMins->{
                buClickValue="-"+ buClickValue
            }
        }
        findViewById<EditText>(R.id.etShowNumber).setText(buClickValue)
    }
    var op = "*"
    var oldNumber=""
    var isNewOp = true;
    fun buOpEevent(view: View) {
        val buSelect = view as Button
        when(buSelect.id) {
            R.id.buMul -> {
                op = "*"
            }
            R.id.buDiv -> {
                op = "/"
            }
            R.id.buSum -> {
                op = "+"
            }
            R.id.buSub -> {
                op = "-"
            }
        }
        oldNumber = findViewById<EditText>(R.id.etShowNumber).text.toString()
        isNewOp = true
    }
    fun buEqualEvent(view: View){
        val newNumber = findViewById<EditText>(R.id.etShowNumber).text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber = oldNumber.toDouble()*newNumber.toDouble()
            }
            "/"->{
                finalNumber = oldNumber.toDouble()/newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"-> {
                finalNumber = oldNumber.toDouble()-newNumber.toDouble()
            }
        }
        findViewById<EditText>(R.id.etShowNumber).setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercent(view:View){
        val number:Double = findViewById<EditText>(R.id.etShowNumber).text.toString().toDouble()/100
        findViewById<EditText>(R.id.etShowNumber).setText(number.toString())
        isNewOp=true
    }
    fun buClean(view:View){
        findViewById<EditText>(R.id.etShowNumber).setText("0")
        isNewOp=true
    }
}