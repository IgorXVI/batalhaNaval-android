package com.example.alunos.batalhanavalandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_novo_jogo.*

class NovoJogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_jogo)

        btn_comecar.setOnClickListener {
            val editDigiteNome = findViewById<EditText>(R.id.edit_digiteNome)
            val txt = editDigiteNome.text.toString()

            if(txt.isEmpty()){
                var t = Toast.makeText(this,
                        "É necessário informar o nome do seu almirante.", Toast.LENGTH_SHORT)
                t.show()
            }
            else{
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("humano", Jogador(txt))
                intent.putExtra("bot", Bot())

                intent =  Intent(this, JogadaHumanoActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btn_voltar.setOnClickListener {
            val intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
