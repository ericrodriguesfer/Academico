#include "../digit/Digit.hpp"

class Number{
    private:
        Digit* first;
        unsigned int length;

    public:
        Number ();
        Number (unsigned int length, int value);

        void insert (int digit);
        void insert_end (int digit);
        void print ();
        Digit* get_number (unsigned int index);
        int get_value_digit (unsigned int index);
        void equals_number (int grow_up);
        void clear ();
        void reverse ();
        void print_teste ();

        unsigned int size ();
};