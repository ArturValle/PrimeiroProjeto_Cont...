package br.com.artur.primeiroprojeto.extensions

fun Double.format(digitos: Int) = String.format("%.${digitos}f", this)

