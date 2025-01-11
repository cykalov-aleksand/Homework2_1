package org.skypro.skyshop;

public class ConsolPrint {
           final private int numberPosition;

        public ConsolPrint() {
            this.numberPosition = 100;
        }

        public ConsolPrint(int numberPosition) {
            this.numberPosition = numberPosition;
        }

        void printTitle(String title) {
            int headerLength = title.length();
            int numberOfCharacters = (numberPosition - headerLength) / 2;
            String completion = "-";
            System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
        }

        void printLine(String stroka) {
            StringBuffer str = new StringBuffer(stroka);
            System.out.println();
            for (int i = 0; i <= numberPosition; i++) {
                System.out.print("-");
            }
            String whitespace = " ";
            int countingRow = 0;
            String sss = " ";
            str.insert(0, sss.repeat(5) + str.substring(0, 1).toUpperCase());
            str.delete(6, 7);
            str.insert(0, (whitespace.repeat(5)));
            if (numberPosition < str.length()) {
                countingRow += str.lastIndexOf(" ", countingRow + numberPosition);
                while (countingRow < str.length()) {
                    str.insert(countingRow, "\n");
                    countingRow += str.lastIndexOf(" ", countingRow + numberPosition);
                }
            }
            System.out.println("\n" + str);
            System.out.println();
        }
    void printLine(int x,String stroka) {
        StringBuffer str = new StringBuffer(stroka);
        String whitespace = " ";
        int countingRow = 0;
        String sss = " ";
        str.substring(0, 3);
        str.insert(0, sss.repeat(5) + str.substring(0, 1).toUpperCase());
        str.delete(6, 7);
        str.insert(0, (whitespace.repeat(5)));
        if (numberPosition < str.length()) {
            countingRow += str.lastIndexOf(" ", countingRow + numberPosition);
            while (countingRow < str.length()) {
                str.insert(countingRow, "\n");
                countingRow += str.lastIndexOf(" ", countingRow + numberPosition);
            }
        }
        System.out.println("\n" + str);
        System.out.println();
    }

    }

