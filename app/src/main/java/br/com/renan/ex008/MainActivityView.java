package br.com.renan.ex008;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.renan.ex008.control.DadoController;
import br.com.renan.ex008.model.DiceType;

/*
*@author: renan santos carvalho
*/
public class MainActivityView extends AppCompatActivity {

    private RadioButton rbOneDice;
    private RadioButton rbTwoDice;
    private Spinner spDiceType;
    private TextView tvResult;
    private final DadoController controller = new DadoController(6, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbOneDice = findViewById(R.id.rbOneDice);
        rbTwoDice = findViewById(R.id.rbTwoDice);
        RadioButton rbThreeDice = findViewById(R.id.rbThreeDice);
        rbThreeDice.setChecked(true);

        spDiceType = findViewById(R.id.spDado);
        Button btnRoll = findViewById(R.id.btnRolar);
        tvResult = findViewById(R.id.tvDiceResult);

        fillSpinner();
        btnRoll.setOnClickListener(e -> rollToView(viewToRoll()));

    }

    private int[] viewToRoll() {
        Integer type = (Integer) this.spDiceType.getSelectedItem();
        int select = rbOneDice.isChecked() ? 1 : rbTwoDice.isChecked() ? 2 : 3;
        return this.controller.setNumberOfDice(select).setDiceType(type).roll();
    }

    private void rollToView(int... rolls) {
        StringBuilder sb = new StringBuilder();
        for (int r : rolls) {
            sb.append(getString(R.string.dice_label)).append(": ");
            sb.append(r);
            sb.append("\n");
        }
        this.tvResult.setText(sb.toString());
    }

    private void fillSpinner() {
        List<Integer> list = Arrays.stream(DiceType.values()).map(DiceType::getValue).collect(Collectors.toList());
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spDiceType.setAdapter(adapter);
    }
}