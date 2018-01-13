import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import java.security.Provider;

/**
 * Created by Masum Abedin on 11/28/2017.
 */

public class AuthenticatorService extends Service {
private Stubauthenticator mAuthenticator;

    @Override
    public void onCreate() {
        mAuthenticator = new Stubauthenticator(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    public IBinder onBind(Intent intent) {
        return  mAuthenticator.getIBinder();
    }
}
