package br.com.artur.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import br.com.artur.primeiroprojeto.extensions.format
import br.com.artur.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)
        // ou /* varias linhas */
        //Toast.makeText(this, peso, Toast.LENGTH_SHORT).show()

        calcularIMC(peso.toDouble(), altura.toDouble())

    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btnLimpar.setOnClickListener(){
            inputAltura.meuClear()
            inputPeso.meuClear()
        }

        btnCalcular.setOnClickListener(){
            chamarTelaResultado()
        }
    }


*/
    override fun onSupportNavigateUp() : Boolean{
        finish()
        return true
    }


    private fun calcularIMC(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)
        tvIMC.text = imc.format(0)

     /*   if (imc < 17){
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.magreza)
        } else if (imc < 18.5){
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.abaixo)
        } else if (imc < 24.9) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.ideal)
        } else if (imc < 29.9) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.sobre)
        } else if (imc < 34.9) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.sobre)
        } else if (imc < 39.9) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.obesidade)
        } else {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.obesidade)
        }
        */


        when (imc) {
            in 0..17 -> {

                tvIMC.text = imc.format(0)
                setImagem(R.drawable.magreza)
                tvIMCDescricao.text = "Magreza"

            }
            in 17.1..18.5 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.abaixo)
                tvIMCDescricao.text = "Abaixo do peso"

            }
            in 18.6..24.9 -> {

                tvIMC.text = imc.format(0)
                setImagem(R.drawable.ideal)
                tvIMCDescricao.text = "Peso ideal"
            }
            in 25.0..29.9 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.sobre)
                tvIMCDescricao.text = "Levemente acima do peso"

            }
            in 30.0..34.9 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.obesidade)
                tvIMCDescricao.text = "Acima do peso"

            }
            in 35.0..39.9 -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.obesidade)
                tvIMCDescricao.text = "Obesidade 1"

            }

            else -> {
                tvIMC.text = imc.format(0)
                setImagem(R.drawable.obesidade)
                tvIMCDescricao.text = "Obesidade 2"

            }

        }

    }

    private fun setImagem(resourceId: Int){
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))

    }
}

