package com.cfox.openshare.listener;

import com.cfox.openshare.SHARE_MEDIA;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : Hlsenior
 * <br/>PACKAGE_NAME : com.cfox.openshare.listener
 * <br/>AUTHOR : Machao
 * <br/>MSG :
 * <br/>************************************************
 */
public interface IAuthListener extends IBackListener {

    void onCancel(SHARE_MEDIA shareMedia);
}
