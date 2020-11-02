#include "Assignment.hpp"
#include <iostream>
#include <string>
#include <limits>

using namespace std;

Assignment::Assignment () {
    this -> id = std::numeric_limits<int>::max();
    this -> description = "Default description assignment";
    this -> state = false;
    this -> creation = "99/99/9999";
    this -> deadline = "99/99/9999";
}  

Assignment::Assignment (int id, string description, string creation, string deadline) {
    this -> id = id;
    this -> description = description;
    this -> state = false;
    this -> creation = creation;
    this -> deadline = deadline;
}

void Assignment::set_id (int id) {
    this -> id = id;
}

int Assignment::get_id () {
    return this -> id;
}

void Assignment::set_description (string description) {
    this -> description = description;
}

string Assignment::get_description () {
    return this -> description;
}

void Assignment::set_state (bool state) {
    this -> state = state;
}

bool Assignment::get_state () {
    return this -> state;
}

void Assignment::set_creation (string creation) {
    this -> creation = creation;
}

string Assignment::get_creation () {
    return this -> creation;
}

void Assignment::set_deadline (string deadline) {
    this -> deadline = deadline;
}

string Assignment::get_deadline () {
    return this -> deadline;
}

void Assignment::print_status () {
    cout << "A fazer: " << this -> get_description() << endl;
    cout << "Tarefa: " << (this -> get_state() == true ? "Concluido(a)" : "Nao concluido(a)") << endl;
    cout << "Prazo: " << this -> get_deadline() << endl;
}

void Assignment::to_string () {
    cout << "Meu ID: " << this -> get_id() << endl;
    cout << "Minha descricacao: " << this -> get_description() << endl;
    cout << "Meu estado: " << this -> get_state() << endl;
    cout << "Minha criacao: " << this -> get_creation() << endl;
    cout << "Meu prazo: " << this -> get_deadline() << endl;
}