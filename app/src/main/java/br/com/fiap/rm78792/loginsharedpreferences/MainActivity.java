package br.com.fiap.rm78792.loginsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtSenha;
    CheckBox chBoxSenha;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        chBoxSenha = (CheckBox) findViewById(R.id.chBoxSenha);

        //Inicializa o Shared Preferences no modo Privado.
        sp = getPreferences(MODE_PRIVATE);

        edtUsuario.setText(sp.getString("usuario",""));
        edtSenha.setText(sp.getString("senha",""));

    }//OnCreate

    public void logar(View view) {
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if (usuario.trim().equals("FIAP") && senha.trim().equals("123")) {

            if (chBoxSenha.isChecked()) {
                SharedPreferences.Editor e = sp.edit();
                e.putString("usuario",usuario);
                e.putString("senha",senha);
                e.commit();
            }
            return;
        }
        Toast.makeText(this, R.string.strUsuarioIncoreto, Toast.LENGTH_SHORT).show();
    }//Logar

}//Main Class