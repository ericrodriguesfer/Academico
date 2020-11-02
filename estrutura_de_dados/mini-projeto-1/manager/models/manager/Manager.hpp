class Manager {
    private:
        List *list;

    public:
        Manager();
        Manager(unsigned int capacity_list);
    
        void insert (Assignment *assignment);
        bool remove (Assignment *assignment);
        void conclude (unsigned int index_assignment);
        void new_conclude (unsigned int index_assignment);
        Assignment* get_assignment (unsigned int index);
        unsigned int cout_conclude ();
        unsigned int cout_concluded ();
        unsigned int length_list ();
        void print_concluded ();
        void print_conclude ();
        void print_all ();
        void print_up ();
        void print_down ();
        void print_swap ();
        void sort_swap (unsigned int index_first, unsigned int index_second);
        void sort_up (unsigned int index_element, unsigned int total_position);
        void sort_down (unsigned int index_element, unsigned int total_position);
        void sort_creation ();
        void sort_deadline ();
        void sort_id ();

    friend class List;
    friend class Assignment;
};