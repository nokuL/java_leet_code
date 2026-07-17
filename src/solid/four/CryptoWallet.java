package solid.four;

import java.util.UUID;

public class CryptoWallet {
    public String send(String address, double amount) {
        System.out.println("Sending crypto to " + address + " amount " + amount);
        return "0x" + UUID.randomUUID().toString().replace("-", "");
    }
}