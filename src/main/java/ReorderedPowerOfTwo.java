public class ReorderedPowerOfTwo {
    public static class Permute {
        // https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        private int[] indexes;
        private String source;

        public Permute(String source) {
            this.source = source;
            indexes = new int[source.length()];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = i;
            }
        }

        public String getNext() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index : indexes) {
                stringBuilder.append(source.charAt(index));
            }
            return stringBuilder.toString();
        }

        public boolean hasNext() {
            int i, j, k;
            // Find maximum index such that indexes[j+1]>indexes[j]
            for (j = indexes.length - 2; j >= 0; j--) {
                if (indexes[j + 1] > indexes[j]) {
                    break;
                }
            }
            if (j == -1) {
                return false;
            }
            // Find maximum index such that indexes[k] > indexes[j]
            for (k = indexes.length - 1; k > j; k--) {
                if (indexes[k] > indexes[j]) {
                    break;
                }
            }
            // Swap indexes[k], indexes[j]
            int temp = indexes[j];
            indexes[j] = indexes[k];
            indexes[k] = temp;
            // Reverse indexes from j+1
            for (i = j + 1; 2 * i <= indexes.length + j; i++) {
                temp = indexes[i];
                indexes[i] = indexes[indexes.length - i + j];
                indexes[indexes.length - i + j] = temp;
            }
            return true;
        }
    }

    public boolean reorderedPowerOf2(int n) {
        if (Integer.bitCount(n) == 1) {
            return true;
        }
        Permute permute = new Permute(String.valueOf(n));
        while (permute.hasNext()) {
            String number = permute.getNext();
            if (!number.startsWith("0")) {
                if (Integer.bitCount(Integer.parseInt(number)) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private String countDigits(int n) {
        int[] histogram = new int[10];
        while (n > 0) {
            histogram[n % 10]++;
            n = Math.floorDiv(n, 10);
        }
        StringBuilder sb = new StringBuilder(10);
        for (int digit : histogram) {
            sb.append(digit);
        }
        return sb.toString();
    }


}
