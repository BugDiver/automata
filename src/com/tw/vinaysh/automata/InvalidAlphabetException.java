package com.tw.vinaysh.automata;

class InvalidAlphabetException extends Exception {
    InvalidAlphabetException(String input) {
        super(String.format("provided alphabet %s is not valid!",input));
    }
}
