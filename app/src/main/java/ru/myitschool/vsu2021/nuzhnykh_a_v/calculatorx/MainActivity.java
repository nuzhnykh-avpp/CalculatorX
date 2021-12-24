package ru.myitschool.vsu2021.nuzhnykh_a_v.calculatorx;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*private Button digit1Btn;
    private Button digit2Btn;
    private Button digit3Btn;
    private Button digit4Btn;
    private Button digit5Btn;
    private Button digit6Btn;
    private Button digit7Btn;
    private Button digit8Btn;
    private Button digit9Btn;
    private Button digit0Btn;*/
    private Button[] digitsBtn;
    private Button dotBtn;

    private Button plusBtn;
    private Button minusBtn;
    private Button multBtn;
    private Button divBtn;

    private Button resetBtn;
    private Button computeBtn;
    private TextView numberFieldTV;

    private class NumberManager {
        private long value = 0;
        public void show() {
            numberFieldTV.setText(String.valueOf(value));
        }
        public void writeDigit(int d) {
            value = value * 10 + d;
            show();
        }
    }

    private final NumberManager number = new NumberManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digitsBtn = new Button[10];
        digitsBtn[1] = findViewById(R.id.main_activity_digit1_btn);
        digitsBtn[2] = findViewById(R.id.main_activity_digit2_btn);
        digitsBtn[3] = findViewById(R.id.main_activity_digit3_btn);
        digitsBtn[4] = findViewById(R.id.main_activity_digit4_btn);
        digitsBtn[5] = findViewById(R.id.main_activity_digit5_btn);
        digitsBtn[6] = findViewById(R.id.main_activity_digit6_btn);
        digitsBtn[7] = findViewById(R.id.main_activity_digit7_btn);
        digitsBtn[8] = findViewById(R.id.main_activity_digit8_btn);
        digitsBtn[9] = findViewById(R.id.main_activity_digit9_btn);
        digitsBtn[0] = findViewById(R.id.main_activity_digit0_btn);

        /*digit1Btn = findViewById(R.id.main_activity_digit1_btn);
        digit2Btn = findViewById(R.id.main_activity_digit2_btn);
        digit3Btn = findViewById(R.id.main_activity_digit3_btn);
        digit4Btn = findViewById(R.id.main_activity_digit4_btn);
        digit5Btn = findViewById(R.id.main_activity_digit5_btn);
        digit6Btn = findViewById(R.id.main_activity_digit6_btn);
        digit7Btn = findViewById(R.id.main_activity_digit7_btn);
        digit8Btn = findViewById(R.id.main_activity_digit8_btn);
        digit9Btn = findViewById(R.id.main_activity_digit9_btn);
        digit0Btn = findViewById(R.id.main_activity_digit0_btn);*/

        dotBtn = findViewById(R.id.main_activity_dot_btn);
        plusBtn = findViewById(R.id.main_activity_plus_operation_btn);
        minusBtn = findViewById(R.id.main_activity_minus_operation_btn);
        multBtn = findViewById(R.id.main_activity_mult_operation_btn);
        divBtn = findViewById(R.id.main_activity_div_operation_btn);

        resetBtn = findViewById(R.id.main_activity_reset_btn);
        computeBtn = findViewById(R.id.main_activity_compute_btn);
        numberFieldTV = findViewById(R.id.main_activity_number_field_tv);

        class NumberInputClickListener implements View.OnClickListener {
            private final int digit;

            public NumberInputClickListener(int digit) {
                this.digit = digit;
            }

            @Override
            public void onClick(View v) {
                number.writeDigit(digit);
            }
        }
        for (int i = 0; i < digitsBtn.length; i++)
            digitsBtn[i].setOnClickListener(new NumberInputClickListener(i));

        /*digit1Btn.setOnClickListener(new NumberInputClickListener(1));
        digit2Btn.setOnClickListener(new NumberInputClickListener(2));*/
    }
}