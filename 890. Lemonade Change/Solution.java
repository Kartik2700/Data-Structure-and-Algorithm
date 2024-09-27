class Solution {
    public boolean lemonadeChange(int[] bills) {
        int i = 0;
        int total = 0;
        int five = 0, ten = 0;
        while (i < bills.length) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five >= 1) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else {
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if(five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}