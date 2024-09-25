package com.example.atividade_6_calculadora_de_gorjeta

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputValorConta = findViewById<EditText>(R.id.edValorConta)
        val inputGorjeta = findViewById<EditText>(R.id.edGorjeta)
        val resultado = findViewById<TextView>(R.id.resultado)
        val botaoCalcular = findViewById<Button>(R.id.btnCalcular)

        val money = DecimalFormat (" R$ #,###.00")


        botaoCalcular.setOnClickListener {

            val conta = inputValorConta.text.toString()
            val gorjeta = inputGorjeta.text.toString()

            if (conta.isNotEmpty() && gorjeta.isNotEmpty()){

                val valorContaDouble = conta.toDouble()
                val gorjetaDouble = gorjeta.toDouble()

                val valorGorjeta: Double = valorContaDouble * (gorjetaDouble / 100)
                val valorTotal: Double = valorContaDouble + valorGorjeta

                resultado.setText("Valor Gorjeta: ${money.format(valorGorjeta)}, Valor Total: ${money.format(valorTotal)}")

            }else{
                resultado.setText("Insira o Valor da conta e a Porcentagem da Gorjeta")
            }

        }

    }

    fun limparValores(view: View){
        val inputValorConta = findViewById<EditText>(R.id.edValorConta)
        val inputGorjeta = findViewById<EditText>(R.id.edGorjeta)
        val resultado = findViewById<TextView>(R.id.resultado)

        inputValorConta.setText("")
        inputGorjeta.setText("")
        resultado.setText("")
    }
}