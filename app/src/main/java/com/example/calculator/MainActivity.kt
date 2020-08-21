package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    companion object {
        var noOnLeft: StringBuilder? = null
        var noOnTheRight: StringBuilder? = null
        var result: Long = 0
        var operation: StringBuilder? = null
    }


    lateinit var etOperation: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etOperation = findViewById(R.id.operation_edit_text)
        val tvResult = findViewById<TextView>(R.id.result_text_view)
        val btnOne = findViewById<Button>(R.id.one)
        val btnTwo = findViewById<Button>(R.id.two)
        val btnThree = findViewById<Button>(R.id.three)
        val btnFour = findViewById<Button>(R.id.four)
        val btnFive = findViewById<Button>(R.id.five)
        val btnSix = findViewById<Button>(R.id.six)
        val btnSeven = findViewById<Button>(R.id.seven)
        val btnEight = findViewById<Button>(R.id.eight)
        val btnNine = findViewById<Button>(R.id.nine)
        val calculate = findViewById<Button>(R.id.caclulate)

        val btnAdd = findViewById<Button>(R.id.plus)
        val btnMinus = findViewById<Button>(R.id.minus)
        val btnMultiply = findViewById<Button>(R.id.multiply)
        val btnDivide = findViewById<Button>(R.id.divide)

        setOnClickListenersToButtons(
            btnOne,
            btnTwo,
            btnThree,
            btnFour,
            btnFive,
            btnSix,
            btnSeven,
            btnEight,
            btnNine
        )

        setOnClickListenersToOperands(btnAdd, btnDivide, btnMultiply, btnMinus)

        calculate.setOnClickListener { tvResult.text = calculate() }
    }


    private fun clickAndAppendNumbers(view: Button) {
        if (operation.isNullOrBlank()) {
            if (noOnLeft.isNullOrBlank()) noOnLeft =
                StringBuilder(view.text) else noOnLeft!!.append(
                view.text
            )
            etOperation.append(view.text)
        } else {
            if (noOnTheRight.isNullOrBlank()) noOnTheRight =
                StringBuilder(view.text) else noOnTheRight!!.append(
                view.text
            )
            etOperation.append(view.text)
        }
    }


    private fun setOnClickListenersToButtons(vararg views: Button) {
        for (view in views) {
            view.setOnClickListener { clickAndAppendNumbers(view) }
        }
    }

    private fun setOnClickListenersToOperands(vararg views: Button) {
        for (view in views) {
            view.setOnClickListener { setOperand(view) }
        }
    }

    private fun setOperand(view: Button) {
        if (operation.isNullOrBlank()) operation = StringBuilder(view.text)
        etOperation.append(view.text.toString())
    }


    private fun calculate(): String {
        val expression = etOperation.text.toString()
        when {
            expression.contains("+") -> {
                result = noOnLeft.toString().toLong() + noOnTheRight.toString().toLong()
            }
            expression.contains("-") -> {
                result = noOnLeft.toString().toLong() - noOnTheRight.toString().toLong()
            }
            expression.contains("*") -> {
                result = noOnLeft.toString().toLong() * noOnTheRight.toString().toLong()
            }
            expression.contains("/") -> {
                result = noOnLeft.toString().toLong() / noOnTheRight.toString().toLong()
            }
        }
        return "Answer: $result"
    }


}