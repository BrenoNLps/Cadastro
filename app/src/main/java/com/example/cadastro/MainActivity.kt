package com.example.cadastro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etTelefone: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbListaEmail: CheckBox
    private lateinit var rgSexo: RadioGroup
    private lateinit var etCidade: EditText
    private lateinit var spUF: Spinner
    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Cadastro"  // Garante que o título aparece
        supportActionBar?.setDisplayHomeAsUpEnabled(false) // Remove botão de voltar


        etNome = findViewById(R.id.etNome)
        etTelefone = findViewById(R.id.etTelefone)
        etEmail = findViewById(R.id.etEmail)
        cbListaEmail = findViewById(R.id.cbListaEmail)
        rgSexo = findViewById(R.id.rgSexo)
        etCidade = findViewById(R.id.etCidade)
        spUF = findViewById(R.id.spUF)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)


        val estados = arrayOf("Acre", "São Paulo", "Rio de Janeiro", "Minas Gerais", "Bahia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados)
        spUF.adapter = adapter


        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val telefone = etTelefone.text.toString()
            val email = etEmail.text.toString()
            val listaEmail = cbListaEmail.isChecked
            val sexoSelecionadoId = rgSexo.checkedRadioButtonId
            val sexo = if (sexoSelecionadoId != -1) {
                findViewById<RadioButton>(sexoSelecionadoId).text.toString()
            } else {
                "Não informado"
            }
            val cidade = etCidade.text.toString()
            val uf = spUF.selectedItem.toString()

            Toast.makeText(this, "Cadastro realizado:\nNome: $nome\nTelefone: $telefone\nEmail: $email\nSexo: $sexo\nCidade: $cidade\nUF: $uf", Toast.LENGTH_LONG).show()
        }


        btnLimpar.setOnClickListener {
            etNome.text.clear()
            etTelefone.text.clear()
            etEmail.text.clear()
            cbListaEmail.isChecked = false
            rgSexo.clearCheck()
            etCidade.text.clear()
            spUF.setSelection(0)
        }
    }
}
