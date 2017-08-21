package com.github.chen0040.androidcodeview;

import com.github.chen0040.magento.MagentoClient;
import com.github.chen0040.magento.services.HttpComponent;

/**
 * Created by chen0 on 4/7/2017.
 */

public class AndroidMagentoClient extends MagentoClient {

    public AndroidMagentoClient(String baseUri) {
        super(baseUri, new AndroidHttpComponent());
    }

    public AndroidMagentoClient(String baseUri, HttpComponent httpComponent) {
        super(baseUri, httpComponent);
    }


}
