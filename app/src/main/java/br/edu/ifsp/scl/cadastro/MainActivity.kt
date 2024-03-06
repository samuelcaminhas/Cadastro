package br.edu.ifsp.scl.cadastro

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nomeEt: EditText
    private lateinit var telefoneEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var emailCb: CheckBox
    private lateinit var sexoRg: RadioGroup
    private lateinit var cidadeEt: EditText
    private lateinit var ufSp: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nomeEt = findViewById(R.id.nomeEt)
        telefoneEt = findViewById(R.id.telefoneEt)
        emailEt = findViewById(R.id.emailEt)
        emailCb = findViewById(R.id.emailCb)
        sexoRg = findViewById(R.id.sexoRg)
        cidadeEt = findViewById(R.id.cidadeEt)
        ufSp = findViewById(R.id.ufSp)

        val limparBt: Button = findViewById(R.id.limparBt)
        limparBt.setOnClickListener {
            clearFormFields()
        }

        val cadastrarBt: Button = findViewById(R.id.cadastrarBt)
        cadastrarBt.setOnClickListener {
            val formString = formToString()
            Toast.makeText(this, formString, Toast.LENGTH_LONG).show()
        }
    }

    private fun clearFormFields() {
        nomeEt.text.clear()
        telefoneEt.text.clear()
        emailEt.text.clear()
        emailCb.isChecked = false
        sexoRg.check(R.id.masculinoRb)
        cidadeEt.text.clear()
        ufSp.setSelection(0)
    }

    private fun formToString(): String {
        val nome = nomeEt.text.toString()
        val telefone = telefoneEt.text.toString()
        val email = emailEt.text.toString()
        val emailChecked = if (emailCb.isChecked) "Yes" else "No"
        val sexo = if (sexoRg.checkedRadioButtonId == R.id.masculinoRb) "Masculino" else "Feminino"
        val cidade = cidadeEt.text.toString()
        val uf = ufSp.selectedItem.toString()

        return "Nome: $nome\nTelefone: $telefone\nEmail: $email\nReceber novidades por email? $emailChecked\nSexo: $sexo\nCidade: $cidade\nUF: $uf"
    }
}