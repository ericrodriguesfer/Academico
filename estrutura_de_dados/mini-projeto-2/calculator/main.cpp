#include "models/number/Number.hpp"
#include <iostream>

using namespace std;

int main() {
    Number number_one;
    Number number_two;
    Number result;
    Number memory;
    bool menu = true;
    char choose_menu;

    while (menu) {
        cout << endl;
        cout << "(=) Ler" << endl;
        cout << "(?) Exibir" << endl;
        cout << "(#) Limpar R" << endl;
        cout << "(@) Limpar O" << endl;
        cout << "(+) Somar" << endl;
        cout << "(-) Subtrair" << endl;
        cout << "(*) Multiplicar" << endl;
        cout << "(m) Memoria" << endl;
        cout << "Digite a operacao que deseja realizar: " << endl;
        cin >> choose_menu;
        cout << endl;

        switch (choose_menu) {
            case '=': {
                number_one.clear();
                number_two.clear();

                int total_digits;
                int digit;
                cout << "Digite a quantidade de digitos do primeiro numero: " << endl;
                cin >> total_digits;

                cout << "Digite digito a digito o primeiro numero: " << endl;
                while (total_digits-- > 0) {
                    cin >> digit;

                    number_one.insert(digit);
                }

                cout << "Digite a quantidade de digitos do segundo numero: " << endl;
                cin >> total_digits;

                cout << "Digite digito a digito o segundo numero: " << endl;
                while (total_digits-- > 0) {
                    cin >> digit;

                    number_two.insert(digit);
                }

                break;
            }

            case '?': {
                char choose_display;

                cout << "(r) Resultado" << endl;
                cout << "(1) Operando 1" << endl;
                cout << "(2) Operando 2" << endl;
                cout << "Digite a operacao que deseja realizar: " << endl;
                cin >> choose_display;
                cout << endl;

                switch (choose_display) {
                    case 'r': {
                        if (result.size() == 0) {
                            cout << "Resultado: 0" << endl;
                        } else {
                            cout << "Resultado: ";
                            result.print();
                        }

                        break;
                    }

                    case '1': {
                        if (number_one.size() == 0) {
                            cout << "Operanado 1: 0" << endl;
                        } else {
                            cout << "Operanado 1: ";
                            number_one.print();
                        }

                        break;
                    }

                    case '2': {
                        if (number_two.size() == 0) {
                            cout << "Operanado 2: 0" << endl;
                        } else {
                            cout << "Operanado 2: ";
                            number_two.print();
                        }

                        break;
                    }
                }

                break;
            }

            case '#': {
                if (result.size() == 0) {
                    cout << "ERRO: Resultado nao possui valor!" << endl;
                } else {
                    cout << "ESTE PROCESSO PODE DEMORAR UM POUCO!" << endl;

                    result.clear();

                    cout << "RESULTADO LIMPO COM SUCESSO!" << endl;
                }

                break;
            }

            case '@': {
                char choose_clear;

                cout << "(1) Operando 1" << endl;
                cout << "(2) Operando 2" << endl;
                cout << "(.) Ambos" << endl;
                cout << "Digite a operacao que deseja realizar: " << endl;
                cin >> choose_clear;
                cout << endl;

                switch (choose_clear) {
                    case '1': {
                        if (number_one.size() == 0) {
                            cout << "ERRO: Operando 1 nao possui valor!" << endl;
                        } else {
                            cout << "ESTE PROCESSO PODE DEMORAR UM POUCO!" << endl;

                            number_one.clear();

                            cout << "OPERANDO 1 LIMPO COM SUCESSO!" << endl;
                        }

                        break;
                    }

                    case '2': {
                        if (number_two.size() == 0) {
                            cout << "ERRO: Operando 2 nao possui valor!" << endl;
                        } else {
                            cout << "ESTE PROCESSO PODE DEMORAR UM POUCO!" << endl;

                            number_two.clear();

                            cout << "OPERANDO 2 LIMPO COM SUCESSO!" << endl;
                        }

                        break;
                    }

                    case '.': {
                        if (number_one.size() == 0 || number_two.size() == 0) {
                            cout << "ERRO: Os operandos nao possuem valor!" << endl;
                        } else {
                            cout << "ESTE PROCESSO PODE DEMORAR UM POUCO!" << endl;

                            number_one.clear();
                            number_two.clear();

                            cout << "OPERANDOS LIMPOS COM SUCESSO!" << endl;
                        }

                        break;
                    }
                }

                break;
            }

            case '+': {
                result.clear();
                char choose_option;

                cout << "(m) Memoria" << endl;
                cout << "(o) Operandos" << endl;
                cout << "Digite a operacao que deseja realizar: " << endl;
                cin >> choose_option;
                cout << endl;

                switch (choose_option) {
                    case 'm': {
                        char choose_copy_memory;

                        cout << "(1) Operando 1" << endl;
                        cout << "(2) Operando 2" << endl;
                        cout << "(.) Ambos" << endl;
                        cout << "Digite a operacao que deseja realizar: " << endl;
                        cin >> choose_copy_memory;

                        switch (choose_copy_memory) {
                            case '1': {
                                if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_one.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_one.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }

                            case '2': {
                                 if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_two.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_two.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }

                            case '.': {
                                 if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_one.clear();
                                    number_two.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_one.insert(memory.get_value_digit(i));
                                        number_two.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }
                        }

                        break;
                    }

                    case 'o': {
                        break;
                    }

                    default: {
                        cout << "A operacao sera realizada com o valor atual dos operandos!" << endl;

                        break;
                    }
                }

                if (number_one.size() == 0 || number_two.size() == 0) {
                    cout << "ERRO: Adicione os operandos para realizar uma soma!" << endl;
                } else {
                    if (number_one.size() > number_two.size()) {
                        int grow_up_two = (number_one.size() - number_two.size());
                        number_two.equals_number(grow_up_two);
                    } else {
                        int grow_up_one = (number_two.size() - number_one.size());
                        number_one.equals_number(grow_up_one);
                    }

                    int go_up = 0;

                    for (unsigned int i = 0; i < number_one.size(); i++) {
                        int sum = (number_one.get_value_digit(i) + number_two.get_value_digit(i));

                        if (sum < 10) {
                            if ((sum + go_up) < 10) {
                                result.insert((sum + go_up));
                                go_up = 0;
                            } else {
                                sum = sum + go_up;
                                result.insert(sum % 10);
                                go_up = sum % 10;
                            }
                        } else {
                            sum = sum + go_up;
                            result.insert((sum % 10));
                            go_up = sum / 10;
                        }
                    }

                    if (go_up > 0) {
                        if (go_up < 10) {
                            result.insert(go_up);
                        } else {
                            while (go_up != 0) {
                                result.insert((go_up % 10));
                                go_up = go_up / 10;
                            }
                        }
                    }

                    result.reverse();

                    cout << "SOMA REALIZADA!" << endl;
                }

                break;
            }

            case '-': {
                result.clear();
                char choose_option;

                cout << "(m) Memoria" << endl;
                cout << "(o) Operandos" << endl;
                cout << "Digite a operacao que deseja realizar: " << endl;
                cin >> choose_option;
                cout << endl;

                switch (choose_option) {
                    case 'm': {
                        char choose_copy_memory;

                        cout << "(1) Operando 1" << endl;
                        cout << "(2) Operando 2" << endl;
                        cout << "(.) Ambos" << endl;
                        cout << "Digite a operacao que deseja realizar: " << endl;
                        cin >> choose_copy_memory;

                        switch (choose_copy_memory) {
                            case '1': {
                                if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_one.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_one.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }

                            case '2': {
                                 if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_two.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_two.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }

                            case '.': {
                                 if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_one.clear();
                                    number_two.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_one.insert(memory.get_value_digit(i));
                                        number_two.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }
                        }

                        break;
                    }

                    case 'o': {
                        break;
                    }

                    default: {
                        cout << "A operacao sera realizada com o valor atual dos operandos!" << endl;

                        break;
                    }
                }

                if (number_one.size() == 0 || number_two.size() == 0) {
                    cout << "ERRO: Adicione os operandos para realizar uma soma!" << endl;
                } else {
                    if (number_one.size() > number_two.size()) {
                        int grow_up_two = (number_one.size() - number_two.size());
                        number_two.equals_number(grow_up_two);
                    } else {
                        int grow_up_one = (number_two.size() - number_one.size());
                        number_one.equals_number(grow_up_one);
                    }

                    int number_one_check = 0;
                    int number_two_check = 0;

                    for (int i = (number_one.size() - 1); i > -1 ; i--) {
                        number_one_check = (number_one_check * 10) + number_one.get_value_digit(i);
                        number_two_check = (number_two_check * 10) + number_two.get_value_digit(i);
                    }

                    if (number_two_check > number_one_check) {
                        cout << "ERRO: Essa subtracao ira gerar um resultado negativo!" << endl;
                        cout << "ALERTA: Ainda nao conseguimos tratar esse tipo de operacao!" << endl;
                    } else {
                        for (unsigned int i = 0; i < number_one.size(); i++) {
                            if (number_two.get_value_digit(i) > number_one.get_value_digit(i)) {
                                number_one.get_number(i + 1) -> set_digit(number_one.get_value_digit(i + 1) - 1);
                                number_one.get_number(i) -> set_digit(number_one.get_value_digit(i) + 10);
                            }

                            int subtraction = (number_one.get_value_digit(i) - number_two.get_value_digit(i));
                            result.insert(subtraction);
                        }

                        result.reverse();

                        cout << "SUBTRACAO REALIZADA!" << endl;
                    }
                }

                break;
            }

            case '*': {
                result.clear();
                char choose_option;

                cout << "(m) Memoria" << endl;
                cout << "(o) Operandos" << endl;
                cout << "Digite a operacao que deseja realizar: " << endl;
                cin >> choose_option;
                cout << endl;

                switch (choose_option) {
                    case 'm': {
                        char choose_copy_memory;

                        cout << "(1) Operando 1" << endl;
                        cout << "(2) Operando 2" << endl;
                        cout << "(.) Ambos" << endl;
                        cout << "Digite a operacao que deseja realizar: " << endl;
                        cin >> choose_copy_memory;

                        switch (choose_copy_memory) {
                            case '1': {
                                if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_one.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_one.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }

                            case '2': {
                                 if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_two.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_two.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }

                            case '.': {
                                 if (memory.size() == 0) {
                                    cout << "ERRO: Nao ha valor em momoria!" << endl;

                                    break;
                                } else {
                                    number_one.clear();
                                    number_two.clear();
                                    
                                    for (int i = (memory.size() - 1); i > -1; i--) {
                                        number_one.insert(memory.get_value_digit(i));
                                        number_two.insert(memory.get_value_digit(i));
                                    }
                                }

                                break;
                            }
                        }

                        break;
                    }

                    case 'o': {
                        break;
                    }

                    default: {
                        cout << "A operacao sera realizada com o valor atual dos operandos!" << endl;

                        break;
                    }
                }

                if (number_one.size() == 0 || number_two.size() == 0) {
                    cout << "ERRO: Adicione os operandos para realizar uma soma!" << endl;
                } else {
                    if (number_one.size() > number_two.size()) {
                        int grow_up_two = (number_one.size() - number_two.size());
                        number_two.equals_number(grow_up_two);
                    } else {
                        int grow_up_one = (number_two.size() - number_one.size());
                        number_one.equals_number(grow_up_one);
                    }

                    Number multiply[number_one.size()];
                    int go_up = 0;
                    unsigned int index_choose;

                    for (unsigned int j = 0; j < number_two.size(); j++) {
                        for (unsigned int i = 0; i < number_one.size(); i++) {
                            int multiplication = (number_one.get_value_digit(i) * number_two.get_value_digit(j));

                            if (multiplication < 10) {
                                if ((multiplication + go_up) < 10) {
                                    multiply[j].insert((multiplication + go_up));
                                    go_up = 0;
                                } else {
                                    multiplication = multiplication + go_up;
                                    multiply[j].insert(multiplication % 10);
                                    go_up = multiplication % 10;
                                }
                            } else {
                                multiplication = multiplication + go_up;
                                multiply[j].insert(multiplication % 10);
                                go_up = multiplication / 10;
                            }
                        }

                        if (go_up > 0) {
                            if (go_up < 10) {
                                multiply[j].insert(go_up);
                            } else {
                                while (go_up != 0) {
                                    multiply[j].insert((go_up % 10));
                                    go_up = go_up / 10;
                                }
                            }
                        }

                        go_up = 0;
                    }

                    for (unsigned int i = 0; i < number_one.size(); i++) {
                        multiply[i].reverse();
                    }

                    for (unsigned int i = 0; i < number_one.size(); i++) {
                        unsigned int total_insert = i;

                        while (total_insert-- > 0) {
                            multiply[i].insert(0);
                        }
                    }

                    for (unsigned int i = 0; i < number_one.size(); i++) {
                        multiply[i].print();
                    }

                    for (int i = (number_one.size()); i > -1; i--) {
                        unsigned int total_insert = - (i - number_one.size());

                        while (total_insert-- > 0) {
                            multiply[i].insert_end(0);
                        }
                    }

                    int total_multiplys = multiply[0].size();
                    go_up = 0;

                    for (unsigned int i = 0; i < number_one.size(); i++) {
                        multiply[i].print();
                    }

                    for (unsigned int i = 0; i < total_multiplys; i++) {
                        int sum = 0;

                        for (unsigned int j = 0; j < number_one.size(); j++) {
                            sum += multiply[j].get_value_digit(i);
                        }

                        if (sum < 10) {
                            if ((sum + go_up) < 10) {
                                result.insert((sum + go_up));
                                go_up = 0;
                            } else {
                                sum = sum + go_up;
                                result.insert(sum % 10);
                                go_up = sum % 10;
                            }
                        } else {
                            sum = sum + go_up;
                            result.insert((sum % 10));
                            go_up = sum / 10;
                        }

                    }

                    if (go_up > 0) {
                        if (go_up < 10) {
                            result.insert(go_up);
                        } else {
                            while (go_up != 0) {
                                result.insert((go_up % 10));
                                go_up = go_up / 10;
                            }
                        }
                    }
                    
                    result.reverse();

                    cout << "MULTIPLICACAO REALIZADA!" << endl;
                }

                break;
            }

            case 'm': {
                char choose_memory;

                cout << "(=) Copiar" << endl;
                cout << "(?) Exibir" << endl;
                cout << "(#) Limpar" << endl;
                cout << "Digite a operacao que deseja realizar: " << endl;
                cin >> choose_memory;
                cout << endl;

                switch (choose_memory) {
                    case '=': {
                        if (result.size() == 0) {
                            cout << "ERRO: Nao foi realizado nenhum calculo para guardar valor!" << endl;
                        } else {
                            memory.clear();

                            for (int i = (result.size() - 1); i > -1; i--) {
                                memory.insert(result.get_value_digit(i));
                            }

                            cout << "VALOR COPIADO PARA MEMORIA!" << endl;
                        }

                        break;
                    }

                    case '?': {
                        if (memory.size() == 0) {
                            cout << "Memoria: 0" << endl;
                        } else {
                            cout << "Memoria: ";
                            memory.print();
                        }

                        break;
                    }

                    case '#': {
                        if (memory.size() == 0) {
                            cout << "ERRO: Nao ha valor em momoria!" << endl;

                            break;
                        } else {
                            cout << "ESTE PROCESSO PODE DEMORAR UM POUCO!" << endl;

                            memory.clear();

                            cout << "MEMORIA LIMPA COM SUCESSO!" << endl;

                            break;
                        }

                        break;
                    }
                }

                break;
            }

            default: {
                menu = false;
                
                break;
            }
        }
    }
    
    return 0;
}