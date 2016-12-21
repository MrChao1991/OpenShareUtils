package com.cfox.openshare.open.weixin;

import com.cfox.openshare.AbsConfig;
import com.cfox.openshare.SHARE_MEDIA;
import com.cfox.openshare.share.weixin.WXShare;
import com.tencent.mm.sdk.modelmsg.SendAuth;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : Hlsenior
 * <br/>PACKAGE_NAME : com.cfox.openshare.open.weixin
 * <br/>AUTHOR : Machao
 * <br/>MSG :
 * <br/>************************************************
 */
public class WXConfig  extends AbsConfig {
    public SendAuth.Resp mResp;

    public WXCenter mWXCenter;
    public WXShare mWXShare;

    @Override
    public SHARE_MEDIA getName() {
        return SHARE_MEDIA.WEIXIN;
    }

    @Override
    public boolean isConfigured() {
        return !(appId == null || appSecret == null);
    }

    @Override
    public boolean isAuthrized() {
        return authInfo != null;
    }
}
