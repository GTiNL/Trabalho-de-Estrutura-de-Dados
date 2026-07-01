import br.edu.biblioteca.model.*;
import br.edu.biblioteca.service.*;
import br.edu.biblioteca.structures.Vetor;

import java.util.Scanner;

// Classe principal do Sistema de Biblioteca (console)
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CatalogoService catalogoService = new CatalogoService();
    private static UsuarioService usuarioService = new UsuarioService();
    private static EmprestimoService emprestimoService = new EmprestimoService(catalogoService, usuarioService);
    private static ReservaService reservaService = new ReservaService(catalogoService, usuarioService);
    private static RelatorioService relatorioService = new RelatorioService(catalogoService, usuarioService, emprestimoService);
    private static UndoRedoService undoRedoService = new UndoRedoService();

    private static int proximoAutorId = 1;
    private static int proximoCategoriaId = 1;

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   SISTEMA DE BIBLIOTECA - Bem-vindo!");
        System.out.println("==============================================");

        carregarDadosExemplo();

        boolean executando = true;
        while (executando) {
            exibirMenuPrincipal();
            int opcao = lerInteiro("Opcao: ");

            if (opcao == 1) {
                menuLivros();
            } else if (opcao == 2) {
                menuUsuarios();
            } else if (opcao == 3) {
                menuEmprestimos();
            } else if (opcao == 4) {
                menuReservas();
            } else if (opcao == 5) {
                menuMultas();
            } else if (opcao == 6) {
                menuRelatorios();
            } else if (opcao == 7) {
                menuUndoRedo();
            } else if (opcao == 8) {
                menuNotificacoes();
            } else if (opcao == 0) {
                System.out.println("\nEncerrando o sistema. Ate logo!");
                executando = false;
            } else {
                System.out.println("  Opcao invalida.");
            }
        }
        scanner.close();
    }

    // ========== MENU PRINCIPAL ==========

    private static void exibirMenuPrincipal() {
        System.out.println("\n============= MENU PRINCIPAL =============");
        System.out.println("  1. Livros e Exemplares");
        System.out.println("  2. Usuarios");
        System.out.println("  3. Emprestimos e Devolucoes");
        System.out.println("  4. Reservas");
        System.out.println("  5. Multas");
        System.out.println("  6. Relatorios");
        System.out.println("  7. Desfazer / Refazer (Undo/Redo)");
        System.out.println("  8. Notificacoes");
        System.out.println("  0. Sair");
        System.out.println("===========================================");
    }
