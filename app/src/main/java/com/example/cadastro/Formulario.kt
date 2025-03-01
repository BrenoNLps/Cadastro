package com.seuapp

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressarLista: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome: $nome\nTelefone: $telefone\nEmail: $email\nIngressar Lista: $ingressarLista\nSexo: $sexo\nCidade: $cidade\nUF: $uf"
    }
}
