class Digit {
    private:
        int digit;
        Digit* next;

    public:
        Digit (int digit, Digit* next);

        void set_digit (int digit);
        int get_digit ();
        void set_next (Digit* next);
        Digit* get_next ();
};