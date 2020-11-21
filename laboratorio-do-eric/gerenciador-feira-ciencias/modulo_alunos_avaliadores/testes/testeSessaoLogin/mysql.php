<?php
//utilização de namespaces
namespace Mysql {
    //declaração de variáres globais
    define('DB_SERVER', 'localhost');
    define('DB_NAME', 'testando');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'qwe123');

    class mysql {
        var $db, $conn;
        public function __construct($server, $database, $username, $password) {
            $this->conn = mysql_connect($server, $username, $password);
            $this->db = mysql_select_db($database, $this->conn);
        }
        /**
         * Função de seleção dos registros da tabela
         * @param string $tabela tabela onde será buscado os registros
         * @param string $colunas string contendo as colunas separadas
por virgula para seleção, se null busca por todas *
         */
        public function select($tabela, $colunas = "*", $where = "1=1") {
            $sql = "SELECT $colunas FROM $tabela $where";
            $result = $this->executar($sql);
            while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
                $return[] = $row;
            }
            return $return;
        }

        /**
         * Função para inserir dados na tabela
         * @param array $dados Array contendo os dados a serem inseridos
         * @param string $tabela tabela que será inserido os dados
         * @return boolean verdadeiro ou falso
         */
        public function insert($tabela, $dados) {

            foreach ($dados as $key => $value) {
                $keys[] = $key;
                $insertvalues[] = '\'' . $value . '\'';
            }
            $keys = implode(',', $keys);
            $insertvalues = implode(',', $insertvalues);
            $sql = "INSERT INTO $tabela ($keys) VALUES ($insertvalues)";
            return $this->executar($sql);
        }
        private function executar($sql) {
            $return_result = mysql_query($sql, $this->conn);
            if ($return_result) {
                return $return_result;
            } else {
                $this->sql_error($sql);
            }
        }
        private function sql_error($sql) {
            echo mysql_error($this->conn) . '<br>';
            die('error: ' . $sql);
        }
    }
}
?>
