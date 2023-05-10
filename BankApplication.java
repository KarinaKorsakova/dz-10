import exceprions.WrongAccountException;
import exceprions.WrongCurrencyException;
import exceprions.WrongOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankApplication {

    private final List<Account> accounts = new ArrayList<>() {{
        add(new Account("accountId000", 50, "USD"));
        add(new Account("accountId003", 250, "HRV"));
        add(new Account("accountId001", 50, "EUR"));
        add(new Account("accountId001", 50, "USD"));
    }};


    public void process(String accountId, int amount, String currency) throws Exception {

        accounts.stream().filter(account -> account.getId().equals(accountId))
                .findAny().orElseThrow(WrongAccountException::new);

        accounts.stream().filter(account -> account.getId().equals(accountId))
                .filter(account -> account.getCurrency().equals(currency))
                .findAny().orElseThrow(WrongCurrencyException::new);

        accounts.stream().filter(account -> account.getId().equals(accountId))
                .filter(account -> account.getCurrency().equals(currency))
                .filter(account -> account.getAmount() >= amount)
                .findAny().orElseThrow(WrongOperationException::new);


        Account desiredAccount = accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .filter(account -> account.getCurrency().equals(currency))
                .filter(account -> account.getAmount() >= amount).findAny()
                .orElseThrow();

        int randomInt = new Random().nextInt(2);

       if(randomInt == 1){
           throw new Exception();
       }

        desiredAccount.setAmount()(desiredAccount.getAmount()() - amount);
    }
}
