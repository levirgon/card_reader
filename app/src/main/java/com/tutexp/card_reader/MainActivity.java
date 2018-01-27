package com.tutexp.card_reader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tutexp.card_reader.database.DBManager;
import com.tutexp.card_reader.model.Card;

public class MainActivity extends AppCompatActivity {

    private EditText cardNumber1;
    private EditText cardNumber2;
    private DBManager mDBManager;
    private TextView networkText;
    private TextView typeText;
    private TextView bankText;
    private TextView brandText;
    private TextView prepaidText;
    private TextView numberText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        mDBManager = DBManager.getInstance(MainActivity.this);
        mDBManager.setApp(getApplication());
    }

    @Override
    protected void onResume() {
        super.onResume();
        addAllInformation();
    }

    private void addAllInformation() {
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL Nexus", "Debit", "BDT", "100001"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL Maestro", "Debit", "BDT/USD", "627959"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL VISA Electron", "Debit", "BDT", "444519"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL VISA Multi‐Currency Classic", "Debit", "BDT/USD", "444515"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL VISA Local Classic", "Debit", "BDT", "444516"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL VISA Multi‐Currency Gold", "Debit", "BDT/USD", "444517"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL VISA Local Gold ", "Debit", "BDT", "444518"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL M‐Chip Debit ", "Debit", "BDT/USD", "557667"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "Bangladesh Bank ", "Debit", "BDT", "100002"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL M‐Chip Credit", "Debit", "BDT", "542128"));
        mDBManager.addCardInfo(new Card("Dutch‐Bangla Bank Limited ", "DBBL M‐Chip Credit", "Debit", "BDT/USD", "530865"));
    }

    private void initializeViews() {
        cardNumber1 = findViewById(R.id.card_type_input);
        cardNumber2 = findViewById(R.id.bank_type_input);

        cardNumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = cardNumber1.getText().length();

                if (length == 4) {
                    //make query to check card type


                    //pass focus
                    cardNumber2.requestFocus();
                }
            }
        });

        cardNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = cardNumber2.getText().length();
                if (length == 2) {
                    //make query
                    String bin1 = cardNumber1.getText().toString();
                    String bin2 = cardNumber2.getText().toString();
                    try {
                        Card card = mDBManager.getCardInfo(bin1 + bin2);
                        //setInformation
                        updateUI(card);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Information Not Found", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        networkText = findViewById(R.id.card_network);
        typeText = findViewById(R.id.card_type);
        bankText = findViewById(R.id.card_bank);
        brandText = findViewById(R.id.card_brand);
        prepaidText = findViewById(R.id.card_prepaid);
        numberText = findViewById(R.id.card_number);
    }

    private void updateUI(Card card) {
        networkText.setText(card.getProductName());
        brandText.setText(card.getProductName());
        typeText.setText(card.getCardType());
        bankText.setText(card.getBankName());
        prepaidText.setText(card.getCurrency());
        brandText.setText(card.getProductName());
        numberText.setText(card.getExistingBin());


    }

}
