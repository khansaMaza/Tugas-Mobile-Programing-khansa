package com.project.MobileProgramming.khansamazaya;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class fragmentSatuan_berat extends Fragment {

    BigDecimal hasil_convert_metrik_ton, hasil_convert_kg, hasil_convert_gram, hasil_convert_miligram,
            hasil_convert_mikrogram, hasil_convert_ton_panjang, hasil_convert_ton_pendek, hasil_convert_stone,
            hasil_convert_pound, hasil_convert_ounce;
    EditText input;
    Spinner spinner;
    TextView text_metrik_ton, text_kg, text_gram, text_miligram, text_mikrogram, text_ton_panjang,
            text_ton_pendek, text_stone, text_pound, text_ounce;
    String input_string;
    BigDecimal input_to_double;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_satuan_berat, container, false);

        input = view.findViewById(R.id.siap_konversi);
        input_string = input.getText().toString();
        spinner = view.findViewById(R.id.spinner_satuan);

        text_metrik_ton = view.findViewById(R.id.value_metrik_ton);
        text_kg = view.findViewById(R.id.value_kilogram);
        text_gram = view.findViewById(R.id.value_gram);
        text_miligram = view.findViewById(R.id.value_miligram);
        text_mikrogram = view.findViewById(R.id.value_mikrogram);
        text_ton_panjang = view.findViewById(R.id.value_ton_panjang);
        text_ton_pendek = view.findViewById(R.id.value_ton_pendek);
        text_stone = view.findViewById(R.id.value_stone);
        text_pound = view.findViewById(R.id.value_pound);
        text_ounce = view.findViewById(R.id.value_ounce);

        hasil_convert_metrik_ton = BigDecimal.ZERO;
        hasil_convert_kg = BigDecimal.ZERO;
        hasil_convert_gram = BigDecimal.ZERO;
        hasil_convert_miligram = BigDecimal.ZERO;
        hasil_convert_mikrogram = BigDecimal.ZERO;
        hasil_convert_ton_panjang = BigDecimal.ZERO;
        hasil_convert_ton_pendek = BigDecimal.ZERO;
        hasil_convert_stone = BigDecimal.ZERO;
        hasil_convert_pound = BigDecimal.ZERO;
        hasil_convert_ounce = BigDecimal.ZERO;

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                input_string = charSequence.toString().trim(); // Trim whitespace

                if (input_string.isEmpty()) {
                    text_metrik_ton.setText("0");
                    text_kg.setText("0");
                    text_gram.setText("0");
                    text_miligram.setText("0");
                    text_mikrogram.setText("0");
                    text_ton_panjang.setText("0");
                    text_ton_pendek.setText("0");
                    text_stone.setText("0");
                    text_pound.setText("0");
                    text_ounce.setText("0");
                }else {
                    convert(input_to_double);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convert(input_to_double);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        return view;
    }

    private void convert(BigDecimal input_to_double){
        if (!input.getText().toString().isEmpty()&&spinner.getSelectedItemPosition() != 0){
            input_to_double = new BigDecimal(input_string);
            switch (spinner.getSelectedItemPosition()){
                //ton
                case 1:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("1000.0"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("1000000.0"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("1000000000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("1000000000000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.984207"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("1.10231"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("157.473"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("2204.62"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("35274.0"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //kg
                case 2:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.001"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("1000.0"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("1000000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("1000000000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.000984207"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.00110231"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("0.157473"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("2.20462"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("35.274"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //gram
                case 3:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.000001"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("0.001"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("1000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("1000000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.000000984207"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.00000110231"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("0.0000157473"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("0.00220462"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("0.035274"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //miligram
                case 4:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.000000001"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("0.000001"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("0.001"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("1000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.000000000984207"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.00000000110231"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("0.000000157473"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("0.00000220462"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("0.000035274"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //mikrogram
                case 5:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.000000000001"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("0.000000001"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("0.000001"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("1000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.000000000000984207"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.00000000000110231"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("0.0000000000157473"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("0.000000000220462"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("0.00000035274"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //ton panjang
                case 6:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("1016.05"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("1016.5"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("1016000.0"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("1016000000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("1016000000000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("1.12"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("160.0"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("2240.0"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("35840.0"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //ton pendek
                case 7:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.907185"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("907.185"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("907185.0"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("907185000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("907185000000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("1.12"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("142.857"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("2000.0"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("32000.0"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //stone
                case 8:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.00635029"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("6.35029"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("6350.29"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("635029000.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("635029000000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.000625"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.0007"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("14.0"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("224.0"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //pound
                case 9:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.000453592"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("0.453592"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("453.592"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("453592.0"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("453592000.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.0000446429"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.00005"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("0.0714286"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("1.0"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("16.0"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
                //ounce
                case 10:
                    hasil_convert_metrik_ton = input_to_double.multiply(new BigDecimal("0.000002835"));
                    hasil_convert_kg = input_to_double.multiply(new BigDecimal("0.0283495"));
                    hasil_convert_gram = input_to_double.multiply(new BigDecimal("28.3495"));
                    hasil_convert_miligram = input_to_double.multiply(new BigDecimal("28349.5"));
                    hasil_convert_mikrogram = input_to_double.multiply(new BigDecimal("28349500.0"));
                    hasil_convert_ton_panjang = input_to_double.multiply(new BigDecimal("0.00000027902"));
                    hasil_convert_ton_pendek = input_to_double.multiply(new BigDecimal("0.0003125"));
                    hasil_convert_stone = input_to_double.multiply(new BigDecimal("0.00446429"));
                    hasil_convert_pound = input_to_double.multiply(new BigDecimal("0.0625"));
                    hasil_convert_ounce = input_to_double.multiply(new BigDecimal("1.0"));

                    text_metrik_ton.setText(String.valueOf(hasil_convert_metrik_ton));
                    text_kg.setText(String.valueOf(hasil_convert_kg));
                    text_gram.setText(String.valueOf(hasil_convert_gram));
                    text_miligram.setText(String.valueOf(hasil_convert_miligram));
                    text_mikrogram.setText(String.valueOf(hasil_convert_mikrogram));
                    text_ton_panjang.setText(String.valueOf(hasil_convert_ton_panjang));
                    text_ton_pendek.setText(String.valueOf(hasil_convert_ton_pendek));
                    text_stone.setText(String.valueOf(hasil_convert_stone));
                    text_pound.setText(String.valueOf(hasil_convert_pound));
                    text_ounce.setText(String.valueOf(hasil_convert_ounce));
                    break;
            }
        }else {
            Toast.makeText(getActivity(), "Silahkan pilih satuan yang ingin dikonversi dan isi nilai yang ingin dikonversi", Toast.LENGTH_SHORT).show();
            text_metrik_ton.setText("0");
            text_kg.setText("0");
            text_gram.setText("0");
            text_miligram.setText("0");
            text_mikrogram.setText("0");
            text_ton_panjang.setText("0");
            text_ton_pendek.setText("0");
            text_stone.setText("0");
            text_pound.setText("0");
            text_ounce.setText("0");
        }
    }

}