package com.example.estudiante.nomalo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estudiante.nomalo.R;
import com.example.estudiante.nomalo.model.Contact;
import com.example.estudiante.nomalo.preference.CacheManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Estudiante on 28/10/2015.
 */
public class NuevoContacto extends Fragment {

    private final String emailPattern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";

    @Bind(R.id.Nombre) EditText nombre;
    @Bind(R.id.Email) EditText correo;
    @Bind(R.id.Celular) EditText celular;
    @Bind(R.id.Telefono) EditText telefono;
    @Bind(R.id.Boton) Button boton;

    @OnClick(R.id.Boton)
    public void clickLogin(View v) {
        boolean valid = true;

        String nombretab = nombre.getText().toString().trim();
        String emailtab = correo.getText().toString().trim();
        String celtab = celular.getText().toString().trim();
        String phonetab = telefono.getText().toString().trim();

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        if (nombretab.length() > 0 && emailtab.length() > 0 && (celtab.length() > 0 || phonetab.length() > 0)) {

            if (nombretab.length() < 4) {
                showError("El nombre debe tener minimo 4 caracteres", v);
            } else if (!emailtab.matches(emailPattern)) {
                showError("El email es invalido", v);
            } else if (celtab.length() > 0 && celtab.length() != 10) {
                showError("No es un celular valido", v);
            } else if (phonetab.length() > 0 && phonetab.length() != 7) {
                showError("No es un telefono valido", v);
            }
        } else {
            showError("Error, Todos los campos son requeridos", v);
        }}

    private void showError(String err, View v) {
        Snackbar snackbar = Snackbar.make(v, err, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

        private CacheManager cacheManager;

        @Override
        public void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            cacheManager = new CacheManager(getContext());

        }

        @Nullable
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState){
            super.onCreateView(inflater, container, savedInstanceState);
            View rootView = inflater.inflate(R.layout.nuevo_contacto, container, false);
            ButterKnife.bind(this, rootView);
            return rootView;
        }

        @Override
        public void onViewCreated (View view, Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);

        }
    }



