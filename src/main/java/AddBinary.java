public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                if (carry == 0) {
                    result.append(1);
                } else {
                    result.append(0);
                }
            } else {
                if (a.charAt(i) == '0') {
                    result.append(carry);
                    carry = 0;
                } else {
                    result.append(carry);
                    carry = 1;
                }
            }
            i--;
            j--;
        }
        while (j >= 0) {
            if (carry == 1) {
                if (b.charAt(j) == '1') {
                    result.append(0);
                } else {
                    result.append(1);
                    carry = 0;
                }
            } else {
                result.append(b.charAt(j));
            }
            j--;
        }
        while (i >= 0) {
            if (carry == 1) {
                if (a.charAt(i) == '1') {
                    result.append(0);
                } else {
                    result.append(1);
                    carry = 0;
                }
            } else {
                result.append(a.charAt(i));
            }
            i--;
        }
        if (carry == 1) {
            result.append(1);
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        AddBinary sol = new AddBinary();
        System.out.println(sol.addBinary("11", "1").equals("100"));
        System.out.println(sol.addBinary("1010", "1011").equals("10101"));
        System.out.println(sol.addBinary("1", "111").equals("1000"));
    }
}
