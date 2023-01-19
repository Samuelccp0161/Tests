package com.jimbob;

import javax.xml.crypto.Data;

public interface Ach {
    public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data);
    public AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData data, String traceCode);
//    public AchResponse refundTransaction(AchCredentials credentials, Ach String traceCode);
//    public AchResponse issueCredit(AchCredentials credentials, AchTransaction achTransaction);
    public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode);
    public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data, String traceCode);

}
