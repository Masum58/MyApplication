import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Masum Abedin on 12/9/2017.
 */

public class SyncAdaptera extends AbstractThreadedSyncAdapter {
    private Context mAppContest;

    // the construcator
    public SyncAdaptera(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mAppContest= context;
    }
    //the data transfer code implementation
    @Override
    public void onPerformSync(Account account, Bundle bundle, String s
                              ,ContentProviderClient contentProviderClient, SyncResult syncResult) {

        //URL of the website, this will be used in the HTTP_URL connection

        final  String url = "http://lorempixel.com/640/480";

        // Download the Image and keep in it the imageStore
        // mainActivity  will retrieve(mane holo Daron kora) the cuurent image from the image store


    }
    public void downloadImage(String path) throws IOException {
    final String TAG = "Download Task";
        Bitmap bitmap = null;
        InputStream inputStream;
try {
    //CREATE a url connection object and set is parameter
    URL url = new URL(path);
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    //Set Connection time out in 5 seccond
    urlConnection.setConnectTimeout(5000);
    //Set Connection time out in 2.5 seccond
    urlConnection.setReadTimeout(25000);
    // set HTTP request method
    urlConnection.setRequestMethod("GET");
    urlConnection.setDoInput(true);
    //Log to logcat window
    Log.i(TAG, "Download" + path);
    //Perform network request
    urlConnection.connect();
    //after the network response daron koro input strem
    inputStream = urlConnection.getInputStream();
    //convert the input steam into bitmap object
    bitmap = BitmapFactory.decodeStream(inputStream);
    //close the inputstream
    inputStream.close();

}catch (MalformedURLException e){
    //Exception handling
    Log.e(TAG,"Download error: "+e.getMessage());
}catch (IOException e){
    //Exception handling
    Log.e(TAG,"Download error: "+e.getMessage());
}
        }
    }

