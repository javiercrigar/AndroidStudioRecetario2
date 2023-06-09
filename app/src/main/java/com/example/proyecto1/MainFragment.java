package com.example.proyecto1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyecto1.databinding.FragmentMainBinding;

import java.util.Calendar;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private CalendarView calendarView;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        calendarView= view.findViewById(R.id.calendario);
        ImageView imagen= (ImageView) view.findViewById(R.id.im_main);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Usuario.class);
                startActivity(intent);
            }
        });

        //He mirado este video para mirar los calendarios https://www.youtube.com/watch?v=quR2UW-VkU0&t=604s&ab_channel=ProgramEnthusiast
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int año, int mes, int dia) {
                ClaseDialogoAñadirPlato.setAño(año);
                ClaseDialogoAñadirPlato.setDia(dia);
                ClaseDialogoAñadirPlato.setMes(mes);
                ClaseDialogoAñadirPlato dialogo = new ClaseDialogoAñadirPlato();
                dialogo.show(getFragmentManager(), "Seleccione una accion");
            }
        });

        Button btn_camara= view.findViewById(R.id.camara);
        btn_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),Camara.class);
                startActivity(intent);
            }
        });


        return view;
    }

}