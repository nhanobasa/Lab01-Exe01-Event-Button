package td.nhan.lab01_exe01_event_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etDai, etRong, etCao;
    private Button btn;
    private TextView result;
    private Integer calcType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDai = findViewById(R.id.etDai);
        etRong = findViewById(R.id.etRong);
        etCao = findViewById(R.id.etCao);
        result = findViewById(R.id.result);

        btn = findViewById(R.id.calc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a = Double.parseDouble(etDai.getText().toString());
                Double b = Double.parseDouble(etRong.getText().toString());
                Double c = Double.parseDouble(etCao.getText().toString());
                Double dt = 2 * (a * b + a * c + b * c);
                Double thetich = a * b * c;
                String res = "Kết quả: ";
                if (calcType == 0) {
                    result.setText(res + dt);
                } else {
                    result.setText(res + thetich);
                }
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rbDientich:
                if (checked)
                    calcType = 0;
                break;
            case R.id.rbThetich:
                if (checked)
                    calcType = 1;
                break;
        }
    }

}