#include "../assignment/Assignment.hpp"
#include "List.hpp"
#include <cstdlib>
#include <string>
#include <limits>

using namespace std;

List::List () {
    this -> capacity = 5;
    this -> list = new Assignment*[capacity];
    this -> size = 0;
}

List::List (unsigned int capacity) {
    this -> list = new Assignment*[capacity];
    this -> capacity = capacity;
    this -> size = 0;
}

void List::insert (Assignment *assignment) {
    if (this -> size < this -> capacity) {
        this -> list[this -> size] = assignment;
        this -> size++;
    } else {
        this -> list = (Assignment**) realloc (this -> list, sizeof(Assignment) * (this -> capacity * 2));

        if (!list) {
            return;
        } else {
            this -> capacity *= 2;
            this -> list[this -> size] = assignment;
            this -> size++;
        }
    }
}

bool List::remove (Assignment *assignment) {
    if (this -> size == 0) {
        return false;
    }

    if (this -> belongs(assignment)) {
        int index = get_index_for(assignment);

        if (index == std::numeric_limits<unsigned int>::max()) {
            return false;
        } else {
            for (unsigned int i = (index + 1); i < this -> size; i++) {
                this -> list[i - 1] = this -> list[i];
            }

            this -> size--;
            return true;
        }
    } else {
        return false;
    }
}

bool List::belongs (Assignment *assignment) {
    if (this -> size == 0) {
        return false;
    }

    for (unsigned int i = 0; i < this -> size; i++) {
        if (this -> list[i] == assignment) {
            return true;
        }
    }

    return false;
}

Assignment* List::get_element_for (unsigned int index) {
    if (index >= this -> size || this -> size == 0) {
        Assignment *p = new Assignment(std::numeric_limits<int>::max(), "Default description assignment", "99/99/9999", "99/99/9999");
        return p;
    }

    for (unsigned int i = 0; i < this -> size; i++) {
        if (this -> list[i] == this -> list[index]) {
            return this -> list[i];
        }
    }

    Assignment *p = new Assignment(std::numeric_limits<int>::max(), "Default description assignment", "99/99/9999", "99/99/9999");
    return p;
}

unsigned int List::get_index_for (Assignment *assignment) {
    if (this -> size == 0) {
        return std::numeric_limits<unsigned int>::max();
    }

    if (this -> belongs(assignment)) {
        for (unsigned int i = 0; i < this -> size; i++) {
            if (this -> list[i] == assignment) {
                return i;
            }
        }
    }

    return std::numeric_limits<unsigned int>::max();
}

void List::swap_element (unsigned int index_first, unsigned int index_second) {
    Assignment *copy = this -> list[index_first];
    this -> list[index_first] = this -> list[index_second];
    this -> list[index_second] = copy;
}

void List::drag_up_element (unsigned int index_element, unsigned int total_position) {
    Assignment *copy = this -> list[index_element];
    unsigned int per_element = (index_element - total_position);

    while (total_position != 0) {
        this -> list[index_element] = this -> list[index_element - 1];
        index_element--;
        total_position--;
    }

    this -> list[per_element] = copy;
}

void List::drag_down_element (unsigned int index_element, unsigned int total_position) {
    Assignment *copy = this -> list[index_element];
    unsigned int per_element = (index_element + total_position);

    while (total_position != 0) {
        this -> list[index_element] = this -> list[index_element + 1];
        index_element++;
        total_position--;
    }

    this -> list[per_element] = copy;
}

unsigned int List::size_list () {
    return this -> size;
}

unsigned int List::capacity_list () {
    return this -> capacity;
}