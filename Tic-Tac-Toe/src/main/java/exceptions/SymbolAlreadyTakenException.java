package exceptions;

import lombok.Getter;

@Getter
public class SymbolAlreadyTakenException extends RuntimeException {
    public SymbolAlreadyTakenException(String message) {
        super(message);
    }
}
