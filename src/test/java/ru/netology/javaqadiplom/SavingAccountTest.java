package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldSaveWhenMinBalanceMoreThan0() {
        SavingAccount account = new SavingAccount(
                3_000,
                2_000,
                7_000,
                4
        );

        Assertions.assertEquals(2_000, account.getMinBalance());
    }

    @Test
    public void shouldSaveWhenMinBalanceEqual0() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                5_000,
                3
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void shouldSaveWhenMinBalanceLessThan0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    -1_000,
                    6_000,
                    2
            );
        });
    }

    @Test
    public void shouldSaveWhenMaxBalanceMoreThan0() {
        SavingAccount account = new SavingAccount(
                2_500,
                2_000,
                11_000,
                7
        );

        Assertions.assertEquals(11_000, account.getMaxBalance());
    }

    @Test
    public void shouldSaveWhenMaxBalanceEqual0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_300,
                    1_000,
                    0,
                    5
            );
        });
    }

    @Test
    public void shouldSaveWhenMaxBalanceLessThan0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_700,
                    2_200,
                    -2_000,
                    8
            );
        });
    }

    @Test
    public void shouldSaveWhenMinBalanceMoreThanMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    8_100,
                    7_000,
                    3_000,
                    1
            );
        });
    }

    @Test
    public void shouldSaveWhenMinBalanceEqualMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    4_300,
                    3_600,
                    3_600,
                    9
            );
        });
    }

    @Test
    public void shouldSaveWhenInitialBalanceMoreThanMinAndLessThanMax() {
        SavingAccount account = new SavingAccount(
                6_500,
                2_000,
                8_000,
                12
        );

        Assertions.assertEquals(6_500, account.getBalance());
    }

    @Test
    public void shouldSaveWhenInitialBalanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                1_400,
                1_400,
                5_500,
                14
        );

        Assertions.assertEquals(1_400, account.getBalance());
    }

    @Test
    public void shouldSaveWhenInitialBalanceEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                5_800,
                1_400,
                5_800,
                16
        );

        Assertions.assertEquals(5_800, account.getBalance());
    }

    @Test
    public void shouldSaveWhenInitialBalanceLessThan0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -1_000,
                    2_000,
                    5_000,
                    11
            );
        });
    }

    @Test
    public void shouldSaveWhenInitialBalanceLessThanMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    500,
                    3_000,
                    8_000,
                    15
            );
        });
    }

    @Test
    public void shouldSaveWhenInitialBalanceMoreThanMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    9_400,
                    1_200,
                    8_100,
                    18
            );
        });
    }

    @Test
    public void shouldSaveWhenRateMoreThan0AndLessThan100() {
        SavingAccount account = new SavingAccount(
                5_000,
                3_000,
                12_000,
                46
        );

        Assertions.assertEquals(46, account.getRate());
    }

    @Test
    public void shouldSaveWhenRateMoreThan100() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    3_000,
                    12_000,
                    130
            );
        });
    }

    @Test
    public void shouldSaveWhenRateLessThan0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    3_000,
                    12_000,
                    -20
            );
        });
    }

    @Test
    public void shouldSaveWhenRateEqualLimitValue() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    3_000,
                    12_000,
                    -1
            );
        });
    }

    @Test
    public void shouldSaveWhenRateEqualLimitValue0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    3_000,
                    12_000,
                    0
            );
        });
    }

    @Test
    public void shouldSaveWhenRateEqualLimitValue1() {
        SavingAccount account = new SavingAccount(
                5_000,
                3_000,
                12_000,
                1
        );

        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void shouldSaveRateEqualLimitValue99() {
        SavingAccount account = new SavingAccount(
                5_000,
                3_000,
                12_000,
                99
        );

        Assertions.assertEquals(99, account.getRate());
    }

    @Test
    public void shouldSaveRateEqualLimitValue100() {
        SavingAccount account = new SavingAccount(
                5_000,
                3_000,
                12_000,
                100
        );

        Assertions.assertEquals(100, account.getRate());
    }

    @Test
    public void shouldSaveWhenRateEqualLimitValue101() {
        SavingAccount account = new SavingAccount(
                5_000,
                3_000,
                12_000,
                101
        );

        Assertions.assertEquals(101, account.getRate());
    }

    @Test
    public void shouldPayWhenAmountEqual0() {
        SavingAccount account = new SavingAccount(
                5_900,
                2_300,
                6_600,
                24
        );

        account.pay(0);

        Assertions.assertEquals(5_900, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountLessThan0() {
        SavingAccount account = new SavingAccount(
                3_400,
                1_200,
                7_000,
                17
        );

        account.pay(-100);

        Assertions.assertEquals(3_400, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceBecomesMoreThanMinBalance() {
        SavingAccount account = new SavingAccount(
                1_900,
                500,
                3_800,
                30
        );

        account.pay(900);

        Assertions.assertEquals(1_900 - 900, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceBecomesLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                800,
                300,
                5_200,
                28
        );

        account.pay(600);

        Assertions.assertEquals(800, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceBecomesEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                900,
                200,
                5_000,
                26
        );

        account.pay(700);

        Assertions.assertEquals(900 - 700, account.getBalance());
    }

    @Test
    public void shouldAddWhenAmountEqual0() {
        SavingAccount account = new SavingAccount(
                4_300,
                500,
                13_000,
                20
        );

        account.add(0);

        Assertions.assertEquals(4_300 , account.getBalance());
    }

    @Test
    public void shouldAddWhenAmountLessThan0() {
        SavingAccount account = new SavingAccount(
                5_100,
                2_600,
                12_000,
                19
        );

        account.add(-1_000);

        Assertions.assertEquals(5_100, account.getBalance());
    }

    @Test
    public void shouldAddWhenBalanceBecomesLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                600,
                7_800,
                14
        );

        account.add(2_000);

        Assertions.assertEquals(1_500 + 2_000, account.getBalance());
    }

    @Test
    public void shouldAddWhenBalanceBecomesMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_500,
                6_000,
                22
        );

        account.add(7_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddWhenBalanceBecomesEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                4_000,
                1_000,
                7_000,
                29
        );

        account.add(3_000);

        Assertions.assertEquals(4_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(
                3_505,
                1_000,
                8_000,
                25
        );

        Assertions.assertEquals(876, account.yearChange());
    }
}
