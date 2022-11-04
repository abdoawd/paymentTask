package com.example.paymentTask.hsm;

public interface HSMService {

    void verifyPin(String pinKey, String pinBlock,String command , String offset);
    void verifyARQC(String command ,String ... data);
    void generateARPC(String command ,String ... data);
}
