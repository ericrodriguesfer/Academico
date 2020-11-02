#include "Digit.hpp"

Digit::Digit (int digit, Digit* next = nullptr) {
    this -> digit = digit;
    this -> next = next;
}

void Digit::set_digit (int digit) {
    this -> digit = digit;
}

int Digit::get_digit () {
    return this-> digit;
}

void Digit::set_next (Digit* next) {
    this -> next = next;
}

Digit* Digit::get_next () {
    return this -> next;
}