#include "Number.hpp"
#include <iostream>
#include <limits>

using namespace std;

Number::Number () {
    this -> first = nullptr;
    this -> length = 0;
}

Number::Number (unsigned int length, int value) {
    this -> first = nullptr;
    this -> length = length;

    for (unsigned int i = 0; i < this -> length; i++) {
        Digit* new_digit = new Digit(value, this -> first);
        this -> first = new_digit;
    }
}

void Number::insert (int digit) {
    Digit* new_digit = new Digit(digit, this -> first);
    this -> first = new_digit;
    this -> length++;
}

void Number::insert_end (int digit) {
    if (this -> length == 0) {
        Digit* new_digit = new Digit(digit, this -> first);
        this -> first = new_digit;
        this -> length++;
    } else {
        Digit* new_digit = new Digit(digit, nullptr);
        Digit* previous_digit = this -> get_number(this -> length - 1);
        previous_digit -> set_next(new_digit);
        this -> length++;
    }
}

void Number::print () {
    int* print_number = new int[this -> length];

    for (unsigned int i = 0; i < this -> length; i++) {
        print_number[i] = this -> get_value_digit(i);
    }

    for (int i = (this -> length - 1); i > -1; i--) {
        cout << print_number[i];
    }

    cout << endl;

    delete[] print_number;
}

Digit* Number::get_number (unsigned int index) {
    if (this -> length == 0) {
        return nullptr;
    }

    unsigned int index_search = 0;
    Digit* digit = this -> first;

    while (digit != nullptr) {
        if (index_search == index) {
            return digit;
        }

        index_search++;
        digit = digit -> get_next();
    }

    return nullptr;
}

int Number::get_value_digit (unsigned int index) {
    if (this -> length == 0) {
        return std::numeric_limits<int>::max();
    }

    unsigned int index_search = 0;
    Digit* digit = this -> first;

    while (digit != nullptr) {
        if (index_search == index) {
            return digit -> get_digit();
        }

        index_search++;
        digit = digit -> get_next();
    }

    return std::numeric_limits<int>::max();
}

void Number::equals_number (int grow_up) {
    while (grow_up-- > 0) {
        this -> insert_end(0);
    }
}

void Number::clear () {
    if (this -> length == 0) {
        return;
    }

    this -> first = nullptr;
    this -> length = 0;
}

void Number::reverse () {
    if (this -> length == 0) {
        return;
    }

    unsigned int start = 0;
    unsigned int end = (this -> length - 1);

    while (start < end) {
        int copy = this -> get_value_digit(start);
        this -> get_number(start) -> set_digit(this -> get_value_digit(end));
        this -> get_number(end) -> set_digit(copy);

        start++;
        end--;
    }
}

void Number::print_teste () {
    if (this -> length == 0) {
        return;
    }

    for (unsigned int i = 0; i < this -> length; i++) {
        cout << this -> get_value_digit(i);
    }

    cout << endl;
}

unsigned int Number::size () {
    return this -> length;
}