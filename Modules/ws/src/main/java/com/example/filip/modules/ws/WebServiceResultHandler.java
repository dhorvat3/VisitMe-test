package com.example.filip.modules.ws;

/**
 * Created by Filip on 1.12.2015..
 */

public interface WebServiceResultHandler {
    public void handleResult(
            String result,
            boolean ok,
            long timestamp
    );
}
