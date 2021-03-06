package me.aflak.dagger2_mvp.ui.Login.interactor;

import android.os.Handler;

import me.aflak.dagger2_mvp.data.model.ObjectManager;
import me.aflak.dagger2_mvp.entity.User;

/**
 * Created by Omar on 16/02/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private ObjectManager objectManager;

    public LoginInteractorImpl(ObjectManager objectManager) {
        this.objectManager = objectManager;
    }

    @Override
    public void login(final String username, final String password, final LoginCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(username.isEmpty()){
                    callback.onUsernameError("empty!");
                    return;
                }

                if(password.isEmpty()){
                    callback.onPasswordError("empty!");
                    return;
                }

                callback.onSuccess(new User(username, password));
            }
        }, 3000);
    }

    @Override
    public void saveUser(User user) {
        objectManager.save(user, "user");
    }
}
