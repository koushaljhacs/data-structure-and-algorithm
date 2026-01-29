package leetcode;

import java.util.Scanner;

class VersionControl {
    protected static int BadElement;

    public boolean isBadVersion(int version) {
        return version >= BadElement;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

public class FirstBadVersion {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        Solution Solution = new Solution();

        try {
            System.out.print("Enter the total number of version: ");
            int n = obj.nextInt();

            System.out.print("Enter the position where bad element is present: ");
            VersionControl.BadElement = obj.nextInt();
            if(VersionControl.BadElement < 1 || VersionControl.BadElement > n) {
                System.out.println("Bad element present withing the range of 1 to " + n + ". so, Please Enter within the range");
                return;
            }

            int index = Solution.firstBadVersion(n);

            System.out.println("Bad Version Present: " + index);
        } 
        catch (Exception e) {
            System.out.println("Some System Error: " + e.getMessage());
        } 
        finally {
            obj.close();
        }
    }
}