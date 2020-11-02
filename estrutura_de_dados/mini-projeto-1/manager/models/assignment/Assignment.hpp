#include <string>

using namespace std;

class Assignment {
    private:
        int id;
        string description;
        bool state;
        string creation;
        string deadline;

    public:
        Assignment ();
        Assignment (int id, string description, string creation, string deadline);

        void set_id (int id);
        int get_id ();
        void set_description (string description);
        string get_description ();
        void set_state (bool state);
        bool get_state ();
        void set_creation (string creation);
        string get_creation ();
        void set_deadline (string deadline);
        string get_deadline ();
        void print_status();
        void to_string ();
};