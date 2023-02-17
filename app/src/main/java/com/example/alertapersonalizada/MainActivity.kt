package com.example.alertapersonalizada
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mostarAlertaconBotonesPersonalizados()
    }

    private fun mostarAlertaconBotonesPersonalizados(){

        val alerta : Dialog
        alerta = Dialog(this) //usar un Dialog en vez de AlertDialog si también vamos a personalizar los botones
        val inflater: LayoutInflater = layoutInflater
        val vistaPersonalizada: View = inflater.inflate(R.layout.alerta_personalizada, null)
        val bnAceptar: Button = vistaPersonalizada.findViewById(R.id.bnAceptar)
        val bnCancelar: Button =vistaPersonalizada.findViewById(R.id.bnCancelar)
        val  etUserName : EditText = vistaPersonalizada.findViewById(R.id.username)
        val  etPassword : EditText = vistaPersonalizada.findViewById(R.id.password)
        bnAceptar.setOnClickListener{
            Toast.makeText(this, "Iniciar sesión con user "+etUserName.text, Toast.LENGTH_LONG).show()
            alerta.dismiss()
        }
        bnCancelar.setOnClickListener{
            Snackbar.make(vistaPersonalizada, "Cancelo petición",Snackbar.LENGTH_LONG).show()
            alerta.dismiss()//para cerrar la alerta
        }
        alerta.setContentView(vistaPersonalizada)
        alerta.setCancelable(false)
        alerta.show()
    }
}