class List {
    private:
        unsigned int size;
        unsigned int capacity;
        Assignment **list;

    public:
        List();
        List(unsigned int capacity);

        void insert (Assignment *assignment);
        bool remove (Assignment *assignment);
        bool belongs (Assignment *assignment);
        Assignment* get_element_for (unsigned int index);
        unsigned int get_index_for (Assignment *assignment);
        void swap_element (unsigned int index_first, unsigned int index_second);
        void drag_up_element (unsigned int index_element, unsigned int total_position);
        void drag_down_element (unsigned int index_element, unsigned int total_position);
        unsigned int size_list ();
        unsigned int capacity_list ();

    friend class Assignment;
};