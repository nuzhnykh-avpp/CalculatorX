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
        private boolean firstValueChanged = false;
        private long value2 = 0;
        private boolean secondValueChanged = false;
        private String sign = new String("");
        private final String plus = new String("+");
        private final String minus = new String("-");
        private final String div = new String("/");
        private final String mult = new String("*");

        public void show() {
            if (!secondValueChanged)
                numberFieldTV.setText(String.valueOf(value) + sign);
            else
                numberFieldTV.setText(String.valueOf(value) + sign + String.valueOf(value2));

        }

        public void show(long amount) {
            numberFieldTV.setText(String.valueOf(amount));
        }

        public void show(String text) {
            numberFieldTV.setText(text);
        }

        public void compute() {
            if (firstValueChanged && secondValueChanged) {
                long res = 0;
                if (sign.equals(plus))
                    res = value + value2;
                else if (sign.equals(minus))
                    res = value - value2;
                else if (sign.equals(div))
                    if (value2 != 0) {
                        res = value / value2;
                    }
                    else {
                        number.show("Zero division error");
                        secondValueChanged = false;
                        value2 = 0;
                        value = 0;
                        return;
                    }
                else if (sign.equals(mult))
                    res = value * value2;
                number.show(res);
                secondValueChanged = false;
                value2 = 0;
                value = res;

            }
        }

        public void writeDigit(int d) {
            if (sign.length() == 0) {
                value = value * 10 + d;
                firstValueChanged = true;
                show();
            }
            else {
                secondValueChanged = true;
                value2 = value2 * 10 + d;
                show();
            }
        }

        public void writeSign(String d) {
            if (firstValueChanged)
                sign = d;
                show();

        }


        public void clear() {
            value = 0;
            value2 = 0;
            sign = new String("");
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

        class ArithmeticOperations implements View.OnClickListener {
            private final String sign;

            public ArithmeticOperations(String sign) {
                this.sign = sign;
            }

            @Override
            public void onClick(View v) {
                number.writeSign(sign);
            }
        }

        for (int i = 0; i < digitsBtn.length; i++)
            digitsBtn[i].setOnClickListener(new NumberInputClickListener(i));

        // чистим поле при нажатии на C
        resetBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.clear();
            }
        });

        divBtn.setOnClickListener(new ArithmeticOperations(String.valueOf(divBtn.getText())));
        plusBtn.setOnClickListener(new ArithmeticOperations(String.valueOf(plusBtn.getText())));
        minusBtn.setOnClickListener(new ArithmeticOperations(String.valueOf(minusBtn.getText())));
        multBtn.setOnClickListener(new ArithmeticOperations(String.valueOf(multBtn.getText())));

        computeBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.compute();
            }
        });


        /*digit1Btn.setOnClickListener(new NumberInputClickListener(1));
        digit2Btn.setOnClickListener(new NumberInputClickListener(2));*/
    }
}