package com.example.masumabedin.myapplication;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

Account mAccount = null; //ai khane amr account gola raklam amr ke ke account lagbe
    public static final String ACCOUNT = "dummy";//aita amr akta account
public static final String AUTHORITY = "com.example.masumabedin.myapplication";//aita amr authority
    public static final String ACCOUNT_TYPE = "masumabedin.myapplication";//aita meta data file use kore

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mAccount = CreateAccount(this);//create account,if account doesn't exist ,create one else return existsing account
        ContentResolver.setSyncAutomatically(mAccount,AUTHORITY,true);//eita set korse karn eita system  setting k controled kore
    }



    private Account CreateAccount(Context context) {
        Account account = new Account(ACCOUNT,ACCOUNT_TYPE);//account class toire korlam object er nam delam account
        AccountManager manager = (AccountManager) (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);//akta account service manager delam,service korar jonno
        if(manager.addAccountExplicitly(account,null, null)) {//add  account. return true if new account added.
            ContentResolver.addPeriodicSync(account, AUTHORITY, Bundle.EMPTY, 10);//if newly added account ,add sync periodicly 10 second por por periodic deva
        }

        return account;
    }


}