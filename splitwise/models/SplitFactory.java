package models;

import enums.SplitType;
import models.split.EqualSplit;
import models.split.ExactSplit;
import models.split.PercentageSplit;
import models.split.Split;

public class SplitFactory {
    public static Split createSplit(User user, String type, Double... extra) throws Exception {
        switch (SplitType.valueOf(type)) {
            case EQUAL:
                return new EqualSplit(user);
            case EXACT:
                if(checkIfExtraIsPresent(extra)){
                    double amount = extra.length > 0 ? extra[0] : 0;
                    return new ExactSplit(user, amount);
                }
            case PERCENT:
                if(checkIfExtraIsPresent(extra)){
                    double percentage = extra.length > 0 ? extra[1] : 0;
                    return PercentageSplit(user, percentage);
                }
            default:
                throw new Exception("Invalid split type");
        }
    }

    private static boolean checkIfExtraIsPresent(Double... extra) {
        return extra.length > 0 && extra != null;
    }
    
    private static PercentageSplit PercentageSplit(User user, double percentage) {
        if(percentage > 100 || percentage < 0) {
            throw new IllegalArgumentException("Percentage cannot be more than 100");
        }
        return new PercentageSplit(user, percentage);
    }
}