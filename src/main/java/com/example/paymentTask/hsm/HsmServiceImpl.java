package com.example.paymentTask.hsm;


import org.springframework.stereotype.Service;

@Service
public class HsmServiceImpl implements HSMService {

    String ip ,port ;
    @Override
    public void verifyPin(String pinKey, String pinBlock, String command ,String offset) {
        /*
        * initalize call to HSM with with pinkey  , pinblock and offset
        * */

    }

    @Override
    public void verifyARQC(String command, String... data) {

    }

    @Override
    public void generateARPC(String command, String... data) {

    }
}
