package com.jimbob.ach;

import javax.xml.crypto.Data;

public interface Ach {
    public AchResponse issueDebit(AchCredentials credentials, AchTransaction achTransaction);
    public AchResponse markTransactionAsNSF(AchCredentials credentials, data, String traceCode);
    public AchResponse refundTransaction(AchCredentials credentials, Ach String traceCode);
    public AchResponse issueCredit(AchCredentials credentials, AchTransaction achTransaction);
    public AchResponse voidSameDayTransaction(AchCredentials credentials, Data data, String traceCode);
    public AchResponse queryTransactionStatus(AchCredentials credentials, Data data, String traceCode);

}
