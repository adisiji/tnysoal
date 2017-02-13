package nb.scode.tanyasoal.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import nb.scode.tanyasoal.app.App;

/**
 * Created by neobyte on 1/25/2017.
 */

public class FirebaseToken extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(FirebaseToken.class.getSimpleName(), "Refreshed token: " + refreshedToken);

        App.getInstance().setGcmToken(refreshedToken);
    }
}
