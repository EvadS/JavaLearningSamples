package com.rest.samples.helpers;

import com.soapbox.basenode.consensus.accounts.Account;
import com.soapbox.basenode.consensus.accounts.AccountManager;
import com.soapbox.basenode.consensus.accounts.AccountManagerImpl;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class AccountHelper {

    public static final String TEST_REWARD_POOL_ACCOUNT_JSON = "testRewardPoolAccount.json";
    public static final String TEST_REWARD_POOL_ACCOUNT_PASS = "only for tests";
    public static final String DEFAULT_ACCOUNT_JSON = "accounts/defaultAccount.json";
    public static final String DEFAULT_PASS = "123456";

    private static AccountManager accountManager;

    static {
        accountManager = Mockito.mock(AccountManagerImpl.class);
        try {
            Mockito.when(accountManager.importAccount(Mockito.any(Path.class))).thenCallRealMethod();
        } catch (IOException | Account.ParseException e) {
            e.printStackTrace();
        }
    }

    private AccountHelper() {
    }

    public static Account getRewardPoolAccount() {
        try {
            return accountManager.importAccount(Paths.get(Objects.requireNonNull(AccountHelper.class.getClassLoader()
                    .getResource(TEST_REWARD_POOL_ACCOUNT_JSON)).getPath()));
        } catch (IOException | Account.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Account getDefaultAccount() {
        try {
            return accountManager.importAccount(PathsHelper.getPath(DEFAULT_ACCOUNT_JSON));
        } catch (IOException | Account.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Account getAccount(String accountName) {
        try {
            return accountManager.importAccount(Paths.get(Objects.requireNonNull(AccountHelper.class.getClassLoader()
                    .getResource("accounts/" + accountName + ".json")).getPath()));
        } catch (IOException | Account.ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
