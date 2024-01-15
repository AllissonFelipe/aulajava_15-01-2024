import java.sql.*;
import java.util.*;

public class CreateMySQLInteract {
    public static void main(String[] args) {
        String status = "Nada aconteceu ainda", strNomeCampo, strCreateTable, strNomeTabela, resp;
        boolean sair = false;
        Scanner teclado = new Scanner(System.in);
        String str1 = "CREATE TABLE `mysql_connector`.`";
        String str2 = "` (`id` INT NOT NULL AUTO_INCREMENT, `";
        String str3 = "` VARCHAR(255) NULL, PRIMARY KEY (`id`));";
        
        while (sair == false) {
            try {
                System.out.println("Criação de Tabelas no banco de dados.");
                System.out.println("Digite o nome da tabela:");
                strNomeTabela = teclado.nextLine();
                System.out.println("Digite o nome do campo:");
                strNomeCampo = teclado.nextLine();
                strCreateTable = str1 + strNomeTabela + str2 + strNomeCampo + str3;
                Connection conn = App.conectar();
                Statement stmSql = conn.createStatement();
                stmSql.addBatch(strCreateTable);
                stmSql.executeBatch();
                stmSql.close();
                status = "Ok! Tabela criada com sucesso";
                System.out.println(status);
                System.out.println(strCreateTable);
                System.out.println("Deseja criar outra tabela? [c] para continuar ou [s] para sair.");
                resp = teclado.nextLine();
                switch (resp) {
                    case "c":
                        sair = false;
                        break;
                    case "s":
                        sair = true;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.err.println("Ops! Ocorreu o erro " + e);
            }   
        }
        teclado.close();
    }   
}
