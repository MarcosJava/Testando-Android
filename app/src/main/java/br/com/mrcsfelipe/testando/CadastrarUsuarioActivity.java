package br.com.mrcsfelipe.testando;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mrcsfelipe.testando.entity.Usuario;


public class CadastrarUsuarioActivity extends Activity {


    private EditText etNome, etEmail;



    private Button btSalvar;
    boolean masculino = false;
    private  Usuario u = new Usuario();
    private Switch toggle;

    public static List<Usuario> usuarios = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_usuario);

        this.etNome = (EditText) findViewById(R.id.etNome);
        this.etEmail= (EditText) findViewById(R.id.etEmail);
        this.btSalvar = (Button) findViewById(R.id.btSalvar);


        toggle = (Switch) findViewById(R.id.togglebutton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    //btSalvar.setEnabled(true);
                    Log.i("Switch" , "OK");
                    u.setSexo("M");
                    masculino = true;
                } else {
                    //btSalvar.setEnabled(false);

                    Log.i("Switch" , "NOT OK");
                    u.setSexo("F");
                }
            }
        });

    }

    public void clearView(){
        etNome.setText("");
        etEmail.setText("");
        u = new Usuario();
    }

    public void salvar(View v){


        String nome = etNome.getText().toString();
        String email = etEmail.getText().toString();

        u.setEmail(email);
        u.setNome(nome);


        if(toggle.isChecked()) u.setSexo("M");
        else u.setSexo("F");
        usuarios.add(u);

        clearView();



        Toast.makeText(this, "Salvo com Sucesso !", Toast.LENGTH_LONG).show();


        for(Usuario usuario : usuarios){
            Log.i("Usuario" , usuario.getNome());
            Log.i("Usuario" , usuario.getEmail());
            Log.i("Usuario" , usuario.getSexo());
        }

        /*
        Intent intent = new Intent(UsuarioCadastrado.ACAO_EXIBIR_SAUDACAO);
        intent.addCategory(UsuarioCadastrado.CATEGORIA_SAUDACAO);
        intent.putExtra(UsuarioCadastrado.EXTRA_NOME_USUARIO, nome);
        intent.putExtra(UsuarioCadastrado.EXTRA_EMAIL, email);
        startActivity(intent);
        */

    }




}
