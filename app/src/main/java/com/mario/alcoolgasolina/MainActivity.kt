package com.mario.alcoolgasolina

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_main_calcular.onClick { calcularMelhorPreco(et_main_alcool.text.toString(), et_main_gasolina.text.toString()) }
    }


    private fun validarCampos(precoAlcool: String, precoGasolina: String) = !precoAlcool.isNullOrBlank() && !precoGasolina.isNullOrBlank()

    private fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
        if(validarCampos(precoAlcool,precoGasolina)) {
            if((precoAlcool.toDouble() / precoGasolina.toDouble()) >= 0.7) tv_main_msg_result.text = "Melhor utilizar gasolina" else tv_main_msg_result.text = "Melhor utilizar Alcool"
        }else{
            tv_main_msg_result.text = "Preencha os preços primeiro!"
        }
    }
}
