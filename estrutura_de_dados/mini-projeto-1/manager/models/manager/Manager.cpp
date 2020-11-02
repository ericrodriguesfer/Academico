#include "../assignment/Assignment.hpp"
#include "../list/List.hpp"
#include "Manager.hpp"
#include <iostream>
#include <string>

using namespace std;

Manager::Manager () {
    this -> list = new List(5);
}

Manager::Manager (unsigned int capacity_list) {
    this -> list = new List(capacity_list);
}

void Manager::insert (Assignment *assignment) {
    this -> list -> insert(assignment);
}

bool Manager::remove (Assignment *assignment) {
    return this -> list -> remove(assignment);
}

void Manager::conclude (unsigned int index_assignment) {
    if (this -> list -> belongs(this -> list -> get_element_for(index_assignment))) {
        if (!this -> list -> get_element_for(index_assignment) -> get_state()) {
            this -> list -> get_element_for(index_assignment) -> set_state(true);
        }
    }
}

void Manager::new_conclude (unsigned int index_assignment) {
    if (this -> list -> belongs(this -> list -> get_element_for(index_assignment))) {
        if (this -> list -> get_element_for(index_assignment) -> get_state()) {
            this -> list -> get_element_for(index_assignment) -> set_state(false);
        }
    }
}

Assignment* Manager::get_assignment (unsigned int index) {
    return this -> list -> get_element_for(index);
}

unsigned int Manager::cout_conclude () {
    unsigned int count = 0;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        if (!this -> list -> get_element_for(i) -> get_state()) {
            count++;
        }
    }

    return count;
}

unsigned int Manager::cout_concluded () {
    unsigned int count = 0;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        if (this -> list -> get_element_for(i) -> get_state()) {
            count++;
        }
    }

    return count;
}

unsigned int Manager::length_list () {
    return this -> list -> size_list();
}

void Manager::print_concluded () {
    cout << "########## Tarefas concluidas ##########" << endl;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        if (this -> list -> get_element_for(i) -> get_state()) {
            cout << "indice: " << (i + 1) << endl;
            this -> list -> get_element_for(i) -> print_status();
            cout << endl;
        }
    }
}

void Manager::print_conclude () {
    cout << "########## Tarefas a concluir ##########" << endl;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        if (!this -> list -> get_element_for(i) -> get_state()) {
            cout << "indice: " << (i + 1) << endl;
            this -> list -> get_element_for(i) -> print_status();
            cout << endl;
        }
    }
}

void Manager::print_all () {
    cout << "########## Todas as tarefas ##########" << endl;
    
    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        cout << "indice: " << (i + 1) << endl;
        this -> list -> get_element_for(i) -> print_status();
        cout << endl;
    }
}   

void Manager::print_up () {
    cout << "########## Todas a ordernar para cima ##########" << endl;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        cout << "indice: " << (i + 1) << endl;
        this -> list -> get_element_for(i) -> print_status();
        cout << ">> Pode subir ate: " << (i) << " posicoes" << endl;
        cout << endl;
    }
}

void Manager::print_down () {
    cout << "########## Todas a ordernar para baixo ##########" << endl;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        cout << "indice: " << (i + 1) << endl;
        this -> list -> get_element_for(i) -> print_status();
        cout << ">> Pode descer ate: " << (this -> list -> size_list() - i - 1) << " posicoes" << endl;
        cout << endl;
    }
}

void Manager::print_swap () {
    cout << "########## Todas as tarefas trocar de posicao ##########" << endl;

    for (unsigned int i = 0; i < this -> list -> size_list(); i++) {
        cout << "indice: " << (i + 1) << endl;
        this -> list -> get_element_for(i) -> print_status();
        cout << endl;
    }
}

void Manager::sort_swap (unsigned int index_first, unsigned int index_second) {
    this -> list -> swap_element(index_first, index_second);
}

void Manager::sort_up (unsigned int index_element, unsigned int total_position) {
    this -> list -> drag_up_element(index_element, total_position);
}

void Manager::sort_down (unsigned int index_element, unsigned int total_position) {
    this -> list -> drag_down_element(index_element, total_position);
}

void Manager::sort_creation () {
    int interval = this -> list -> size_list();
    unsigned int copied = 1;

    while (interval > 1 || copied == 1) {
        interval = (interval * 10) / 13;

        if (interval == 9 || interval == 10) {
            interval = 11;
        }

        if (interval < 1) {
            interval = 1;
        }

        copied = 0;

        for (unsigned int i = 0, j = interval; j < this -> list -> size_list(); i++, j++) {
            int position_one, position_two;
            string date_one = this -> list -> get_element_for(i) -> get_creation();
            string date_two = this -> list -> get_element_for(j) -> get_creation();

            position_one = date_one.find("/", 0);
            position_two = date_two.find("/", 0);

            if ((date_one.substr(0, position_one)) > (date_two.substr(0, position_two))) {
                this -> list -> swap_element(i, j);
                
                copied = 1;
            }

        }
    }
}
void Manager::sort_deadline () {
    int interval = this -> list -> size_list();
    unsigned int copied = 1;

    while (interval > 1 || copied == 1) {
        interval = (interval * 10) / 13;

        if (interval == 9 || interval == 10) {
            interval = 11;
        }

        if (interval < 1) {
            interval = 1;
        }

        copied = 0;

        for (unsigned int i = 0, j = interval; j < this -> list -> size_list(); i++, j++) {
            int position_one, position_two;
            string date_one = this -> list -> get_element_for(i) -> get_deadline();
            string date_two = this -> list -> get_element_for(j) -> get_deadline();

            position_one = date_one.find("/", 0);
            position_two = date_two.find("/", 0);

            if ((date_one.substr(0, position_one)) > (date_two.substr(0, position_two))) {
                this -> list -> swap_element(i, j);

                copied = 1;
            }
        }
    }
}

void Manager::sort_id () {
    int interval = this -> list -> size_list();
    unsigned int copied = 1;

    while (interval > 1 || copied == 1) {
        interval = (interval * 10) / 13;

        if (interval == 9 || interval == 10) {
            interval = 11;
        }

        if (interval < 1) {
            interval = 1;
        }

        copied = 0;

        for (unsigned int i = 0, j = interval; j < this -> list -> size_list(); i++, j++) {
            if (this -> list -> get_element_for(i) -> get_id() > this -> list -> get_element_for(j) -> get_id()) {
                this -> list -> swap_element(i, j);

                copied = 1;
            }
        }
    }
}