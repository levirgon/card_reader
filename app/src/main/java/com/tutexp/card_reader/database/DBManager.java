package com.tutexp.card_reader.database;

import android.app.Application;
import android.content.Context;

import com.tutexp.card_reader.model.Card;
import com.tutexp.card_reader.model.Card_;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

/**
 * Created by noushad on 1/27/18.
 */

public class DBManager {

    private static DBManager SDBManager;
    private Box<Card> cardBox;
    private Query<Card> cardQuery;
    private Context mContext;
    private Application mApplication;


    public static DBManager getInstance(Context context) {
        if (SDBManager == null) {
            SDBManager = new DBManager(context);
        }
        return SDBManager;
    }

    private DBManager(Context context) {
        mContext = context;
    }


    public void setApp(Application application) {
        if (mApplication == null) {
            mApplication = application;
            BoxStore boxStore = ((App) application).getBoxStore();
            cardBox = boxStore.boxFor(Card.class);
        }
    }

    public Card getCardInfo(String bin){
        cardQuery = cardBox.query().equal(Card_.existingBin, bin).build();
        return cardQuery.findFirst();
    }




    public void addCardInfo(Card card){
        cardBox.put(card);
    }

}
