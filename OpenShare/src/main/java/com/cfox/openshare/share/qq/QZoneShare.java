package com.cfox.openshare.share.qq;

import android.app.Activity;
import android.os.Bundle;

import com.cfox.openshare.PlatformConfig;
import com.cfox.openshare.SHARE_MEDIA;
import com.cfox.openshare.open.qq.QQConfig;
import com.cfox.openshare.share.IShare;
import com.cfox.openshare.share.ShareAPI;
import com.cfox.openshare.share.qq.listener.QShareListener;
import com.cfox.openshare.utils.OSLog;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.Tencent;

import static com.tencent.connect.share.QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : Hlsenior
 * <br/>PACKAGE_NAME : com.cfox.openshare.share.qq
 * <br/>AUTHOR : Machao
 * <br/>MSG :
 * <br/>************************************************
 */
public class QZoneShare implements IShare {

    private static final String TAG = "QZoneShare";

    private Activity mActivity;
    private Tencent mTencent;

    private QQConfig mQQConfig;
    public QZoneShare(Activity activity) {
        this.mActivity = activity;
        mQQConfig = (QQConfig) PlatformConfig.configs.get(SHARE_MEDIA.QQ);
        if (mQQConfig == null){
            OSLog.e("openshare","place set appid and appSecret");
            return;
        }
        mTencent = Tencent.createInstance(mQQConfig.appId, mActivity.getApplicationContext());
    }

    @Override
    public void share(ShareAPI shareAPI) {
        final Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, shareAPI.getTitle());//必填
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, shareAPI.getText());//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL,shareAPI.getTargetUrl());//必填
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, shareAPI.getShareMedia().getImageUrls());
        mTencent.shareToQzone(mActivity, params, new QShareListener());
    }
}
