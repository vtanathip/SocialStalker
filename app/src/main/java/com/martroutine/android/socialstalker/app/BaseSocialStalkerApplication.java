package com.martroutine.android.socialstalker.app;

import com.martroutine.android.common.skeleton.app.SocialStalkerApplication;

import java.util.Collections;
import java.util.List;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */
public class BaseSocialStalkerApplication extends SocialStalkerApplication {
    @Override
    protected List<Object> getAppModules() {
        return Collections.<Object>singletonList(new ApplicationScopeModule());
    }
}
