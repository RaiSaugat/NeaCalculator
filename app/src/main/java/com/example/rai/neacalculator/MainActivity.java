package com.example.rai.neacalculator;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first;
    EditText second;
    TextView amount;
    RadioGroup rg;
    CheckBox check;
    RadioButton amp;
    Button cal;
    double one, two,third, diff;
    float totalAmount;
    String firstValue,secondValue, ampere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (EditText)findViewById(R.id.prev);
        second = (EditText)findViewById(R.id.curr);
        rg= (RadioGroup)findViewById(R.id.capacity);
        check = (CheckBox)findViewById(R.id.payment);
        cal = (Button)findViewById(R.id.calculate);
        amount = (TextView)findViewById(R.id.amount);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                amp = (RadioButton)findViewById(checkedId);
                ampere = amp.getText().toString();
                if(ampere.matches("15 AMP"))
                {
                    third = 15;
                }
                else if(ampere.matches("Up to 5 AMP"))
                {
                    third = 5;
                }
                else if(ampere.matches("30 AMP"))
                {
                    third = 30;
                }
                else
                {
                    third = 60;
                }
            }
        });

       cal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String firstValue = first.getText().toString();
               String secondValue = second.getText().toString();
               if(firstValue.isEmpty() || secondValue.isEmpty())
               {
                   Toast.makeText(getApplicationContext(),"Please fill the units",Toast.LENGTH_SHORT).show();
               }
               else if(third==0)
               {
                   Toast.makeText(getApplicationContext(),"Please select your meter capacity",Toast.LENGTH_SHORT).show();
               }
                else
               {
                   one = Integer.parseInt(firstValue);
                   two = Integer.parseInt(secondValue);
                   diff = two - one;
                   if(third == 5) {
                       if (diff <= 20) {
                           totalAmount = 80;
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " +totalAmount);
                           }
                       }
                       else if ((diff > 20) && (diff <= 30))
                       {
                           totalAmount = (float) ((20 * 4) + (diff - 20) * 7.30);
                           if(check.isChecked()) {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                       else if((diff > 30) && (diff <= 50))
                       {
                           totalAmount = (float) ((diff) * 7.30);
                           if(check.isChecked()) {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                       else if((diff >50) && (diff <=150))
                       {
                           totalAmount = (float) ((20 * 7.30) + (50 * 8.60) + (diff - 50) * 8.60);
                           if(check.isChecked()) {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                       else if((diff >150) && (diff <=250))
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (diff - 150) * 9.50);
                           if(check.isChecked()) {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                       else
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (100 * 9.50) +  (diff - 250) * 11.00);
                           if(check.isChecked()) {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                   }
                   else if(third == 15)
                   {
                       if (diff <= 50) {
                           totalAmount = 365;
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs ");
                           }
                           else {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                       else if((diff >50) && (diff <=150))
                       {
                           totalAmount = (float) ((20 * 7.30) + (50 * 8.60) + (diff - 50) * 8.60);
                           if(check.isChecked()) {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs "+totalAmount);
                           }
                       }
                       else if((diff >150) && (diff <=250))
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (diff - 150) * 9.50);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " + totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " +totalAmount);
                           }
                       }
                       else
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (100 * 9.50) +  (diff - 250) * 11.00);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs "+ totalAmount);
                           }
                       }
                   }
                   else if(third == 30)
                   {
                       if (diff <= 100) {
                           totalAmount = 795;
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                           }
                           else
                           {
                               amount.setText("Rs " +totalAmount);
                           }
                       }
                       else if((diff >100) && (diff <=150))
                       {
                           totalAmount = (float) ((50* 7.30) + (diff-50) * 8.60);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs "+ totalAmount);
                           }
                       }
                       else if((diff >150) && (diff <=250))
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (diff - 150) * 9.50);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                       else
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (100 * 9.50) +  (diff - 250) * 11.00);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs "+totalAmount);
                           }
                       }
                   }
                   else
                   {
                       if (diff <= 200) {
                           totalAmount = 1765;
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs" + totalAmount);
                           }
                       }
                       else if((diff >150) && (diff <=250))
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (diff - 150) * 9.50);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else{
                               amount.setText("Rs "+totalAmount);
                           }
                       }
                       else
                       {
                           totalAmount = (float) ((20*7.30) + (30 * 7.30) + (100 * 8.60) + (100 * 9.50) +  (diff - 250) * 11.00);
                           if(check.isChecked())
                           {
                               totalAmount = (float) (totalAmount - (0.03 * totalAmount));
                               amount.setText("Rs " +totalAmount);
                           }
                           else
                           {
                               amount.setText("Rs " + totalAmount);
                           }
                       }
                   }
               }

           }
       });
    }
}
