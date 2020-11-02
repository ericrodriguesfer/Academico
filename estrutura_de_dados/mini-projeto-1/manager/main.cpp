#include "models/assignment/Assignment.hpp"
#include "models/list/List.hpp"
#include "models/manager/Manager.hpp"
#include <iostream>
#include <string>
#include <limits>

using namespace std;

int main() {
    bool execution_menu = true;
    unsigned int size_list;
    unsigned int choose_menu;
    cout << "Digite o tamanho desejado para sua lista de tarefas: " << endl;
    cin >> size_list;

    Manager manager(size_list);

    while (execution_menu) {
        cout << endl;
        cout << "1 - Adicionar uma tarefa a sua lista" << endl;
        cout << "2 - Remover uma tarefa da sua lita" << endl;
        cout << "3 - Concluir uma tarefa da sua lista" << endl;
        cout << "4 - Reabir uma tarefa ja concluida da sua lista" << endl;
        cout << "5 - Visualizar as tarefas da sua lista" << endl;
        cout << "6 - Ordenar as tarefas na sua lista" << endl;
        cout << "7 - Encerrar e sair" << endl;
        cout << "Digite o numero da opcao de execucao desejada: " << endl;
        cin >> choose_menu;
        cout << endl;

        switch (choose_menu) {
            case 1: {
                if (manager.length_list() == 0 || manager.length_list() > 0) {
                    int id;
                    string description;
                    string creation;
                    string deadline;

                    cout << "Digite um ID desejado para essa nova tarefa: " << endl;;
                    cin >> id;

                    cout << "Digite uma descricao desejada para essa nova tarefa: " << endl;
                    cin.ignore();
                    getline(cin, description);

                    cout << "Digite a data de inicio desejada para essa tarefa (FORMATO: dd/mm/yy): " << endl;
                    getline(cin, creation);

                    cout << "Digite a data de conclusao desejada para essa tarefa (FORMATO: dd/mm/yy): " << endl;
                    getline(cin, deadline);

                    Assignment *assignment = new Assignment(id, description, creation, deadline);

                    manager.insert(assignment);
                    
                    break;
                } else {
                    cout << "ERRO: Falha inesperada na execucao!!!" << endl;
                    
                    break;
                }

                break;
            }

            case 2: {
                if (manager.length_list() == 0) {
                    cout << "ERRO: Para remover tarefas, antes adicione tarefas!!!" << endl;

                    break;
                } else {
                    unsigned int index_remove;

                    manager.print_all();
                    cout << "Digite o indice da tarefa que deseja remover: " << endl;
                    cin >> index_remove;

                    Assignment *assignment = manager.get_assignment(index_remove - 1);
                    Assignment *p = new Assignment(std::numeric_limits<int>::max(), "Default description assignment", "99/99/9999", "99/99/9999");

                    if (assignment == p) {
                        cout << "ERRO: Tarefa para a remocao nao foi encontrada!!!" << endl;

                        break;
                    } else {
                        if (manager.remove(assignment)) {
                            cout << "SUCESSO: A tarefa foi removida com sucesso!!!" << endl;

                            break;
                        } else {
                            cout << "ERRO: Falha ao remover a tarefa!!!" << endl;

                            break;
                        }
                    }

                    break;

                }

                break;
            }

            case 3: {
                if (manager.length_list() == 0) {
                    cout << "ERRO: Para concluir tarefas, antes adicione tarefas!!!" << endl;

                    break;
                } else {
                    if (manager.cout_conclude() == 0) {
                        cout << "ERRO: Nao ha tarefas a concluir!!!" << endl;

                        break;
                    } else {
                        unsigned int index_conclude;

                        manager.print_conclude();
                        cout << "Digite o indice da tarefa que deseja concluir: " << endl;
                        cin >> index_conclude;

                        manager.conclude(index_conclude - 1);

                        break;
                    }

                    break;
                }

                break;
            }

            case 4: {
                if (manager.length_list() == 0) {
                    cout << "ERRO: Para reabrir tarefas, antes adicione tarefas!!!" << endl;

                    break;
                } else {
                    if (manager.cout_concluded() == 0) {
                        cout << "ERRO: Nao ha tarefas a reabrir!!!" << endl;

                        break;
                    } else {
                        unsigned int index_reopen;

                        manager.print_concluded();
                        cout << "Digite o indice da tarefa que deseja reabrir: " << endl;
                        cin >> index_reopen;

                        manager.new_conclude(index_reopen - 1);

                        break;
                    }   

                    break;
                }

                break;
            }

            case 5: {
                if (manager.length_list() == 0) {
                    cout << "ERRO: Para exibir tarefas, antes adicione tarefas!!!" << endl;

                    break;
                } else {
                    unsigned int choose_assignment;
                    cout << endl;
                    cout << "1 - Concluidas" << endl;
                    cout << "2 - A concluir" << endl;
                    cout << "3 - Todas" << endl;
                    cout << "Digite o numero da opcao de queseja executar: " << endl;
                    cin >> choose_assignment;
                    cout << endl;

                    switch (choose_assignment) {
                        case 1: {
                            if (manager.cout_concluded() == 0) {
                                cout << "ERRO: Nao ha tarefas concluidas a exibir!!!" << endl;

                                break;
                            } else {
                                manager.print_concluded();
                                
                                break;
                            }

                            break;
                        }

                        case 2: {
                            if (manager.cout_conclude() == 0) {
                                cout << "ERRO: Nao ha tarefas a concluir a exibir!!!" << endl;

                                break;
                            } else {
                                manager.print_conclude();

                                break;
                            }

                            break;
                        }

                        case 3: {
                            if (manager.length_list() == 0) {
                                cout << "ERRO: Nao ha tarefas a exibir!!!" << endl;

                                break;
                            } else {
                                manager.print_all();

                                break;
                            }

                            break;
                        }

                        default: {
                            cout << "ERRO: Selecione uma opcao valida!!!" << endl;

                            break;
                        }
                    }

                    break;
                }

                break;
            }

            case 6: {
                if (manager.length_list() == 0) {
                    cout << "ERRO: Para ordenar tarefas, antes adicione tarefas!!!" << endl;

                    break;
                } else {
                    unsigned int choose_sort;
                    cout << endl;
                    cout << "1 - Arrastar uma tarefa para cima" << endl;
                    cout << "2 - Arrastar uma tarefa para baixo" << endl;
                    cout << "3 - Ordenar as tarefas pelo ID" << endl;
                    cout << "4 - Trocar duas tarefas de posicao" << endl;
                    cout << "5 - Ordenar as tarefas pela data de criacao" << endl;
                    cout << "6 - Ordenar as tarefas pela data de conclusao" << endl;
                    cout << "7 - Para sair desta sessao" << endl;
                    cout << "Digite o numero da opcao de queseja executar: " << endl;
                    cin >> choose_sort;
                    cout << endl;

                    switch (choose_sort) {
                        case 1: {
                            if (manager.length_list() >= 2) {
                                unsigned int index_elemento_change;
                                unsigned int total_positions;

                                manager.print_up();
                                cout << "Digite o indice da tarefa que deseja subir: " << endl;
                                cin >> index_elemento_change;

                                cout << "Digite o total de posicoes que deseja subir a tarefa: " << endl;
                                cin >> total_positions;

                                manager.sort_up((index_elemento_change - 1), total_positions);

                                break;
                            } else {
                                cout << "ERRO: Para arrastar tarefas, necessita adicionar ao menos duas tarefas!!!" << endl;

                                break;
                            }

                            break;
                        }

                        case 2: {
                            if (manager.length_list() >= 2) {
                                unsigned int index_elemento_change;
                                unsigned int total_positions;

                                manager.print_down();
                                cout << "Digite o indice da tarefa que deseja descer: " << endl;
                                cin >> index_elemento_change;

                                cout << "Digite o total de posicoes que deseja descer a tarefa: " << endl;
                                cin >> total_positions;

                                manager.sort_down((index_elemento_change - 1), total_positions);

                                break;
                            } else {
                                cout << "ERRO: Para arrastar tarefas, necessita adicionar ao menos duas tarefas!!!" << endl;

                                break;
                            }

                            break;
                        }

                        case 3: {
                            if (manager.length_list() < 2) {
                                cout << "ERRO: Para ordenar tarefas por ID, necessita adicionar ao menos de duas tarefas!!!" << endl;

                                break;
                            } else {
                                manager.sort_id();

                                break;
                            }
                            
                            break;
                        }

                        case 4: {
                            if (manager.length_list() >= 3) {
                                unsigned int index_first_change;
                                unsigned int index_second_change;

                                manager.print_swap();
                                cout << "Digite o indice do elemento que deseja mudar: " << endl;
                                cin >> index_first_change;

                                cout << "Digite o indice do outro elemento que deseja mudar: " << endl;
                                cin >> index_second_change;

                                manager.sort_swap((index_first_change - 1), (index_second_change - 1));

                                break;
                            } else {
                                cout << "ERRO: Para trocar tarefas entre si, necessita adicionar ao menos de tres tarefas!!!" << endl;

                                break;
                            }

                            break;
                        }

                        case 5: {
                            if (manager.length_list() < 2) {
                                cout << "ERRO: Para ordenar tarefas por data de criacao, necessita adicionar ao menos duas tarefas!!!" << endl;

                                break;
                            } else {
                                manager.sort_creation();

                                break;
                            }

                            break;
                        }

                        case 6: {
                            if (manager.length_list() < 2) {
                                cout << "ERRO: Para ordenar tarefas por data de conclusao, necessita adicionar ao menos duas tarefas!!!" << endl;

                                break;
                            } else {
                                manager.sort_deadline();

                                break;
                            }

                            break;
                        }

                        default: {
                            cout << "ERRO: Selecione uma opcao valida!!!" << endl;

                            break;
                        }
                    }
                }

                break;
            }

            default: {
                execution_menu = false;

                break;
            }
        }
    }

    return 0;
}