package com.example.android_client_avatar_controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_client_avatar_controller.model.Particle;
import com.google.gson.Gson;

import java.util.EventListener;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements OnMessageListener{

    // -------------------------------------
    // XML references
    // -------------------------------------
    private EditText groupName;
    private EditText numParticles;
    private EditText posX;
    private EditText posY;
    private Button greenButton;
    private Button blueButton;
    private Button redButton;
    private Button createButton;
    private Button deleteButton;

    // -------------------------------------
    // Global assets
    // -------------------------------------
    private Gson gson;
    private TCPConnection tcp;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gson = new Gson();
        tcp = TCPConnection.getInstance();
        tcp.setObserver(this);

        groupName = findViewById(R.id.groupName);
        numParticles = findViewById(R.id.numParticles);
        posX = findViewById(R.id.posX);
        posY = findViewById(R.id.posY);
        greenButton =  findViewById(R.id.greenButton);
        blueButton = findViewById(R.id.blueButton);
        redButton = findViewById(R.id.redButton);
        deleteButton = findViewById(R.id.deleteButton);
        createButton = findViewById(R.id.createButton);

        final String[] typeText = {""};
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               typeText[0] = type(view);
            }
        };

        greenButton.setOnClickListener(onClickListener);
        blueButton.setOnClickListener(onClickListener);
        redButton.setOnClickListener(onClickListener);

        createButton.setOnClickListener(
                (view)->{

                    String groupNameText = groupName.getText().toString();
                    String numParticlesText = numParticles.getText().toString();
                    String posXText = posX.getText().toString();
                    String posYText = posY.getText().toString();

                    if( groupNameText!=null && !groupNameText.equals("")
                    && numParticlesText!=null && !numParticlesText.equals("")
                    && posXText!=null && !posXText.equals("")
                    && posYText!=null && !posYText.equals("")
                    && typeText[0]!=null && !typeText[0].equals("")){

                        Particle particle = new Particle(groupNameText, Integer.parseInt(numParticlesText),  Integer.parseInt(posXText),  Integer.parseInt(posYText),  typeText[0]);
                        String json = gson.toJson(particle);

                        tcp.sendMessage(json);

                    }else{
                        Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                    }

                }
        );

        deleteButton.setOnClickListener(
                (view)->{
                    String json = gson.toJson("delete");
                    tcp.sendMessage(json);
                }
        );

    }

    private String type(View view){
        String type = "";
        switch (view.getId()){
            case R.id.greenButton:
                type = "green";
                break;
            case R.id.blueButton:
                type = "blue";
                break;
            case R.id.redButton:
                type = "red";
                break;
        }
        return type;
    }



    // -------------------------------------
    // TCP Methods
    // -------------------------------------
    @Override
    public void onMessage(String msg) {

    }

}