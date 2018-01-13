import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by Masum Abedin on 12/10/2017.
 */
//             ^backgroand er kaj kore
public class SyncService extends Service {
    private SyncAdaptera mSyncAdapter= null;
    private static final Object sSyncAdapterLock = new Object();
    @Override    //   onCreate jokhon service start hoi tokhon kaj kore

    public void onCreate() {
        //Create a single instance of the sync adapter instance
        Synchronized(sSyncAdapterLock);{
            if (mSyncAdapter == null) {
                mSyncAdapter = new SyncAdaptera(getApplicationContext(), true);
            }
        }

    }

    private void Synchronized(Object sSyncAdapterLock) {
    }

    public IBinder onBind(Intent intent) {
        return mSyncAdapter.getSyncAdapterBinder();
    }
}
