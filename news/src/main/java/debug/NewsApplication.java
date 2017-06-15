package debug;

import com.shunyi.cydex.common.base.BaseApplication;

/**
 * Created by saisai on 2017/6/14.
 */

public class NewsApplication extends BaseApplication {
    public static NewsApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app=this;
    }
}
