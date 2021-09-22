package com.gl.algorithm.processStockInfo;

import java.util.Arrays;
import java.util.Scanner;

public class ProcessStockInfo {
    double[] stocksPrice;
    boolean[] stocksPriceRaised;
    int numberOfStocksRose;
    int numberOfStocksDeclined;
    boolean stockPriceRose;

    public void getInputFromUserAndCompute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the no of companies");
            int numberOfCompanies = scanner.nextInt();
            stocksPrice = new double[numberOfCompanies];
            stocksPriceRaised = new boolean[numberOfCompanies];

            for (int count = 1; count <= numberOfCompanies; ++count) {
                System.out.println("Enter current stock price of the company " + count);
                stocksPrice[count - 1] = scanner.nextDouble();
                System.out.println("Whether company's stock price rose today compare to yesterday?");
                stockPriceRose = scanner.nextBoolean();
                stocksPriceRaised[count - 1] = stockPriceRose;

                if (stockPriceRose)
                    ++numberOfStocksRose;
                else
                    ++numberOfStocksDeclined;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        performOperation();

    }

    private void performOperation() {
        Scanner scanner = new Scanner(System.in);
        try {

            int numberOfInvalidAttempts = 0;
            int option = 1;

            while (option != 6) {
                System.out.println("\n\n------------------------------");
                System.out.println("Enter the operation that you want to perform\n" +
                        "1. Display the companies stock prices in ascending order\n" +
                        "2. Display the companies stock prices in descending order\n" +
                        "3. Display the total no of companies for which stock prices rose today\n" +
                        "4. Display the total no of companies for which stock prices declined today\n" +
                        "5. Search a specific stock price\n" +
                        "6. press 0 to exit\n" +
                        "------------------------------");

                option = scanner.nextInt();
                if (option < 1 || option > 6) {
                    ++numberOfInvalidAttempts;
                    if (numberOfInvalidAttempts == 3) {
                        System.out.println("\nEntered invalid option 3 times, exiting, Bye!!");
                        System.exit(0);
                    }

                    System.out.println("\nInvalid option, please enter valid option\n");
                    continue;
                }

                switch (option) {
                    case 1:
                        System.out.println(Arrays.toString(new MergeSort(stocksPrice).sort(true)));
                        break;
                    case 2:
                        System.out.println(Arrays.toString(new MergeSort(stocksPrice).sort(false)));
                        break;
                    case 3:
                        System.out.println(numberOfStocksRose);
                        break;
                    case 4:
                        System.out.println(numberOfStocksDeclined);
                        break;
                    case 5:
                        new BinarySearch();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
