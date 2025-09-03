package org.ticketBooking.util;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public class Hash {
    BcryptFunction bcrypt= BcryptFunction.getInstance(Bcrypt.B, 12);
    public String hashPassword(String password){
        com.password4j.Hash hash = Password.hash(password).addPepper("Secret-Key").with(bcrypt);
        return hash.getResult();
    }
    public boolean checkPassword(String password, String hashedPassword){
        boolean passwordMatch = Password
                .check(password, hashedPassword)
                .addPepper("Secret-Key")
                .with(bcrypt);
        return passwordMatch;
    }
}
