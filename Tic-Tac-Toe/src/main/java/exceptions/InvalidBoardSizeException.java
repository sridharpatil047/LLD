package exceptions;

import lombok.Getter;

@Getter
public class InvalidBoardSizeException extends RuntimeException{
    public InvalidBoardSizeException(String message) {
        super(message);
    }
}
